package com.dasher.meltinglight.Screens;

import com.badlogic.gdx.Screen;
import com.dasher.meltinglight.MeltingLight;

public abstract class GameScreen implements Screen {
    protected MeltingLight game;

    public GameScreen(MeltingLight game) {
        this.game = game;
    }
}
