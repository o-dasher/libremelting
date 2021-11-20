package com.dasher.meltinglight.Screens.Intro;

import com.crashinvaders.vfx.effects.BloomEffect;
import com.crashinvaders.vfx.effects.CrtEffect;
import com.crashinvaders.vfx.effects.FilmGrainEffect;
import com.crashinvaders.vfx.effects.LensFlareEffect;
import com.crashinvaders.vfx.effects.LevelsEffect;
import com.dasher.meltinglight.MeltingLight;
import com.dasher.meltinglight.Graphics.Scene2d.GameStage;

public class IntroStage extends GameStage {
    public IntroStage(MeltingLight game) {
        super(game);
        addEffect(new LensFlareEffect());
        addEffect(new BloomEffect());
        addEffect(new FilmGrainEffect());
        addEffect(new CrtEffect());
        addActor(new IntroLogo(game, game.getAssets().getTextures().getIntro().logo.get()));
    }
}