package com.ian.redsquare.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.ian.redsquare.C;
import com.ian.redsquare.RedSquareGame;

public class LevelEndScreen extends InputAdapter implements Screen {

    RedSquareGame game;
    Viewport viewport;
    ShapeRenderer renderer;

    public LevelEndScreen(RedSquareGame game) {
        this.game = game;
    }

    @Override
    public void show() {

        renderer = new ShapeRenderer();
        viewport = new FitViewport(C.LE_WORLD_SIZE, C.LE_WORLD_SIZE);
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void render(float delta) {
        viewport.apply();
        Gdx.gl.glClearColor(C.LE_BACKGROUND_COLOR.r, C.LE_BACKGROUND_COLOR.g, C.LE_BACKGROUND_COLOR.b, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderer.setProjectionMatrix(viewport.getCamera().combined);
        renderer.begin(ShapeRenderer.ShapeType.Filled);

        renderer.setColor(C.RESTART_COLOR);
        renderer.rect(C.RESTART_BUTTON_POS.x, C.RESTART_BUTTON_POS.y, C.BUTTON_SIZE, C.BUTTON_SIZE);

        renderer.setColor(C.NEXT_LEVEL_COLOR);
        renderer.rect((C.LE_WORLD_SIZE * (0.75f)) - C.BUTTON_SIZE, C.LE_WORLD_SIZE / 2, C.BUTTON_SIZE, C.BUTTON_SIZE);

        renderer.end();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);

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

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        Gdx.app.log("a", "a");
        Vector2 worldTouch = viewport.unproject(new Vector2(screenX, screenY));
        if ((worldTouch.x > C.RESTART_BUTTON_POS.x && worldTouch.x < C.RESTART_BUTTON_POS.x + C.BUTTON_SIZE) && (worldTouch.y > C.RESTART_BUTTON_POS.y && worldTouch.y < C.RESTART_BUTTON_POS.y + C.BUTTON_SIZE)) {
            game.showRedSquareScreen();
        }
        return true;
    }
}
