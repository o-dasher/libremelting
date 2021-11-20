package com.dasher.meltinglight.Graphics.Scene2d;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.dasher.meltinglight.Graphics.Interfaces.LayoutAble;

import lombok.Getter;
import lombok.Setter;

public class OutlinedLabel extends Group implements LayoutAble {
    private @Getter @Setter float outLineSize = 0.1f;
    private final @Getter Label outLine;
    private final @Getter Label frontLine;

    public OutlinedLabel(String text, Label.LabelStyle style) {
        outLine = new Label(text, style);
        frontLine = new Label(text, style);
        outLine.setColor(Color.BLACK);
        addActor(outLine);
        addActor(frontLine);
    }

    @Override
    public void layout() {
        outLine.setSize(frontLine.getWidth(), frontLine.getHeight());
        outLine.setAlignment(frontLine.getLabelAlign());
        outLine.setBounds(frontLine.getX(), frontLine.getY(), frontLine.getWidth(), frontLine.getHeight());
        outLine.setPosition(frontLine.getX(), frontLine.getY());
        outLine.setScale(
                frontLine.getScaleX() * (1 + outLineSize),
                frontLine.getScaleY() * (1 + outLineSize)
        );
        outLine.setFontScale(
                frontLine.getFontScaleX() * (1 + outLineSize),
                frontLine.getFontScaleY() * (1 + outLineSize)
        );
    }

}
