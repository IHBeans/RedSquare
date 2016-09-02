package com.ian.redsquare.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.ian.redsquare.C;
import com.ian.redsquare.Entities.BlueSquare;
import com.ian.redsquare.Entities.FinishSquare;
import com.ian.redsquare.Entities.RedSquare;
import com.ian.redsquare.RedSquareGame;

public class RedSquareScreen extends InputAdapter implements Screen {

    RedSquareGame game;

    Viewport gameViewport;
    ShapeRenderer renderer;

    RedSquare redSquare;
    BlueSquare blueSquare;
    FinishSquare finishSquare;

    boolean blocked = false;

    public RedSquareScreen(RedSquareGame game) {
        this.game = game;
    }

    @Override
    public void show() {
        gameViewport = new FitViewport(C.LEVEL_HEIGHT * C.LEVEL_AR, C.LEVEL_HEIGHT);
        renderer = new ShapeRenderer();
        renderer.setAutoShapeType(true);

        finishSquare = new FinishSquare(blueSquare);
        redSquare = new RedSquare(blueSquare);
        blueSquare = new BlueSquare(redSquare);
    }

    @Override
    public void render(float delta) {
        redSquare.update();
        blueSquare.update();


        gameViewport.apply(true);

        Gdx.gl.glClearColor(C.BACKGROUND_COLOR.r, C.BACKGROUND_COLOR.g, C.BACKGROUND_COLOR.b, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderer.setProjectionMatrix(gameViewport.getCamera().combined);
        renderer.begin();

        finishSquare.render(renderer);
        redSquare.render(renderer);
        blueSquare.render(renderer);

        renderer.end();

        redSquareMovement(); //move redSqaure around, stops redSquare moving through blueSquare

        if (finishSquare.position.dst(blueSquare.position) == 0) {
            game.showLevelEndScreen();
        }

    }
    public void redSquareMovement(){
        if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) {
            Gdx.app.log("right", "a");
            if (redSquare.position.x == blueSquare.position.x - C.SQUARE_SIZE
                    && redSquare.position.y == blueSquare.position.y
                    && !blueSquare.isConnected) {
                Gdx.app.log("right", "b");
                return;
            } else {
                redSquare.position.x += C.SQUARE_SIZE;
                Gdx.app.log("right", "c");
            }
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) {
            Gdx.app.log("l", "a");
            if (redSquare.position.x == blueSquare.position.x + C.SQUARE_SIZE
                    && redSquare.position.y == blueSquare.position.y
                    && !blueSquare.isConnected) {
                Gdx.app.log("l", "b");
                return;
            } else {
                redSquare.position.x -= C.SQUARE_SIZE;
                Gdx.app.log("l", "c");
            }
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
            Gdx.app.log("u", "a");
            if (redSquare.position.x == blueSquare.position.x
                    && redSquare.position.y == blueSquare.position.y - C.SQUARE_SIZE
                    && !blueSquare.isConnected) {
                Gdx.app.log("u", "b");
                return;
            } else {
                redSquare.position.y += C.SQUARE_SIZE;
                Gdx.app.log("u", "c");
            }
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
            Gdx.app.log("d", "a");
            if (redSquare.position.x == blueSquare.position.x
                    && redSquare.position.y == blueSquare.position.y + C.SQUARE_SIZE
                    && !blueSquare.isConnected) {
                Gdx.app.log("d", "b");
                return;
            } else {
                redSquare.position.y -= C.SQUARE_SIZE;
                Gdx.app.log("d", "c");
            }
        }
    }

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


}
