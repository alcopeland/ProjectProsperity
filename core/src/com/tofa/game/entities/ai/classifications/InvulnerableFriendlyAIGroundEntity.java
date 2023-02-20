package com.tofa.game.entities.ai.classifications;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

public abstract class InvulnerableFriendlyAIGroundEntity extends AIGroundEntity
{
    public InvulnerableFriendlyAIGroundEntity(Sprite sprite, TiledMapTileLayer collisionLayer,
                                              int xSpawnTile, int ySpawnTile,
                                              float movementSpeed, float health, float vision) {
        super(sprite, collisionLayer,
                xSpawnTile, ySpawnTile,
                movementSpeed, health, vision);
    }

    @Override
    public void update(float delta) {

    }
    @Override
    public void move(float delta) {

    }
}
