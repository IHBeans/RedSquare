package com.ian.redsquare.Entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.ian.redsquare.C;

public class BlueSquare implements Square {

    public static final String TAG = BlueSquare.class.getName();

    public Vector2 position;

    public BlueSquare() {
        position = new Vector2(C.BLUESQUARE_START.x, C.BLUESQUARE_START.y);
    }


    public void render(ShapeRenderer renderer) {
        renderer.setColor(C.BLUESQUARE_COLOR);
        renderer.set(ShapeRenderer.ShapeType.Filled);
        renderer.rect(position.x, position.y, C.SQUARE_SIZE, C.SQUARE_SIZE);
    }

    @Override
    public Vector2 getPosition() {
        return position;
    }

}



