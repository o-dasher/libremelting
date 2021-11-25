package com.dasher.meltinglight.Graphics.Scene2d.Actors;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import javax.annotation.Nullable;

public interface ScalerUtil<T extends Actor> {
    ClickListener getScaleHoverListener(
            T actor, float scaleBy, float duration,
            @Nullable Runnable onEnter, @Nullable Runnable onExit
    );
    default ClickListener getScaleHoverListener(T actor, float scaleBy) {
        return getScaleHoverListener(actor, scaleBy, 0, null, null);
    }
}
