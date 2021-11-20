package com.dasher.meltinglight.Screens.Menu;

import com.dasher.meltinglight.Audio.GameMusic;
import com.dasher.meltinglight.MeltingLight;
import com.dasher.meltinglight.Screens.GameScreen;

public class MainMenu extends GameScreen {
    private MainMenuBackgroundStage mainMenuBackgroundStage;
    private MainMenuFrontStage mainMenuFrontStage;

    public MainMenu(MeltingLight game) {
        super(game);
    }

    @Override
    public void show() {
        GameMusic ambient = game.getAudioCreator().newMusic(game.getAssets().getMusics().getMenu().menuAmbient.get());
        ambient.setLooping(true);
        ambient.play();
        mainMenuBackgroundStage = new MainMenuBackgroundStage(game);
        mainMenuFrontStage = new MainMenuFrontStage(game);
        game.getInputMultiplexer().addProcessor(mainMenuFrontStage);
    }

    @Override
    public void render(float delta) {
        game.getViewport().apply(true);
        mainMenuBackgroundStage.act(delta);
        mainMenuBackgroundStage.draw();
        mainMenuFrontStage.act(delta);
        mainMenuFrontStage.draw();
        game.getViewport().apply(false);
    }

    @Override
    public void resize(int width, int height) {
        mainMenuBackgroundStage.resize(game.getViewport());
        show();
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
}
