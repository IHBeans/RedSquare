package com.ian.redsquare.Entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.ian.redsquare.C;

public class BlueSquare {

    public static final String TAG = BlueSquare.class.getName();

    public Vector2 position;
    RedSquare redSquare;
    public Boolean isConnected = false;
    BlueConnectPosition blueConnectPosition;

    public BlueSquare(RedSquare redSquare) {
        this.redSquare = redSquare;
        position = new Vector2(C.BLUESQUARE_START.x, C.BLUESQUARE_START.y);
    }

    public void update() {
        connect(); //method for connecting red and blue

    }

    private void connect(){
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            if (isConnected) {
                isConnected = false;
            } else if (isConnectable(redSquare.position)) {
                isConnected = true;
            }

        }

        if (isConnected) {
            switch (blueConnectPosition) {
                case RIGHT:
                    position.x = redSquare.position.x + C.SQUARE_SIZE;
                    position.y = redSquare.position.y;
                    break;
                case LEFT:
                    position.x = redSquare.position.x - C.SQUARE_SIZE;
                    position.y = redSquare.position.y;
                    break;
                case UP:
                    position.x = redSquare.position.x;
                    position.y = redSquare.position.y + C.SQUARE_SIZE;
                    break;
                case DOWN:
                    position.x = redSquare.position.x;
                    position.y = redSquare.position.y - C.SQUARE_SIZE;
                    break;
            }
        }
    }
    private boolean isConnectable(Vector2 redSquarePos) {
        if (position.x - redSquarePos.x == C.SQUARE_SIZE && position.y == redSquarePos.y) {
            blueConnectPosition = BlueConnectPosition.RIGHT;
            return true;
        }
        if (position.x - redSquarePos.x == -C.SQUARE_SIZE && position.y == redSquarePos.y) {
            blueConnectPosition = BlueConnectPosition.LEFT;
            return true;
        }
        if (position.x == redSquarePos.x && position.y - redSquarePos.y == C.SQUARE_SIZE) {
            blueConnectPosition = BlueConnectPosition.UP;
            return true;
        }
        if (position.x == redSquarePos.x && position.y - redSquarePos.y == -C.SQUARE_SIZE) {
            blueConnectPosition = BlueConnectPosition.DOWN;
            return true;
        }

        return false;
    }

    public void render(ShapeRenderer renderer) {
        renderer.setColor(C.BLUESQUARE_COLOR);
        renderer.set(ShapeRenderer.ShapeType.Filled);
        renderer.rect(position.x, position.y, C.SQUARE_SIZE, C.SQUARE_SIZE);
    }

    enum BlueConnectPosition {
        RIGHT,
        LEFT,
        UP,
        DOWN;
    }


}



