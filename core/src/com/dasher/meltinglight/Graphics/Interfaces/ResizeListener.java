package com.dasher.meltinglight.Graphics.Interfaces;

import com.badlogic.gdx.utils.viewport.Viewport;

public interface ResizeListener {
    void resize(float width, float height);
    default void resize(Viewport viewport) {
        resize(viewport.getWorldWidth(), viewport.getWorldHeight());
    }
}
