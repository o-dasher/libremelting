package com.dasher.meltinglight.Graphics.Scene2d;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.dasher.meltinglight.MeltingLight;

public abstract class GameStage extends Stage {
    protected MeltingLight game;

    public GameStage(MeltingLight game) {
        super(game.getViewport());
        this.game = game;
    }
}
