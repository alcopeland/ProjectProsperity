package com.tofa.game.entities.ai.classifications;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.tofa.game.entities.Entity;

public abstract class FlyingEntity extends Entity
{
    public FlyingEntity(Sprite sprite, TiledMapTileLayer backgroundLayer,
                        int xSpawnTile, int ySpawnTile,
                        float movementSpeed, float health) {
        super(sprite, backgroundLayer,
                xSpawnTile, ySpawnTile,
                movementSpeed, health);
        //System.out.println("Flying Entity");
    }
}
