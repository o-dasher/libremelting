package com.dasher.meltinglight.Screens;

import com.badlogic.gdx.Screen;

import com.dasher.meltinglight.MeltingLight;
import com.dasher.meltinglight.GameContainer;

import de.eskalon.commons.screen.ManagedScreen;
import lombok.Getter;

public abstract class GameScreen extends ManagedScreen implements Screen, GameContainer {
    protected @Getter MeltingLight game;

    public GameScreen(MeltingLight game) {
        this.game = game;
    }

    public abstract String getName();

    @Override
    public void show() {
        clearScreenSpecifics();
        super.show();
    }
}
