package com.ian.redsquare.Entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.ian.redsquare.C;

public class RedSquare implements Square {

    public Vector2 position;

    public RedSquare() {
        position = new Vector2(C.REDSQUARE_START.x, C.REDSQUARE_START.y);
    }


    public void render(ShapeRenderer renderer) {
        renderer.setColor(C.REDSQUARE_COLOR);
        renderer.set(ShapeRenderer.ShapeType.Filled);
        renderer.rect(position.x, position.y, C.SQUARE_SIZE, C.SQUARE_SIZE);
    }

    @Override
    public Vector2 getPosition() {
        return position;
    }
}
