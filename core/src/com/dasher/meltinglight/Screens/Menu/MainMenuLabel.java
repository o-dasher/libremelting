package com.dasher.meltinglight.Screens.Menu;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;
import com.dasher.meltinglight.Graphics.Interfaces.ResizeListener;
import com.dasher.meltinglight.Graphics.Scene2d.OutlinedLabel;
import com.dasher.meltinglight.MeltingLight;
import com.dasher.meltinglight.GameContainer;

import lombok.Getter;

public class MainMenuLabel extends OutlinedLabel implements GameContainer, ResizeListener {
    private final @Getter MeltingLight game;

    public MainMenuLabel(MeltingLight game, String text, Label.LabelStyle style) {
        super(text, style);
        this.game = game;
        getFrontLine().setFontScale(4);
        getOutLine().setColor(Color.RED);
        getFrontLine().setAlignment(Align.center);
        getFrontLine().addListener(getActorUtils().getLabels().getScaleHoverListener(getFrontLine(), 0.1f));
        addLabels();
        resize(getViewport());
    }

    @Override
    public void layout() {
        getActorUtils().centerActorX(getFrontLine());
        super.layout();
    }

    @Override
    public void resize(float width, float height) {
        layout();
    }
}
