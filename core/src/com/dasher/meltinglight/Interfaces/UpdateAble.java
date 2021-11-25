package com.dasher.meltinglight.Interfaces;

import com.badlogic.gdx.Gdx;

public interface UpdateAble {
    void update(float delta);
    default void update() {
        update(Gdx.graphics.getDeltaTime());
    }
}
