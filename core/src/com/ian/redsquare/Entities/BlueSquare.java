package com.ian.redsquare.Entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.ian.redsquare.C;

public class BlueSquare implements Square {

    public static final String TAG = BlueSquare.class.getName();

    Viewport viewport;
    public Vector2 position;

    SpriteBatch batch;

    long startTime;
    Array<TextureRegion> blueSquareTextureRegion;
    Animation blueSquareAnimation;

    public BlueSquare(Viewport viewport) {
        this.viewport = viewport;
        batch = new SpriteBatch();
        position = new Vector2(C.BLUESQUARE_START.x, C.BLUESQUARE_START.y);

        startTime = TimeUtils.nanoTime();
        blueSquareTextureRegion = new Array<TextureRegion>(6);
        blueSquareTextureRegion.add(new TextureRegion(new Texture("blueSquareAnimations/Jewel2 blue_Animation 1_0.png")));
        blueSquareTextureRegion.add(new TextureRegion(new Texture("blueSquareAnimations/Jewel2 blue_Animation 1_1.png")));
        blueSquareTextureRegion.add(new TextureRegion(new Texture("blueSquareAnimations/Jewel2 blue_Animation 1_2.png")));
        blueSquareTextureRegion.add(new TextureRegion(new Texture("blueSquareAnimations/Jewel2 blue_Animation 1_3.png")));
        blueSquareTextureRegion.add(new TextureRegion(new Texture("blueSquareAnimations/Jewel2 blue_Animation 1_4.png")));
        blueSquareTextureRegion.add(new TextureRegion(new Texture("blueSquareAnimations/Jewel2 blue_Animation 1_5.png")));

        blueSquareAnimation = new Animation(0.2f, blueSquareTextureRegion, Animation.PlayMode.LOOP);
    }


    public void render() {
        float elapsedTime = MathUtils.nanoToSec * (TimeUtils.nanoTime() - startTime);
        TextureRegion redSquareAnimationTexture = blueSquareAnimation.getKeyFrame(elapsedTime);

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



