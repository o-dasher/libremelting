package com.dasher.meltinglight.Screens.Intro;

import com.dasher.meltinglight.MeltingLight;
import com.dasher.meltinglight.Graphics.Scene2d.GameStage;

public class IntroStage extends GameStage {
    public IntroStage(MeltingLight game) {
        super(game);
        addActor(new IntroLogo(game, game.getAssets().getTextures().intro.logo.get()));
    }
}