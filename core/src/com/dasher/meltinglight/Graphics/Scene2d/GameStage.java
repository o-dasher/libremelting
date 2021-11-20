package com.dasher.meltinglight.Graphics.Scene2d;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.crashinvaders.vfx.effects.ChainVfxEffect;
import com.dasher.meltinglight.Interfaces.GameWrapper;
import com.dasher.meltinglight.MeltingLight;

import lombok.Getter;

public abstract class GameStage extends Stage implements GameWrapper {
    private final Array<ChainVfxEffect> effects = new Array<>();
    private final @Getter MeltingLight game;

    public GameStage(MeltingLight game) {
        super(game.getViewport());
        this.game = game;
    }

    protected void addEffect(ChainVfxEffect effect) {
        effects.add(effect);
    }

    @Override
    public void draw() {
        getVfxManager().beginInputCapture();
        for (ChainVfxEffect effect: effects) {
            getVfxManager().addEffect(effect);
        }
        super.draw();
        getVfxManager().endInputCapture();
        getVfxManager().applyEffects();
        getVfxManager().renderToScreen();
        for (ChainVfxEffect effect: effects) {
            getVfxManager().removeEffect(effect);
        }
    }

    @Override
    public void dispose() {
        super.dispose();
        for (ChainVfxEffect effect: effects) {
            effect.dispose();
        }
    }
}
