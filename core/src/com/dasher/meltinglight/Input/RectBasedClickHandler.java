package com.dasher.meltinglight.Input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ObjectMap;
import com.badlogic.gdx.utils.StringBuilder;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.dasher.meltinglight.Interfaces.UpdateAble;

import org.jetbrains.annotations.NotNull;

import lombok.Setter;


public class RectBasedClickHandler implements UpdateAble {
    private final Viewport viewport;
    private @Setter ShapeRenderer debugShapeRender;
    private @Setter boolean debug;
    private final Vector2 currentInputVec = new Vector2();
    private final ObjectMap<Actor, RectClickableData> actorRectangleObjectMap = new ObjectMap<>();

    public RectBasedClickHandler(Viewport viewport) {
        this.viewport = viewport;
    }

    public void addActor(@NotNull Actor actor) {
        actor.setTouchable(Touchable.disabled);
        RectClickableData rectClickableData = new RectClickableData();
        Rectangle rectangle = new Rectangle();
        rectClickableData.setRectangle(rectangle);
        updateRectangle(actor, rectangle);
        actorRectangleObjectMap.put(actor, rectClickableData);
    }

    public void clearActors() {
        actorRectangleObjectMap.clear();
    }

    public RectClickableData getRectClickableDataFor(Actor actor) {
        return actorRectangleObjectMap.get(actor);
    }

    public void updateRectangle(Actor actor, Rectangle rectangle) {
        float x;
        float y;
        float w;
        float h;

        if (actor instanceof Label) {
            Label label = (Label) actor;
            StringBuilder textDefault = label.getText();
            label.getGlyphLayout().setText(label.getStyle().font, label.getText());
            w = label.getGlyphLayout().width * label.getFontScaleX();
            h = label.getGlyphLayout().height * label.getFontScaleY();
            x = label.getX() - w / 2f;
            y = label.getY() - h / 2f;
            label.getGlyphLayout().setText(label.getStyle().font, textDefault);
        } else {
            x = actor.getX();
            y = actor.getY();
            w = actor.getWidth();
            h = actor.getHeight();
        }

        rectangle.set(x, y, w, h);
    }

    @Override
    public void update(float delta) {
        currentInputVec.x = Gdx.input.getX();
        currentInputVec.y = Gdx.input.getY();
        currentInputVec.set(viewport.unproject(currentInputVec));
        for (ObjectMap.Entry<Actor, RectClickableData> entry: actorRectangleObjectMap) {
            Actor actor = entry.key;
            RectClickableData data = entry.value;
            Rectangle rectangle = data.getRectangle();
            updateRectangle(actor, rectangle);
            if (debug && debugShapeRender != null) {
                debugShapeRender.setColor(Color.GREEN);
                debugShapeRender.begin(ShapeRenderer.ShapeType.Line);
                debugShapeRender.rect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
                debugShapeRender.end();
            }
            for (EventListener eventListener: actor.getListeners()) {
                if (eventListener instanceof ClickListener) {
                    ClickListener clickListener = (ClickListener) eventListener;
                    if (rectangle.contains(currentInputVec.x, currentInputVec.y)) {
                        if (Gdx.input.isTouched()) {
                            clickListener.touchDown(null, currentInputVec.x, currentInputVec.y, 0, 0);
                        } else {
                            if (!data.isEntered()) {
                                data.setEntered(true);
                                clickListener.enter(null, currentInputVec.x, currentInputVec.y, 0, null);
                            }
                        }
                    } else {
                        if (data.isEntered()) {
                            data.setEntered(false);
                            clickListener.exit(null, currentInputVec.x, currentInputVec.y, 0, null);
                        }
                    }
                }
            }
        }
    }
}
