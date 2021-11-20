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

import lombok.Getter;

public class MeltingLight extends Game {
	private @Getter SysPrinter sysPrinter;
	private @Getter FileExtensions fileExtensions;
	private @Getter GameAssetManager assets;
	private @Getter Viewport viewport;
	private @Getter ActorUtils actorUtils;
	private @Getter SpriteBatch batch;
	private @Getter FadeBlock fadeBlock;
	private @Getter ShapeRenderer shapeRenderer;
	private @Getter GameSettings gameSettings;
	private @Getter AudioCreator audioCreator;
	private @Getter Preferences preferences;
	
	@Override
	public void create () {
		int WORLD_WIDTH = 800;
		int WORLD_HEIGHT = 600;

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
