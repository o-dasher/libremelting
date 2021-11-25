package com.dasher.meltinglight.Graphics.Scene2d.Actors;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.dasher.meltinglight.Graphics.Scene2d.Axis;

import javax.annotation.Nullable;

import lombok.Getter;

public class ActorUtils implements ScalerUtil<Actor> {
    private final Viewport defaultViewport;
    private final @Getter LabelUtils labels;

    public ActorUtils(Viewport defaultViewport) {
        this.defaultViewport = defaultViewport;
        labels = new LabelUtils(this);
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

    public void centerActor(Actor actor, Axis[] axes) {
        boolean centerX = false;
        boolean centerY = false;
        for (Axis axis: axes) {
            if (centerX && centerY) {
                break;
            } else {
                if (axis == Axis.x) {
                    centerX = true;
                } else if (axis == Axis.y) {
                    centerY = true;
                }
            }
        }
        Viewport viewport = switchViewport(actor);
        actor.setPosition(
                centerX? getCenterX(actor, viewport) : actor.getX(),
                centerY? getCenterY(actor, viewport) : actor.getY()
        );
    }

    public void centerActor(Actor actor) {
        centerActor(actor, new Axis[]{Axis.x, Axis.y});
    }

    public void centerActorX(Actor actor) {
        centerActor(actor, new Axis[]{Axis.x});
    }

    public void centerActorY(Actor actor) {
        centerActor(actor, new Axis[]{Axis.y});
    }

    @Override
    public ClickListener getScaleHoverListener(Actor actor, float scaleBy, float duration, @Nullable Runnable onEnter, @Nullable Runnable onExit) {
        return new ClickListener() {
            @Override
            public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
                actor.addAction(Actions.scaleBy(scaleBy, scaleBy));
                if (onEnter != null) onEnter.run();
            }
            @Override
            public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
                actor.addAction(Actions.scaleBy(-scaleBy, -scaleBy));
                if (onExit != null) onExit.run();
            }
        };
    }
}
