package com.ian.redsquare.Entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
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
import com.ian.redsquare.Screens.RedSquareScreen;

import java.sql.Time;

public class RedSquare implements Square {

    public Vector2 position;
    Viewport viewport;
    SpriteBatch batch;

    long startTime;
    Array<TextureRegion> redSquareTextureRegions;
    Animation redSquareAnimation;

    public RedSquare(Viewport viewport) {
        this.viewport = viewport;
        position = new Vector2(C.REDSQUARE_START.x, C.REDSQUARE_START.y);
        batch = new SpriteBatch();

        startTime = TimeUtils.nanoTime();
        redSquareTextureRegions = new Array<TextureRegion>(6);
        redSquareTextureRegions.add(new TextureRegion(new Texture("redSquareAnimations/Jewel4 Red_Animation 1_0.png")));
        redSquareTextureRegions.add(new TextureRegion(new Texture("redSquareAnimations/Jewel4 Red_Animation 1_1.png")));
        redSquareTextureRegions.add(new TextureRegion(new Texture("redSquareAnimations/Jewel4 Red_Animation 1_2.png")));
        redSquareTextureRegions.add(new TextureRegion(new Texture("redSquareAnimations/Jewel4 Red_Animation 1_3.png")));
        redSquareTextureRegions.add(new TextureRegion(new Texture("redSquareAnimations/Jewel4 Red_Animation 1_4.png")));
        redSquareTextureRegions.add(new TextureRegion(new Texture("redSquareAnimations/Jewel4 Red_Animation 1_5.png")));

        redSquareAnimation = new Animation(0.2f, redSquareTextureRegions, Animation.PlayMode.LOOP);

    }


    public void render() {

        float elapsedTime = MathUtils.nanoToSec * (TimeUtils.nanoTime() - startTime);
        TextureRegion redSquareAnimationTexture = redSquareAnimation.getKeyFrame(elapsedTime);

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
