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
import com.tofa.game.entities.Entity;
import com.tofa.game.entities.player.PlayerCharacterGroundEntity;
import com.tofa.game.entities.ai.enemies.SkeletonWarrior;

import java.util.ArrayList;

public class GameScreen implements Screen
{
    final PlayThreadsOfFate game;
    private TiledMap tiledMap;
    private OrthogonalTiledMapRenderer renderer;
    private OrthographicCamera camera;
    private PlayerCharacterGroundEntity player;
    private final ArrayList<Entity> entityArrayList = new ArrayList<>();
    private boolean firstTime = true;

    public GameScreen (final PlayThreadsOfFate game) {
        this.game=game;
    }

    @Override
    public void show() {
        tiledMap = new TmxMapLoader().load("maps/aethoria/firstmap_aethoria.tmx");

        renderer = new OrthogonalTiledMapRenderer(tiledMap);
        camera = new OrthographicCamera();
        if(firstTime) {
            firstTime= false;
            runGame();
        }
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
        renderer.renderTileLayer((TiledMapTileLayer) tiledMap.getLayers().get("background"));
        renderer.renderTileLayer((TiledMapTileLayer) tiledMap.getLayers().get("middleground"));
        entityArrayList.forEach(entity -> entity.draw(renderer.getBatch()));
        renderer.renderTileLayer((TiledMapTileLayer) tiledMap.getLayers().get("foreground"));
        renderer.getBatch().end();
    }
    @Override
    public void resize(int width, int height) {
        camera.viewportWidth=width/1.4f;
        camera.viewportHeight=height/1.4f;
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
        entityArrayList.forEach(entity -> entity.getTexture().dispose());
    }
    //Start of game logic area?
    public void runGame() {
        player = new PlayerCharacterGroundEntity(
                new Sprite(new Texture("sprites/player/warrior.png")), (TiledMapTileLayer)(tiledMap.getLayers().get("foreground")),
                1,1,
                60*2f, 100);
        entityArrayList.add(player);
        /*
        Make a system such that it can
            be either random or fixed location
            and random or fixed enemy type (orcs or skeletons)
            and random or fixed enemy variant (warrior or mage etc.)
         */
        spawnSkeletonWarriorAt(5,5);
        spawnSkeletonWarriorAt(15,5);
    }
    public void spawnSkeletonWarriorAt(int xSpawnTile, int ySpawnTile) {
        if(xSpawnTile<tiledMap.getProperties().get("width", Integer.class)
                && ySpawnTile<tiledMap.getProperties().get("height", Integer.class)
                && xSpawnTile >= 0 && ySpawnTile >= 0) {
            SkeletonWarrior testEnemy = new SkeletonWarrior(
                    new Sprite(new Texture("sprites/enemies/skeletonWarrior.png")), (TiledMapTileLayer) (tiledMap.getLayers().get("foreground")),
                    xSpawnTile, ySpawnTile,
                    player);
            entityArrayList.add(testEnemy);
        }
    }
}
