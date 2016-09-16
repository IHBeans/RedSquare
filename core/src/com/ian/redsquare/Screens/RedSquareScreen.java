package com.ian.redsquare.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.ian.redsquare.C;
import com.ian.redsquare.Entities.BlueSquare;
import com.ian.redsquare.Entities.FinishSquare;
import com.ian.redsquare.Entities.RedSquare;
import com.ian.redsquare.Entities.Square;
import com.ian.redsquare.RedSquareGame;

public class RedSquareScreen extends InputAdapter implements Screen {

    RedSquareGame game;
    Level1 level1;

    Viewport gameViewport;
    ShapeRenderer renderer;

//    RedSquare redSquare;
//    BlueSquare blueSquare;
//    FinishSquare finishSquare;

//    BlueConnectPosition blueConnectPosition;
//    boolean isConnected = false;

    public RedSquareScreen(RedSquareGame game) {
        this.game = game;
    }

    @Override
    public void show() {
        float aspectRatio = Gdx.graphics.getWidth() / Gdx.graphics.getHeight();
        gameViewport = new ExtendViewport(C.LEVEL_HEIGHT * aspectRatio, C.LEVEL_HEIGHT);
        renderer = new ShapeRenderer();
        renderer.setAutoShapeType(true);

//        finishSquare = new FinishSquare(blueSquare);
//        redSquare = new RedSquare();
//        blueSquare = new BlueSquare();
        level1 = new Level1(game, gameViewport, renderer);

    }

