package com.tofa.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tofa.game.screens.MainMenuScreen;

public class PlayThreadsOfFate extends Game {
	public SpriteBatch batch;
	public BitmapFont font;
	public static final String TITLE = "Threads of Fate: Aethoria", VERSION = "v0.0.0.2";

	@Override
	public void create () {
		batch = new SpriteBatch();
		font = new BitmapFont();
		this.setScreen(new MainMenuScreen(this));
	}

	@Override
	public void render() {
		super.render();
	}

	@Override
	public void dispose() {
		font.dispose();
		batch.dispose();
	}

	@Override
	public void pause() { super.pause(); }

	@Override
	public void resume() { super.resume(); }

	@Override
	public void resize(int width, int height) { super.resize(width, height); }
}
