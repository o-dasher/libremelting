package com.dasher.meltinglight.Screens.Menu;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;
import com.dasher.meltinglight.Graphics.Scene2d.OutlinedLabel;
import com.dasher.meltinglight.Interfaces.GameWrapper;
import com.dasher.meltinglight.MeltingLight;

import lombok.Getter;

public class MainMenuLabel extends OutlinedLabel implements GameWrapper {
    private final @Getter MeltingLight game;

    public MainMenuLabel(MeltingLight game, String text, Label.LabelStyle style) {
        super(text, style);
        this.game = game;
        getFrontLine().setFontScale(4);
        getOutLine().setColor(Color.RED);
        getActorUtils().centerActor(getFrontLine());
        getFrontLine().setAlignment(Align.center);
        layout();
    }
}
