package com.dasher.meltinglight.Screens.Menu;

import com.badlogic.gdx.graphics.Color;
import com.dasher.meltinglight.Audio.GameMusic;
import com.dasher.meltinglight.MeltingLight;
import com.dasher.meltinglight.Screens.GameScreen;

public class MainMenu extends GameScreen {
    private MainMenuBackgroundStage mainMenuBackgroundStage;
    private MainMenuFrontStage mainMenuFrontStage;
    private GameMusic ambient;
    private Color ambientColor;

    public MainMenu(MeltingLight game) {
        super(game);
    }

    @Override
    protected void create() {
        mainMenuBackgroundStage = new MainMenuBackgroundStage(game);
        mainMenuFrontStage = new MainMenuFrontStage(game);
        ambient = getAudioCreator().newMusic(getAssets().getMusics().getMenu().menuAmbient.get());
        ambient.setLooping(true);
        ambientColor = new Color(0.15f,0.1f,0.1f, 1);
    }

    @Override
    public void show() {
        super.show();
        ambient.play();
        getInputMultiplexer().addProcessor(mainMenuFrontStage);
        getRayHandler().setAmbientLight(ambientColor);
    }

    @Override
    public void render(float delta) {
        getViewport().apply(true);
        mainMenuBackgroundStage.act(delta);
        mainMenuBackgroundStage.draw();
        getViewport().apply(false);
        mainMenuFrontStage.act(delta);
        mainMenuFrontStage.draw();
    }

    @Override
    public void resize(int width, int height) { ;
        mainMenuFrontStage.resize(game.getViewport());
        mainMenuBackgroundStage.resize(game.getViewport());
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

    @Override
    public String getName() {
        return getScreenNames().menu;
    }
}
