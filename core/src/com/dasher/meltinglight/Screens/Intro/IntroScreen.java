package com.dasher.meltinglight.Screens.Intro;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.dasher.meltinglight.MeltingLight;
import com.dasher.meltinglight.Screens.GameScreen;

public class IntroScreen extends GameScreen {
    private Sprite sprite;

    public IntroScreen(MeltingLight game) {
        super(game);
    }

    @Override
    public void show() {
        sprite = new Sprite(game.assets.get(game.assets.textures.intro.sprite));
    }

    @Override
    public void render(float delta) {
        game.batch.begin();
        sprite.draw(game.batch);
        game.batch.end();
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

    }
}
