package com.ian.redsquare;

import com.badlogic.gdx.Game;
import com.ian.redsquare.Screens.RedSquareScreen;
import com.ian.redsquare.Screens.LevelEndScreen;

public class RedSquareGame extends Game {

    @Override
    public void create() {
        showRedSquareScreen();
    }

    public void showLevelEndScreen(){
        setScreen(new LevelEndScreen(this));
    }
    public void showRedSquareScreen(){
        setScreen(new RedSquareScreen(this));
    }
}
