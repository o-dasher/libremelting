package com.dasher.meltinglight.Screens.Intro;


import com.dasher.meltinglight.MeltingLight;
import com.dasher.meltinglight.Screens.GameScreen;
import com.dasher.meltinglight.Screens.Menu.MainMenu;
import com.dasher.meltinglight.Tasks.ClockTask;

public class IntroScreen extends GameScreen {
    private ClockTask menuScreenTask;
    private IntroStage introStage;

    public IntroScreen(MeltingLight game) {
        super(game);
    }

    @Override
    public void show() {
        introStage = new IntroStage(game);
        getAudioCreator().newSound(getAssets().getSounds().getIntro().whoosh.get()).play();
        menuScreenTask = new ClockTask(2) {
            @Override
            public void run() {
                game.setScreen(new MainMenu(game), 1);
            }
        };
    }

    @Override
    public void render(float delta) {
        menuScreenTask.update(delta);
        introStage.act(delta);
        introStage.draw();
    }

    @Override
    public void resize(int width, int height) {

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
        introStage.dispose();
    }
}
