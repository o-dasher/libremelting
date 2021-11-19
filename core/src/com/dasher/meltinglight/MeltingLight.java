package com.dasher.meltinglight;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.dasher.meltinglight.Assets.GameAssetManager;
import com.dasher.meltinglight.Graphics.ShapeRendering.FadeBlock;
import com.dasher.meltinglight.IO.FileExtensions;
import com.dasher.meltinglight.IO.SysPrinter;
import com.dasher.meltinglight.Graphics.Scene2d.ActorUtils;
import com.dasher.meltinglight.Screens.Intro.IntroScreen;

public class MeltingLight extends Game {
	public int WORLD_WIDTH = 800;
	public int WORLD_HEIGHT = 600;
	public SysPrinter sysPrinter;
	public FileExtensions fileExtensions;
	public GameAssetManager assets;
	public Viewport viewport;
	public ActorUtils actorUtils;
	public SpriteBatch batch;
	public FadeBlock fadeBlock;
	public ShapeRenderer shapeRenderer;
	
	@Override
	public void create () {
		fileExtensions = new FileExtensions();
		sysPrinter = new SysPrinter();
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
