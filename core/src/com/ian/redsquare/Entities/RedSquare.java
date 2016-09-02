package com.ian.redsquare.Entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.ian.redsquare.C;

public class RedSquare {

    public Vector2 position;
    BlueSquare blueSquare;

    public RedSquare(BlueSquare blueSquare) {
        position = new Vector2(C.REDSQUARE_START.x, C.REDSQUARE_START.y);
        this.blueSquare = blueSquare;
    }

    public void update() {
        //movement(); //method for moving the redSquare
    }

    private void movement() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) {
            Gdx.app.log("right", "a");
            position.x += C.SQUARE_SIZE;
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) {
            position.x -= C.SQUARE_SIZE;
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
            position.y += C.SQUARE_SIZE;
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
            position.y -= C.SQUARE_SIZE;
        }
    }

    public void render(ShapeRenderer renderer) {
        renderer.setColor(C.REDSQUARE_COLOR);
        renderer.set(ShapeRenderer.ShapeType.Filled);
        renderer.rect(position.x, position.y, C.SQUARE_SIZE, C.SQUARE_SIZE);
    }

}
