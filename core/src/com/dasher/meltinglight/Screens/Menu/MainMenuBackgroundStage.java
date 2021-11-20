package com.dasher.meltinglight.Screens.Menu;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;
import com.crashinvaders.vfx.effects.BloomEffect;
import com.crashinvaders.vfx.effects.FilmGrainEffect;
import com.crashinvaders.vfx.effects.GaussianBlurEffect;
import com.crashinvaders.vfx.effects.OldTvEffect;
import com.crashinvaders.vfx.effects.WaterDistortionEffect;
import com.dasher.meltinglight.Graphics.Interfaces.ResizeListener;
import com.dasher.meltinglight.Graphics.Scene2d.GameStage;
import com.dasher.meltinglight.MeltingLight;

public class MainMenuBackgroundStage extends GameStage implements ResizeListener {
    protected MainMenuBackground background;

    public MainMenuBackgroundStage(MeltingLight game) {
        super(game);
        addEffect(new WaterDistortionEffect(1, 1));
        addEffect(new FilmGrainEffect());
        addEffect(new OldTvEffect());
        addEffect(new BloomEffect());
        addEffect(new GaussianBlurEffect(GaussianBlurEffect.BlurType.Gaussian5x5b));
        addActor(background = new MainMenuBackground(game, game.getAssets().getTextures().getMenu().menuBackground.get()));
    }

    @Override
    public void resize(float width, float height) {
        background.resize(width, height);
    }
}
