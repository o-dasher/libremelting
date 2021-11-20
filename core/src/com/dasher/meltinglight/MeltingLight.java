package com.dasher.meltinglight;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.dasher.meltinglight.Assets.GameAssetManager;
import com.dasher.meltinglight.Audio.AudioCreator;
import com.dasher.meltinglight.Graphics.ShapeRendering.FadeBlock;
import com.dasher.meltinglight.IO.FileExtensions;
import com.dasher.meltinglight.IO.SysPrinter;
import com.dasher.meltinglight.Graphics.Scene2d.ActorUtils;
import com.dasher.meltinglight.Screens.Intro.IntroScreen;
import com.dasher.meltinglight.Settings.GameSettings;

import java.util.Locale;

public class MeltingLight extends Game {
	public final int WORLD_WIDTH = 800;
	public final int WORLD_HEIGHT = 600;
	public SysPrinter sysPrinter;
	public FileExtensions fileExtensions;
	public GameAssetManager assets;
	public Viewport viewport;
	public ActorUtils actorUtils;
	public SpriteBatch batch;
	public FadeBlock fadeBlock;
	public ShapeRenderer shapeRenderer;
	public GameSettings gameSettings;
	public AudioCreator audioCreator;
	public Preferences preferences;
	
	@Override
	public void create () {
		preferences = Gdx.app.getPreferences(getClass().getSimpleName().toLowerCase(Locale.ROOT));
		sysPrinter = new SysPrinter();
		gameSettings = new GameSettings(this);
		gameSettings.load();
		gameSettings.save();
		audioCreator = new AudioCreator(gameSettings.getAudio());
		fileExtensions = new FileExtensions();
		viewport = new ExtendViewport(WORLD_WIDTH, WORLD_HEIGHT);
		shapeRenderer = new ShapeRenderer();
		actorUtils = new ActorUtils(viewport);
		batch = new SpriteBatch();
		fadeBlock = new FadeBlock(Color.BLACK, shapeRenderer, viewport);
		assets = new GameAssetManager(this);
		assets.initPacks();
		assets.load();
	}

	@Override
	public void render () {
		final float delta = Gdx.graphics.getDeltaTime();

		ScreenUtils.clear(Color.BLACK);

		if (assets.update()) {
			if (getScreen() == null) {
				setScreen(new IntroScreen(this));
			}
		}

		super.render();

		if (fadeBlock.isFading()) {
			fadeBlock.update(delta);
		}
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
		viewport.update(width, height);
	}

	@Override
	public void dispose () {
		assets.dispose();
		batch.dispose();
	}

	@Override
	public void setScreen(Screen screen) {
		super.setScreen(screen);
		sysPrinter.printNew(Screen.class, screen.getClass().getSimpleName());
	}

	public void setScreen(final Screen screen, float fadeTime) {
		fadeBlock.setPeriod(fadeTime);
		fadeBlock.setFade(true);
		fadeBlock.setFadeInTask(new Runnable() {
			@Override
			public void run() {
				setScreen(screen);
			}
		});
	}
}
