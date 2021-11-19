package com.dasher.meltinglight.Graphics.Scene2d;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;

public class ActorUtils {
    private final Viewport defaultViewport;

    public ActorUtils(Viewport defaultViewport) {
        this.defaultViewport = defaultViewport;
    }

    public void centerActor(Actor actor) {
        Stage stage = actor.getStage();
        Viewport viewport = stage == null? defaultViewport : stage.getViewport();
        actor.setPosition(
                viewport.getWorldWidth() / 2 - actor.getWidth() / 2,
                viewport.getWorldHeight() / 2 - actor.getHeight() / 2
        );
    }
}
