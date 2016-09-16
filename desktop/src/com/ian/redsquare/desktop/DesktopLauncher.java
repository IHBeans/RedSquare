package com.ian.redsquare.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.ian.redsquare.RedSquareGame;

import jdk.nashorn.internal.runtime.regexp.joni.Config;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new RedSquareGame(), config);
	}
}
