package com.dasher.meltinglight.Screens.Intro;


import com.dasher.meltinglight.Audio.GameSound;
import com.dasher.meltinglight.MeltingLight;
import com.dasher.meltinglight.Screens.GameScreen;
import com.dasher.meltinglight.Screens.Menu.MainMenu;
import com.dasher.meltinglight.Tasks.ClockTask;

import de.eskalon.commons.screen.transition.impl.BlendingTransition;
import de.eskalon.commons.screen.transition.impl.HorizontalSlicingTransition;
import de.eskalon.commons.screen.transition.impl.PushTransition;
import de.eskalon.commons.screen.transition.impl.SlidingDirection;
import de.eskalon.commons.screen.transition.impl.VerticalSlicingTransition;

public class IntroScreen extends GameScreen {
    private ClockTask menuScreenTask;
    private IntroStage introStage;
    private GameSound whooshSound;

    public IntroScreen(MeltingLight game) {
        super(game);
    }

    @Override
    protected void create() {
        introStage = new IntroStage(game);
        whooshSound = getAudioCreator().newSound(getAssets().getSounds().getIntro().whoosh.get());
        getScreenManager().addScreen(getScreenNames().menu, new MainMenu(game));
        menuScreenTask = new ClockTask(2) {
            @Override
            public void run() {
                getScreenManager().addScreenTransition(
                        getTransitionNames().blending,
                        new BlendingTransition(getSpriteBatch(), 1)
                );
                getScreenManager().pushScreen(getScreenNames().menu, getTransitionNames().blending);
            }
        };
    }

    @Override
    public void show() {
        super.show();
        whooshSound.play();
        menuScreenTask.reset();
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

    @Override
    public String getName() {
        return getScreenNames().intro;
    }
}
