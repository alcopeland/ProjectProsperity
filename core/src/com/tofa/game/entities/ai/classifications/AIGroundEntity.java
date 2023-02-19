package com.tofa.game.entities.ai.classifications;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

public abstract class AIGroundEntity extends GroundEntity
{
    protected float vision;

    public AIGroundEntity(Sprite sprite, TiledMapTileLayer collisionLayer,
                          int xSpawnTile, int ySpawnTile,
                          float movementSpeed, float health, float vision) {
        super(sprite, collisionLayer,
                xSpawnTile, ySpawnTile,
                movementSpeed, health);
        //System.out.println("AI Ground Entity");

        this.vision = vision;
    }
}

