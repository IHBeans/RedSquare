package com.ian.redsquare.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.ian.redsquare.C;
import com.ian.redsquare.Entities.BlueSquare;
import com.ian.redsquare.Entities.FinishSquare;
import com.ian.redsquare.Entities.RedSquare;
import com.ian.redsquare.Entities.Square;
import com.ian.redsquare.RedSquareGame;


public class Level1 {

    RedSquareGame game;

    Viewport viewport;

    RedSquare redSquare;
    BlueSquare blueSquare;
    FinishSquare finishSquare;
    ShapeRenderer renderer;

    BlueConnectPosition blueConnectPosition;
    boolean isConnected = false;

    public Level1(RedSquareGame game, Viewport viewport, ShapeRenderer renderer){
        this.game = game;
        this.viewport = viewport;

        redSquare = new RedSquare();
        blueSquare = new BlueSquare();
        finishSquare = new FinishSquare(blueSquare);

        this.renderer = renderer;
    }


    public void update(){
        blockWithMovement(redSquare, blueSquare);
        connectBlueSquare();
        checkLevelEnd();
    }

    public void render(){
        renderer.setProjectionMatrix(viewport.getCamera().combined);
        renderer.begin();

        finishSquare.render(renderer);
        redSquare.render(renderer);
        blueSquare.render(renderer);

        renderer.end();

    }

    private void blockWithMovement(Square square1, Square square2) { //moves square1 if not blocked
        if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) {
            if (square1.getPosition().x == square2.getPosition().x - C.SQUARE_SIZE
                    && square1.getPosition().y == square2.getPosition().y
                    && !isConnected) {
            } else {
                square1.getPosition().x += C.SQUARE_SIZE;
            }
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) {
            if (square1.getPosition().x == square2.getPosition().x + C.SQUARE_SIZE
                    && square1.getPosition().y == square2.getPosition().y
                    && !isConnected) {

            } else {
                square1.getPosition().x -= C.SQUARE_SIZE;
            }
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
            if (square1.getPosition().x == square2.getPosition().x
                    && square1.getPosition().y == square2.getPosition().y - C.SQUARE_SIZE
                    && !isConnected) {

            } else {
                square1.getPosition().y += C.SQUARE_SIZE;
            }
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
            if (square1.getPosition().x == square2.getPosition().x
                    && square1.getPosition().y == square2.getPosition().y + C.SQUARE_SIZE
                    && !isConnected) {

            } else {
                square1.getPosition().y -= C.SQUARE_SIZE;
            }
        }

    }

    public void checkLevelEnd() {
        if (finishSquare.position.dst(blueSquare.position) == 0) {
            game.showLevelEndScreen();
        }
    }

    public void connectBlueSquare() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            if (isConnected) {
                isConnected = false;
            } else if (isConnectable()) {
                isConnected = true;
            }
        }

        if (isConnected) {
            switch (blueConnectPosition) {
                case RIGHT:
                    blueSquare.position.x = redSquare.position.x + C.SQUARE_SIZE;
                    blueSquare.position.y = redSquare.position.y;
                    break;
                case LEFT:
                    blueSquare.position.x = redSquare.position.x - C.SQUARE_SIZE;
                    blueSquare.position.y = redSquare.position.y;
                    break;
                case UP:
                    blueSquare.position.x = redSquare.position.x;
                    blueSquare.position.y = redSquare.position.y + C.SQUARE_SIZE;
                    break;
                case DOWN:
                    blueSquare.position.x = redSquare.position.x;
                    blueSquare.position.y = redSquare.position.y - C.SQUARE_SIZE;
                    break;
            }
        }
    }

    private boolean isConnectable() {
        if (blueSquare.position.x - redSquare.position.x == C.SQUARE_SIZE && blueSquare.position.y == redSquare.position.y) {
            blueConnectPosition = BlueConnectPosition.RIGHT;
            return true;
        }
        if (blueSquare.position.x - redSquare.position.x == -C.SQUARE_SIZE && blueSquare.position.y == redSquare.position.y) {
            blueConnectPosition = BlueConnectPosition.LEFT;
            return true;
        }
        if (blueSquare.position.x == redSquare.position.x && blueSquare.position.y - redSquare.position.y == C.SQUARE_SIZE) {
            blueConnectPosition = BlueConnectPosition.UP;
            return true;
        }
        if (blueSquare.position.x == redSquare.position.x && blueSquare.position.y - redSquare.position.y == -C.SQUARE_SIZE) {
            blueConnectPosition = BlueConnectPosition.DOWN;
            return true;
        }

        return false;
    }

    enum BlueConnectPosition {
        RIGHT,
        LEFT,
        UP,
        DOWN
    }
}
