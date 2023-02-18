package com.tofa.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.tofa.game.PlayThreadsOfFate;
import com.tofa.game.entities.PlayerCharacter;

public class GameScreen implements Screen
{
    final PlayThreadsOfFate game;
    private TiledMap tiledMap;
    private OrthogonalTiledMapRenderer renderer;
    private OrthographicCamera camera;
    private PlayerCharacter player;

    public GameScreen (final PlayThreadsOfFate game) {
        this.game=game;

    }

    @Override
    public void show() {
        tiledMap = new TmxMapLoader().load("maps/aethoria/firstmap_aethoria.tmx");

        renderer = new OrthogonalTiledMapRenderer(tiledMap);
        camera = new OrthographicCamera();

        player = new PlayerCharacter(new Sprite(new Texture("sprites/warrior.png")), (TiledMapTileLayer)(tiledMap.getLayers().get(0)));
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.position.set((player.getX()+(player.getWidth()/2)), (player.getY()+(player.getHeight()/2)),(0));
        camera.update();
        renderer.setView(camera);
        renderer.render();

        renderer.getBatch().begin();
        player.draw(renderer.getBatch());
        renderer.getBatch().end();
    }

    @Override
    public void resize(int width, int height) {
        camera.viewportWidth=width/2f;
        camera.viewportHeight=height/2f;
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void dispose() {
        tiledMap.dispose();
        renderer.dispose();
        player.getTexture().dispose();
    }
}
