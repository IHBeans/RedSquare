package com.ian.redsquare.Entities;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.ian.redsquare.C;

public class FinishSquare {

    BlueSquare blueSquare;
    public Vector2 position;


    public FinishSquare(BlueSquare blueSquare) {
        this.blueSquare = blueSquare;
        this.position = new Vector2(C.FINISHSQUARE_START.x, C.FINISHSQUARE_START.y);
    }

    public void update() {

    }

    public void render(ShapeRenderer renderer) {
        drawFinish(renderer);
    }

    private void drawFinish(ShapeRenderer renderer) {
        renderer.set(ShapeRenderer.ShapeType.Filled);
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                int x = C.FS_GAP * col;
                int y = C.FS_GAP * row;
                if (row % 2 == col % 2)
                    renderer.setColor(C.FINISHSQUARE_WHITE);
                else renderer.setColor(C.FINISHSQUARE_BLACK);

                renderer.rect(
                        C.FINISHSQUARE_START.x + x,
                        C.FINISHSQUARE_START.y + y,
                        C.FS_GAP,
                        C.FS_GAP
                );
            }
        }

    }
}
