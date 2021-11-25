package com.dasher.meltinglight;

import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.crashinvaders.vfx.VfxManager;
import com.dasher.meltinglight.Assets.GameAssetManager;
import com.dasher.meltinglight.Audio.AudioCreator;
import com.dasher.meltinglight.Graphics.Scene2d.Actors.ActorUtils;
import com.dasher.meltinglight.Graphics.ShapeRendering.FadeBlock;
import com.dasher.meltinglight.IO.FileExtensions;
import com.dasher.meltinglight.IO.SysPrinter;
import com.dasher.meltinglight.Input.RectBasedClickHandler;
import com.dasher.meltinglight.MeltingLight;
import com.dasher.meltinglight.Screens.GameScreen;
import com.dasher.meltinglight.Screens.ScreenNames;
import com.dasher.meltinglight.Screens.TransitionNames;
import com.dasher.meltinglight.Settings.GameSettings;

import box2dLight.RayHandler;
import de.eskalon.commons.screen.ScreenManager;
import de.eskalon.commons.screen.transition.ScreenTransition;

public interface GameContainer {
    MeltingLight getGame();
    default World getWorld() {
        return getGame().getWorld();
    }
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
    default ScreenNames getScreenNames() {
        return getGame().getScreenNames();
    }
    default TransitionNames getTransitionNames() {
        return getGame().getTransitionNames();
    }
    default Box2DDebugRenderer getDebugRenderer() {
        return getGame().getDebugRenderer();
    }
    default ScreenManager<GameScreen, ScreenTransition> getScreenManager() {
        return getGame().getScreenManager();
    }
    default RectBasedClickHandler getRectBasedClickHandler() {
        return getGame().getRectBasedClickHandler();
    }
    default RayHandler getRayHandler() {
        return getGame().getRayHandler();
    }
    default void clearScreenSpecifics() {
        getGame().clearScreenSpecifics();
    }
}
