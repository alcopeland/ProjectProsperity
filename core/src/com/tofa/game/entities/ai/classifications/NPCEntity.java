package com.tofa.game.entities.ai.classifications;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.tofa.game.entities.StaticEntity;

public abstract class NPCEntity extends StaticEntity implements Interactable
{
    public NPCEntity(Sprite sprite, TiledMapTileLayer backgroundLayer,
                     int xSpawnTile, int ySpawnTile,
                     float health) {
        super(sprite, backgroundLayer,
                xSpawnTile, ySpawnTile,
                health);
    }
}
