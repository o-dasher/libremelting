package com.dasher.meltinglight.Screens.Menu;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.dasher.meltinglight.Graphics.Scene2d.GameStage;
import com.dasher.meltinglight.Interfaces.GameWrapper;
import com.dasher.meltinglight.MeltingLight;

import lombok.Getter;

public class MainMenuFrontStage extends GameStage implements GameWrapper {
    private final @Getter MeltingLight game;

    public MainMenuFrontStage(MeltingLight game) {
        super(game);

        this.game = game;
        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = getAssets().getFonts().mainFont.get();

        MainMenuLabel playLabel = new MainMenuLabel(game,"PLAY",labelStyle);
        addActor(playLabel);
    }
}
