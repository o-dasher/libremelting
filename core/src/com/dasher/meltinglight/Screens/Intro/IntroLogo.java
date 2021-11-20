package com.dasher.meltinglight.Screens.Intro;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Align;
import com.dasher.meltinglight.MeltingLight;


public class IntroLogo extends Image {
    public IntroLogo(MeltingLight game, Texture texture) {
        super(texture);
        game.actorUtils.centerActor(this);
        setOrigin(Align.center);
        setScale(8);
        addAction(Actions.scaleBy(2, 2,   1));
    }
}
