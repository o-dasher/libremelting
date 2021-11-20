package com.dasher.meltinglight.Screens;

import com.badlogic.gdx.Screen;
import com.dasher.meltinglight.Interfaces.GameWrapper;
import com.dasher.meltinglight.MeltingLight;

import lombok.Getter;

public abstract class GameScreen implements Screen, GameWrapper {
    protected @Getter MeltingLight game;

    public GameScreen(MeltingLight game) {
        this.game = game;
    }
}
