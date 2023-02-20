package com.tofa.game.entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

public class StaticEntity extends Entity
{
    public StaticEntity(Sprite sprite, TiledMapTileLayer backgroundLayer,
                        int xSpawnTile, int ySpawnTile,
                        float health) {
        super(sprite, backgroundLayer,
                xSpawnTile, ySpawnTile,
                health);
    }

    @Override
    public void update(float delta) {

    }
}
