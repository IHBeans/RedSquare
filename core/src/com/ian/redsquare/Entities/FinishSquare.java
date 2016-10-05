package com.ian.redsquare.Entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.ian.redsquare.C;

public class FinishSquare implements Square {

    Viewport viewport;

    public Vector2 position;

    long startTime;
    SpriteBatch batch;
    Array<TextureRegion> finishSquareTextures;
    Animation finishSquareAnimation;

    public FinishSquare(Viewport viewport) {
        this.viewport = viewport;
        batch = new SpriteBatch();
        this.position = new Vector2(C.FINISHSQUARE_START.x, C.FINISHSQUARE_START.y);

        startTime = TimeUtils.nanoTime();
        finishSquareTextures = new Array<TextureRegion>(2);
        finishSquareTextures.add(new TextureRegion(new Texture("finishSquareAnimations/finishSquare1.png")));
        finishSquareTextures.add(new TextureRegion(new Texture("finishSquareAnimations/finishSquare2.png")));

        finishSquareAnimation = new Animation(0.2f, finishSquareTextures, Animation.PlayMode.LOOP);
    }

    public void render() {
        float elapsedTime = MathUtils.nanoToSec * (TimeUtils.nanoTime() - startTime);
        TextureRegion redSquareAnimationTexture = finishSquareAnimation.getKeyFrame(elapsedTime);

        batch.setProjectionMatrix(viewport.getCamera().combined);
        batch.begin();
        batch.draw(redSquareAnimationTexture, position.x, position.y, C.SQUARE_SIZE, C.SQUARE_SIZE);

        batch.end();
    }

    @Override
    public Vector2 getPosition() {
        return position;
    }

}