    @Override
    public void render(float delta) {

        level1.update();

        gameViewport.apply(true);

        Gdx.gl.glClearColor(C.BACKGROUND_COLOR.r, C.BACKGROUND_COLOR.g, C.BACKGROUND_COLOR.b, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        level1.render();

//        renderer.setProjectionMatrix(gameViewport.getCamera().combined);
//        renderer.begin();
//
//        finishSquare.render(renderer);
//        redSquare.render(renderer);
//        blueSquare.render(renderer);

        //  renderer.end();

//        connectBlueSquare();
//        blockWithMovement(redSquare, blueSquare);
//        //   redSquareMovement(); //move redSqaure around, stops redSquare moving through blueSquare
//        checkLevelEnd();

    }

//    public void redSquareMovement() {
//        if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) {
//            Gdx.app.log("right", "a");
//            if (redSquare.position.x == blueSquare.position.x - C.SQUARE_SIZE
//                    && redSquare.position.y == blueSquare.position.y
//                    && !isConnected) {
//                Gdx.app.log("right", "b");
//            } else {
//                redSquare.position.x += C.SQUARE_SIZE;
//                Gdx.app.log("right", "c");
//            }
//        }
//        if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) {
//            Gdx.app.log("l", "a");
//            if (redSquare.position.x == blueSquare.position.x + C.SQUARE_SIZE
//                    && redSquare.position.y == blueSquare.position.y
//                    && !isConnected) {
//                Gdx.app.log("l", "b");
//            } else {
//                redSquare.position.x -= C.SQUARE_SIZE;
//                Gdx.app.log("l", "c");
//            }
//        }
//        if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
//            Gdx.app.log("u", "a");
//            if (redSquare.position.x == blueSquare.position.x
//                    && redSquare.position.y == blueSquare.position.y - C.SQUARE_SIZE
//                    && !isConnected) {
//                Gdx.app.log("u", "b");
//            } else {
//                redSquare.position.y += C.SQUARE_SIZE;
//                Gdx.app.log("u", "c");
//            }
//        }
//        if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
//            Gdx.app.log("d", "a");
//            if (redSquare.position.x == blueSquare.position.x
//                    && redSquare.position.y == blueSquare.position.y + C.SQUARE_SIZE
//                    && !isConnected) {
//                Gdx.app.log("d", "b");
//            } else {
//                redSquare.position.y -= C.SQUARE_SIZE;
//                Gdx.app.log("d", "c");
//            }
//        }
//    }

//    private void blockWithMovement(Square square1, Square square2) { //moves square1 if not blocked
//        if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) {
//            if (square1.getPosition().x == square2.getPosition().x - C.SQUARE_SIZE
//                    && square1.getPosition().y == square2.getPosition().y
//                    && !isConnected) {
//            } else {
//                square1.getPosition().x += C.SQUARE_SIZE;
//            }
//        }
//        if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) {
//            if (square1.getPosition().x == square2.getPosition().x + C.SQUARE_SIZE
//                    && square1.getPosition().y == square2.getPosition().y
//                    && !isConnected) {
//
//            } else {
//                square1.getPosition().x -= C.SQUARE_SIZE;
//            }
//        }
//        if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
//            if (square1.getPosition().x == square2.getPosition().x
//                    && square1.getPosition().y == square2.getPosition().y - C.SQUARE_SIZE
//                    && !isConnected) {
//
//            } else {
//                square1.getPosition().y += C.SQUARE_SIZE;
//            }
//        }
//        if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
//            if (square1.getPosition().x == square2.getPosition().x
//                    && square1.getPosition().y == square2.getPosition().y + C.SQUARE_SIZE
//                    && !isConnected) {
//
//            } else {
//                square1.getPosition().y -= C.SQUARE_SIZE;
//            }
//        }
//
//    }
//
//    public void checkLevelEnd() {
//        if (finishSquare.position.dst(blueSquare.position) == 0) {
//            game.showLevelEndScreen();
//        }
//    }
//
//    public void connectBlueSquare() {
//        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
//            if (isConnected) {
//                isConnected = false;
//            } else if (isConnectable()) {
//                isConnected = true;
//            }
//        }
//
//        if (isConnected) {
//            switch (blueConnectPosition) {
//                case RIGHT:
//                    blueSquare.position.x = redSquare.position.x + C.SQUARE_SIZE;
//                    blueSquare.position.y = redSquare.position.y;
//                    break;
//                case LEFT:
//                    blueSquare.position.x = redSquare.position.x - C.SQUARE_SIZE;
//                    blueSquare.position.y = redSquare.position.y;
//                    break;
//                case UP:
//                    blueSquare.position.x = redSquare.position.x;
//                    blueSquare.position.y = redSquare.position.y + C.SQUARE_SIZE;
//                    break;
//                case DOWN:
//                    blueSquare.position.x = redSquare.position.x;
//                    blueSquare.position.y = redSquare.position.y - C.SQUARE_SIZE;
//                    break;
//            }
//        }
//    }
//
//    private boolean isConnectable() {
//        if (blueSquare.position.x - redSquare.position.x == C.SQUARE_SIZE && blueSquare.position.y == redSquare.position.y) {
//            blueConnectPosition = BlueConnectPosition.RIGHT;
//            return true;
//        }
//        if (blueSquare.position.x - redSquare.position.x == -C.SQUARE_SIZE && blueSquare.position.y == redSquare.position.y) {
//            blueConnectPosition = BlueConnectPosition.LEFT;
//            return true;
//        }
//        if (blueSquare.position.x == redSquare.position.x && blueSquare.position.y - redSquare.position.y == C.SQUARE_SIZE) {
//            blueConnectPosition = BlueConnectPosition.UP;
//            return true;
//        }
//        if (blueSquare.position.x == redSquare.position.x && blueSquare.position.y - redSquare.position.y == -C.SQUARE_SIZE) {
//            blueConnectPosition = BlueConnectPosition.DOWN;
//            return true;
//        }
//
//        return false;
//    }

    @Override
    public void resize(int width, int height) {
        gameViewport.update(width, height, true);

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        renderer.dispose();

    }

    @Override
    public void dispose() {
    }

//    enum BlueConnectPosition {
//        RIGHT,
//        LEFT,
//        UP,
//        DOWN;
//    }


}
