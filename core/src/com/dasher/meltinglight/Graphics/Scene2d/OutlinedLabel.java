package com.dasher.meltinglight.Graphics.Scene2d;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Array;
import com.dasher.meltinglight.Graphics.Interfaces.LayoutAble;

import lombok.Getter;
import lombok.Setter;

public class OutlinedLabel extends Group implements LayoutAble {
    private @Getter @Setter float outLineSize = 0.05f;
    private final @Getter Array<Label> labels = new Array<>();
    private final @Getter Label outLine;
    private final @Getter Label frontLine;

    public OutlinedLabel(String text, Label.LabelStyle style) {
        outLine = new Label(text, style);
        frontLine = new Label(text, style);
        labels.add(outLine);
        labels.add(frontLine);
        outLine.setColor(Color.BLACK);
    }

    public void addLabels() {
        addActor(outLine);
        addActor(frontLine);
    }

    @Override
    public void layout() {
        outLine.setSize(frontLine.getWidth(), frontLine.getHeight());
        outLine.setAlignment(frontLine.getLabelAlign());
        outLine.setBounds(frontLine.getX(), frontLine.getY(), frontLine.getWidth(), frontLine.getHeight());
        outLine.setPosition(frontLine.getX(), frontLine.getY());
        float multiplier = (1 + outLineSize);
        outLine.setScale(
                frontLine.getScaleX() * multiplier,
                frontLine.getScaleY() * multiplier
        );
        outLine.setFontScale(
                frontLine.getFontScaleX() * multiplier,
                frontLine.getFontScaleY() * multiplier
        );
    }

}
