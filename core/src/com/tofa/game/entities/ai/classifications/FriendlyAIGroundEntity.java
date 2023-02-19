package com.tofa.game.entities.ai.classifications;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

public abstract class FriendlyAIGroundEntity extends AIGroundEntity
{
    public FriendlyAIGroundEntity(Sprite sprite, TiledMapTileLayer collisionLayer,
                                  int xSpawnTile, int ySpawnTile,
                                  float speed, float health, float vision) {
        super(sprite, collisionLayer,
                xSpawnTile, ySpawnTile,
                speed, health, vision);
    }
}
