package com.dasher.meltinglight.Screens.Menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Scaling;
import com.dasher.meltinglight.Graphics.Interfaces.ResizeListener;
import com.dasher.meltinglight.MeltingLight;

public class MainMenuBackground extends Image implements ResizeListener {
    protected MeltingLight game;


    public MainMenuBackground(MeltingLight game, Texture texture) {
        super(texture);
        this.game = game;
        setOrigin(Align.center);
        setAlign(Align.center);
        setScaling(Scaling.fill);
        resize(game.getViewport().getWorldWidth(), game.getViewport().getWorldHeight());
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        addAction(Actions.moveTo(getParallaxX(), getParallaxY(), 1 / 10f));
    }

    private float getParallaxXY(float center, float ixy, float swh) {
        float parallaxMultiplier = 25;
        return center - ixy / swh * parallaxMultiplier;
    }

    private float getParallaxX() {
        return getParallaxXY(
                game.getActorUtils().getCenterX(this),
                Gdx.input.getX(),
                getStage().getViewport().getWorldWidth()
        );
    }

    private float getParallaxY() {
        return getParallaxXY(
                game.getActorUtils().getCenterY(this),
                Gdx.input.getY(),
                getStage().getViewport().getWorldHeight()
        );
    }

    @Override
    public void resize(float width, float height) {
        setSize(width, height);
    }
}
