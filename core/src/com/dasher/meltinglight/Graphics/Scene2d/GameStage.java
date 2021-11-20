package com.dasher.meltinglight.Graphics.Scene2d;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.crashinvaders.vfx.effects.ChainVfxEffect;
import com.dasher.meltinglight.MeltingLight;

public abstract class GameStage extends Stage {
    private final Array<ChainVfxEffect> effects = new Array<>();
    protected MeltingLight game;

    public GameStage(MeltingLight game) {
        super(game.getViewport());
        this.game = game;
    }

    protected void addEffect(ChainVfxEffect effect) {
        effects.add(effect);
    }

    @Override
    public void draw() {
        game.getVfxManager().beginInputCapture();
        for (ChainVfxEffect effect: effects) {
            game.getVfxManager().addEffect(effect);
        }
        super.draw();
        game.getVfxManager().endInputCapture();
        game.getVfxManager().applyEffects();
        game.getVfxManager().renderToScreen();
        for (ChainVfxEffect effect: effects) {
            game.getVfxManager().removeEffect(effect);
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
