package com.awesometuts.mylibgdxtester;


// This is a package
// import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.graphics.GL20;
//import com.badlogic.gdx.graphics.Texture;
//import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import Scenes.MainMenu;
import helpers.GameInfo;

public class GameMain extends Game {
	/**
	 * Draw on the screen
	 */
	private SpriteBatch batch;

	/*Texture img;
	*//**
	 * Sprite permet de bouger le joueur
	 *//*
	Sprite player;*/

	/**
	 * Initialize Code
	 */
	@Override
	public void create () {
		batch = new SpriteBatch();
		setScreen(new MainMenu(this));
		/**
		 * Helpers Static variable and moving the player
		 */
/*		// System.out.println("CREATE WAS CALLED");
		batch = new SpriteBatch();
		img = new Texture("Game BG.png");
		player = new Sprite(new Texture("Player 1.png"));

		player.setPosition((GameInfo.WIDTH / 2) - player.getWidth() / 2, (GameInfo.HEIGHT / 2) - player.getHeight() / 2);
		// img2 = new Texture("badlogic.jpg");*/
	}

	@Override
	public void render () {
		// important pour voir le background
		super.render();


		/**
		 * Helpers Static variable and moving the player
		 */
		/*Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		// X moove the player to the right with -1 and Y to the hight
		player.setPosition(player.getX(), player.getY() + 1);

		batch.begin();
		batch.draw(img, 0, 0);
		batch.draw(player, player.getX(), player.getY());
		// batch.draw(img2, (GameInfo.WIDTH / 2) - img2.getWidth() /2, (GameInfo.HEIGHT / 2) - img2.getHeight() / 2);
		batch.end();*/
	}

	public SpriteBatch getBatch() {
		return this.batch;
	}
	
//	@Override
//	public void dispose () {
//		batch.dispose();
//		img.dispose();
//	}
}
