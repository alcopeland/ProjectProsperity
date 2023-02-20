package com.tofa.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;

public abstract class Entity extends Sprite
{
    protected Vector2 movementVelocity = new Vector2(0,0);
    protected float currentHealth, maxHealth;
    private final TiledMapTileLayer backgroundLayer;

    public Entity(Sprite sprite, TiledMapTileLayer backgroundLayer,
                  int xSpawnTile, int ySpawnTile,
                  float health) {
        super(sprite);
        //System.out.println("Entity");

        this.backgroundLayer = backgroundLayer;
        this.currentHealth=health;
        this.maxHealth=health;

        setSpawnPoint(xSpawnTile,ySpawnTile);
    }

    public void draw(Batch batch) {
        update(Gdx.graphics.getDeltaTime());
        super.draw(batch);
    }
    abstract public void update(float delta);
    public void setSpawnPoint(int xTileNo, int yTileNo){
        this.setX(xTileNo*backgroundLayer.getTileWidth());
        this.setY(yTileNo*backgroundLayer.getTileHeight());
    }
}
