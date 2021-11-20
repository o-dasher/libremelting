package com.dasher.meltinglight.Graphics.Scene2d;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;

public class ActorUtils {
    private final Viewport defaultViewport;

    public ActorUtils(Viewport defaultViewport) {
        this.defaultViewport = defaultViewport;
    }

    private Viewport switchViewport(Actor actor) {
        return actor.getStage() == null? defaultViewport : actor.getStage().getViewport();
    }

    private float getCenter(float twh, float awh) {
        return twh / 2 - awh / 2;
    }

    public float getCenterX(Actor actor, Viewport viewport) {
        return getCenter(viewport.getWorldWidth(), actor.getWidth());
    }

    public float getCenterX(Actor actor) {
        return getCenterX(actor, switchViewport(actor));
    }

    public float getCenterY(Actor actor, Viewport viewport) {
        return getCenter(viewport.getWorldHeight(), actor.getHeight());
    }

    public float getCenterY(Actor actor) {
        return getCenterY(actor, switchViewport(actor));
    }

    public void centerActor(Actor actor) {
        Viewport viewport = switchViewport(actor);
        actor.setPosition(getCenterX(actor, viewport), getCenterY(actor, viewport));
    }
}
