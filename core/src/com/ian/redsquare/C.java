package com.ian.redsquare;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

public class C {

    //RedSquareScreen properties
    public static final Color BACKGROUND_COLOR = Color.LIGHT_GRAY;
    public static final Color WALL_COLOR = Color.GRAY;
    public static final float WORLD_SIZE = 720;

    public static final float LEVEL_HEIGHT = 1080;
    public static final float LEVEL_AR = 16/9f;

    //LevelEndScreen properties
    public static final Color LE_BACKGROUND_COLOR = Color.FOREST;
    public static final float LE_WORLD_SIZE = 480;
    public static final String RESTART = "Restart";
    public static final String NEXT_LEVEL = "Next Level";
    public static final float LE_FONT_SIZE = 10;
    public static final float BUTTON_SIZE = 100;

    public static final float LE_HEIGHT = 1080;
    public static final float LE_AR = 16/9f;

    public static final Color RESTART_COLOR = Color.RED;
    public static final Vector2 RESTART_BUTTON_POS = new Vector2(LE_WORLD_SIZE / 4, LE_WORLD_SIZE / 2);
    public static final Color NEXT_LEVEL_COLOR = Color.PINK;

    //Square
    public static final int SQUARE_SIZE = 120;

    //RedSquare
    public static final Color REDSQUARE_COLOR = Color.RED;
    public static final Vector2 REDSQUARE_START = new Vector2(120,120);

    //BlueSquare
    public static final Color BLUESQUARE_COLOR = Color.BLUE;
    public static final Vector2 BLUESQUARE_START = new Vector2(240, 360);

    //FinishSquare
    public static final Color FINISHSQUARE_WHITE = Color.WHITE;
    public static final Color FINISHSQUARE_BLACK = Color.BLACK;
    public static final Vector2 FINISHSQUARE_START = new Vector2(600, 600);
    public static final int FS_GAP = 30;
}
