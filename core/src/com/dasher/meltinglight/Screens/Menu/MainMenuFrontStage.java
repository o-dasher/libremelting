package com.dasher.meltinglight.Screens.Menu;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Array;
import com.dasher.meltinglight.Graphics.Interfaces.ResizeListener;
import com.dasher.meltinglight.Graphics.Scene2d.GameStage;
import com.dasher.meltinglight.Input.RectClickableData;
import com.dasher.meltinglight.Interfaces.ShowAble;
import com.dasher.meltinglight.MeltingLight;
import com.dasher.meltinglight.GameContainer;

import lombok.Getter;

public class MainMenuFrontStage extends GameStage implements GameContainer, ResizeListener, ShowAble {
    private final @Getter MeltingLight game;
    private float currentLabelY;
    private boolean firstLabel = true;
    private final Array<MainMenuLabel> labels = new Array<>();
    private final MainMenuLabel playLabel;
    private final MainMenuLabel optionsLabel;

    public MainMenuFrontStage(MeltingLight game) {
        super(game);

        this.game = game;
        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = getAssets().getFonts().mainFont.get();

        playLabel = new MainMenuLabel(game,"PLAY",labelStyle);
        optionsLabel = new MainMenuLabel(game, "OPTIONS", labelStyle);

        addLabel(playLabel);
        addLabel(optionsLabel);
    }

    protected void addLabel(MainMenuLabel label) {
        addActor(label);
        labels.add(label);

        showLabel(label);
        RectClickableData data = getRectBasedClickHandler().getRectClickableDataFor(label.getFrontLine());

        if (firstLabel) {
            currentLabelY = getActorUtils().getCenterY(label);
        } else {
            currentLabelY -= data.getRectangle().height * 2;
        }

        label.getFrontLine().setY(currentLabelY);
        label.layout();

        getRectBasedClickHandler().updateRectangle(label.getFrontLine(), data.getRectangle());
        firstLabel = false;
    }

    @Override
    public void resize(float width, float height) {
        playLabel.resize(getViewport());
        optionsLabel.resize(getViewport());
    }

    private void showLabel(MainMenuLabel label) {
        getRectBasedClickHandler().addActor(label.getFrontLine());
    }

    @Override
    public void show() {
        for (MainMenuLabel label: labels) {
            showLabel(label);
        }
    }
}
