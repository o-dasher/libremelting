package com.dasher.meltinglight.Graphics.ShapeRendering;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Null;
import com.badlogic.gdx.utils.viewport.Viewport;


public class FadeBlock {
    private final Color color;
    private boolean isFadingIn = false;
    private boolean isFadingOut = false;
    private float period = 1;
    private final ShapeRenderer shapeRenderer;
    private final Viewport viewport;
    private Runnable fadeInTask;
    private Runnable fadeOutTask;

    public FadeBlock(Color color, ShapeRenderer shapeRenderer) {
        this(color, shapeRenderer, null);
    }

    public FadeBlock(Color color, ShapeRenderer shapeRenderer, @Null Viewport viewport) {
        this.color = color.cpy();
        this.color.a = 0;
        this.shapeRenderer = shapeRenderer;
        this.viewport = viewport;
    }

    public void update(float delta) {
        float w;
        float h;
        if (viewport == null) {
            w = Gdx.graphics.getWidth();
            h = Gdx.graphics.getHeight();
        } else {
            w = viewport.getWorldWidth();
            h = viewport.getWorldHeight();
        }
        if (isFading()) {
            if (isFadingIn) {
                color.a = Math.min(1, color.a + delta / period);
                if (color.a >= 1) {
                    isFadingOut = true;
                    isFadingIn = false;
                    if (fadeInTask != null) {
                        fadeInTask.run();
                        fadeInTask = null;
                    }
                }
            } else {
                color.a = Math.max(0, color.a - delta / period);
                if (color.a <= 0) {
                    isFadingOut = false;
                    if (fadeOutTask != null) {
                        fadeOutTask.run();
                        fadeOutTask = null;
                    }
                }
            }
            Gdx.gl.glEnable(GL30.GL_BLEND);
            Gdx.gl.glBlendFunc(GL30.GL_SRC_ALPHA, GL30.GL_ONE_MINUS_SRC_ALPHA);
            shapeRenderer.setColor(color);
            shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
            shapeRenderer.rect(0, 0, w, h);
            shapeRenderer.end();
            Gdx.gl.glDisable(GL30.GL_BLEND);
        }
    }

    public boolean isFading() {
        return isFadingIn || isFadingOut;
    }

    public void setPeriod(float period) {
        this.period = period;
    }

    public void setFade(boolean isFadingIn) {
        this.isFadingIn = isFadingIn;
    }

    public void setFadeInTask(Runnable fadeInTask) {
        this.fadeInTask = fadeInTask;
    }

    public void setFadeOutTask(Runnable fadeOutTask) {
        this.fadeOutTask = fadeOutTask;
    }
}
