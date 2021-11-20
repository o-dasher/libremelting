package com.dasher.meltinglight.Interfaces;

import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.crashinvaders.vfx.VfxManager;
import com.dasher.meltinglight.Assets.GameAssetManager;
import com.dasher.meltinglight.Audio.AudioCreator;
import com.dasher.meltinglight.Graphics.Scene2d.ActorUtils;
import com.dasher.meltinglight.Graphics.ShapeRendering.FadeBlock;
import com.dasher.meltinglight.IO.FileExtensions;
import com.dasher.meltinglight.IO.SysPrinter;
import com.dasher.meltinglight.MeltingLight;
import com.dasher.meltinglight.Settings.GameSettings;

public interface GameWrapper {
    MeltingLight getGame();
    default SysPrinter getSysPrinter() {
        return getGame().getSysPrinter();
    }
    default FileExtensions getFileExtensions() {
        return getGame().getFileExtensions();
    }
    default GameAssetManager getAssets() {
        return getGame().getAssets();
    }
    default Viewport getViewport() {
        return getGame().getViewport();
    }
    default ActorUtils getActorUtils() {
        return getGame().getActorUtils();
    }
    default SpriteBatch getSpriteBatch() {
        return getGame().getSpriteBatch();
    }
    default FadeBlock getFadeBlock() {
        return getGame().getFadeBlock();
    }
    default ShapeRenderer getShapeRenderer() {
        return getGame().getShapeRenderer();
    }
    default GameSettings getGameSettings() {
        return getGame().getGameSettings();
    }
    default AudioCreator getAudioCreator() {
        return getGame().getAudioCreator();
    }
    default Preferences getPreferences() {
        return getGame().getPreferences();
    }
    default VfxManager getVfxManager() {
        return getGame().getVfxManager();
    }
    default InputMultiplexer getInputMultiplexer() {
        return getGame().getInputMultiplexer();
    }
}
