package com.dasher.meltinglight;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.dasher.meltinglight.Assets.GameAssetManager;
import com.dasher.meltinglight.IO.FileExtensions;
import com.dasher.meltinglight.IO.SysPrinter;
import com.dasher.meltinglight.Screens.Intro.IntroScreen;

public class MeltingLight extends Game {
	public int WORLD_WIDTH = 800;
	public int WORLD_HEIGHT = 600;
	public SysPrinter sysPrinter;
	public FileExtensions fileExtensions;
	public GameAssetManager assets;
	public Viewport viewport;
	public SpriteBatch batch;
	
	@Override
	public void create () {
		fileExtensions = new FileExtensions();
		sysPrinter = new SysPrinter();
		viewport = new ExtendViewport(WORLD_WIDTH, WORLD_HEIGHT);
		batch = new SpriteBatch();
		assets = new GameAssetManager(this);
		assets.load();
	}

	@Override
	public void render () {
		ScreenUtils.clear(Color.BLACK);
		if (assets.update()) {
			if (getScreen() == null) {
				setScreen(new IntroScreen(this));
			}
		}
		super.render();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
		viewport.update(width, height);
	}

	@Override
	public void dispose () {
		batch.dispose();
	}

	@Override
	public void setScreen(Screen screen) {
		super.setScreen(screen);
		sysPrinter.printNew(Screen.class, screen.getClass().getSimpleName());
	}
}
