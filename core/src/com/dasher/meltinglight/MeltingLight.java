package com.dasher.meltinglight;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.crashinvaders.vfx.VfxManager;
import com.dasher.meltinglight.Assets.GameAssetManager;
import com.dasher.meltinglight.Audio.AudioCreator;
import com.dasher.meltinglight.Constants.WorldConstants;
import com.dasher.meltinglight.Graphics.Scene2d.Actors.ActorUtils;
import com.dasher.meltinglight.Graphics.ShapeRendering.FadeBlock;
import com.dasher.meltinglight.IO.FileExtensions;
import com.dasher.meltinglight.IO.SysPrinter;
import com.dasher.meltinglight.Input.RectBasedClickHandler;
import com.dasher.meltinglight.Screens.GameScreen;
import com.dasher.meltinglight.Screens.Intro.IntroScreen;
import com.dasher.meltinglight.Screens.ScreenNames;
import com.dasher.meltinglight.Screens.TransitionNames;
import com.dasher.meltinglight.Settings.GameSettings;

import java.util.Locale;

import box2dLight.RayHandler;
import de.eskalon.commons.core.ManagedGame;
import de.eskalon.commons.screen.transition.ScreenTransition;
import de.eskalon.commons.utils.BasicInputMultiplexer;
import lombok.Getter;

public class MeltingLight extends ManagedGame<GameScreen, ScreenTransition> implements GameContainer {
	private @Getter World world;
	private @Getter SysPrinter sysPrinter;
	private @Getter FileExtensions fileExtensions;
	private @Getter GameAssetManager assets;
	private @Getter Viewport viewport;
	private @Getter ActorUtils actorUtils;
	private @Getter SpriteBatch spriteBatch;
	private @Getter FadeBlock fadeBlock;
	private @Getter ShapeRenderer shapeRenderer;
	private @Getter GameSettings gameSettings;
	private @Getter AudioCreator audioCreator;
	private @Getter Preferences preferences;
	private @Getter VfxManager vfxManager;
	private @Getter BasicInputMultiplexer inputMultiplexer;
	private @Getter ScreenNames screenNames;
	private @Getter TransitionNames transitionNames;
	private @Getter Box2DDebugRenderer debugRenderer;
	private @Getter RayHandler rayHandler;
	private @Getter RectBasedClickHandler rectBasedClickHandler;
	private @Getter MeltingLight game;
	private WorldConstants worldConstants;
	public static @Getter MeltingLight instance;
	
	@Override
	public void create () {
		super.create();

		int WORLD_WIDTH = 800;
		int WORLD_HEIGHT = 600;

		game = this;
		instance = this;
		world = new World(new Vector2(0, -10), true);
		worldConstants = new WorldConstants();
		rayHandler = new RayHandler(world);
		rayHandler.setShadows(true);
		rayHandler.setAmbientLight(Color.BLACK);
		rayHandler.setBlurNum(3);
		debugRenderer = new Box2DDebugRenderer();
		vfxManager = new VfxManager(Pixmap.Format.RGBA8888);
		preferences = Gdx.app.getPreferences(getClass().getSimpleName().toLowerCase(Locale.ROOT));
		sysPrinter = new SysPrinter();
		gameSettings = new GameSettings(this);
		gameSettings.load();
		gameSettings.save();
		inputMultiplexer = new BasicInputMultiplexer();
		audioCreator = new AudioCreator(gameSettings.getAudio());
		fileExtensions = new FileExtensions();
		viewport = new ExtendViewport(WORLD_WIDTH, WORLD_HEIGHT);
		shapeRenderer = new ShapeRenderer();
		rectBasedClickHandler = new RectBasedClickHandler(viewport);
		rectBasedClickHandler.setDebugShapeRender(shapeRenderer);
		rectBasedClickHandler.setDebug(false);
		actorUtils = new ActorUtils(viewport);
		spriteBatch = new SpriteBatch();
		fadeBlock = new FadeBlock(Color.BLACK, shapeRenderer);
		assets = new GameAssetManager(this);
		assets.initPacks();
		assets.load();
		transitionNames = new TransitionNames();
		screenNames = new ScreenNames();
		screenManager.addScreen(screenNames.intro, new IntroScreen(this));
	}

	@Override
	public void render () {
		final float delta = Gdx.graphics.getDeltaTime();

		ScreenUtils.clear(Color.BLACK);

		if (assets.update()) {
			if (screenManager.getCurrentScreen() == null) {
				screenManager.pushScreen(screenNames.intro, null);
			}
		}

		vfxManager.cleanUpBuffers();
		shapeRenderer.setProjectionMatrix(viewport.getCamera().combined);
		super.render();
		rectBasedClickHandler.update(delta);

		if (fadeBlock.isFading()) {
			fadeBlock.update(delta);
		}

		boolean stepped = fixedStep(delta);

		debugRenderer.render(world, viewport.getCamera().combined);
		rayHandler.setCombinedMatrix((OrthographicCamera) viewport.getCamera());

		if (stepped) {
			rayHandler.update();
		}

		rayHandler.render();
	}

	private float physicsTimeLeft;

	private boolean fixedStep(float delta) {
		physicsTimeLeft += delta;
		physicsTimeLeft = Math.min(physicsTimeLeft, worldConstants.MAX_TIME_PER_FRAME);

		boolean stepped = false;

		while (physicsTimeLeft >= worldConstants.TIME_STEP) {
			world.step(worldConstants.TIME_STEP, worldConstants.VELOCITY_ITERS, worldConstants.POSITION_ITERS);
			physicsTimeLeft -= worldConstants.TIME_STEP;
			stepped = true;
		}

		return stepped;
	}

	@Override
	public void resize(int width, int height) {
		viewport.update(width, height);
		if (screenManager != null) {
			super.resize(width, height);
		}
	}

	@Override
	public void dispose () {
		assets.dispose();
		spriteBatch.dispose();
		vfxManager.dispose();
		rayHandler.dispose();
	}

	public void clearScreenSpecifics() {
		inputMultiplexer.clear();
		rectBasedClickHandler.clearActors();
	}
}
