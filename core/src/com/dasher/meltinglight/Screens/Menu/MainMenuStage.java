package com.dasher.meltinglight.Screens.Menu;

import com.crashinvaders.vfx.effects.BloomEffect;
import com.crashinvaders.vfx.effects.FilmGrainEffect;
import com.crashinvaders.vfx.effects.OldTvEffect;
import com.crashinvaders.vfx.effects.WaterDistortionEffect;
import com.dasher.meltinglight.Graphics.Interfaces.ResizeListener;
import com.dasher.meltinglight.Graphics.Scene2d.GameStage;
import com.dasher.meltinglight.MeltingLight;

public class MainMenuStage extends GameStage implements ResizeListener {
    protected MainMenuBackground background;

    public MainMenuStage(MeltingLight game) {
        super(game);
        addEffect(new WaterDistortionEffect(1, 1));
        addEffect(new FilmGrainEffect());
        addEffect(new OldTvEffect());
        addEffect(new BloomEffect());
        addActor(background = new MainMenuBackground(game, game.getAssets().getTextures().getMenu().menuBackground.get()));
    }

    @Override
    public void resize(float width, float height) {
        background.resize(width, height);
    }
}
