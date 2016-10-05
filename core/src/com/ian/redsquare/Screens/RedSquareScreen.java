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

    public RedSquareScreen(RedSquareGame game) {
        this.game = game;
    }

    @Override
    public void show() {
        float aspectRatio = Gdx.graphics.getWidth() / Gdx.graphics.getHeight();
        gameViewport = new ExtendViewport(C.LEVEL_WIDTH, C.LEVEL_HEIGHT);

        renderer = new ShapeRenderer();
        renderer.setAutoShapeType(true);

        level1 = new Level1(game, gameViewport, renderer);

    }

    @Override
    public void render(float delta) {

        level1.update();

        gameViewport.apply(true);

        Gdx.gl.glClearColor(C.BACKGROUND_COLOR.r, C.BACKGROUND_COLOR.g, C.BACKGROUND_COLOR.b, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        level1.render();

        checkLevelEnd();
    }

    private void checkLevelEnd() {
        if (level1.finishSquare.position.dst(level1.blueSquare.position) == 0) {
            game.showLevelEndScreen();
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
