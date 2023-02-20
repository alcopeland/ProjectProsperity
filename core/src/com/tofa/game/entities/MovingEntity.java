package com.tofa.game.entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

public abstract class MovingEntity extends Entity
{
    protected float movementSpeed;

    public MovingEntity(Sprite sprite, TiledMapTileLayer backgroundLayer,
                        int xSpawnTile, int ySpawnTile, float movementSpeed, float health) {
        super(sprite, backgroundLayer,
                xSpawnTile, ySpawnTile,
                health);

        this.movementSpeed=movementSpeed;
    }

    abstract public void setVelocity();
    abstract public void move(float delta);
}
