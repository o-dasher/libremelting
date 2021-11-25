package com.dasher.meltinglight.Graphics.Scene2d.Actors;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ObjectMap;

import javax.annotation.Nullable;

public class LabelUtils implements ScalerUtil<Label> {
    private final ActorUtils parent;

    public LabelUtils(ActorUtils parent) {
        this.parent = parent;
    }

    @Override
    public ClickListener getScaleHoverListener(Label actor, float scaleBy, float duration, @Nullable Runnable onEnter, @Nullable Runnable onExit) {
        return new ClickListener() {
            @Override
            public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
                actor.setFontScale(actor.getFontScaleX() + scaleBy, actor.getFontScaleY() + scaleBy);
                if (onEnter != null) onEnter.run();
            }
            @Override
            public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
                actor.setFontScale(actor.getFontScaleX() - scaleBy, actor.getFontScaleY() - scaleBy);
                if (onExit != null) onExit.run();
            }
        };
    }
}
