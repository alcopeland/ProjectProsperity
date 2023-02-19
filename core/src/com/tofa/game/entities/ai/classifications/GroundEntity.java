package com.tofa.game.entities.ai.classifications;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.tofa.game.entities.Entity;

public abstract class GroundEntity extends Entity
{
    protected final TiledMapTileLayer collisionLayer;
    public GroundEntity(Sprite sprite, TiledMapTileLayer collisionLayer,
                        int xSpawnTile, int ySpawnTile,
                        float movementSpeed, float health) {
        super(sprite, collisionLayer,
                xSpawnTile, ySpawnTile,
                movementSpeed, health);
        //System.out.println("Ground Entity");

        this.collisionLayer=collisionLayer;
        System.out.println(collisionLayer);
    }

    public boolean xCollisionDetection() {
        boolean xCollide;
        float tileWidth = collisionLayer.getTileWidth(), tileHeight = collisionLayer.getTileHeight();
        int x = 0,y = 0;
        try {
            y = (int) ((getY() + (getHeight() / 2)) / tileHeight);
            if (movementVelocity.x < 0) {
                x = (int) (((getX() + (getWidth() / 2)) - getWidth()) / tileWidth);
                xCollide = collisionLayer.getCell(x, y).getTile().getProperties().containsKey("blocked");
            } else if (movementVelocity.x > 0) {
                x = (int) (((getX() + (getWidth() / 2)) + getWidth()) / tileWidth);
                xCollide = collisionLayer.getCell(x, y).getTile().getProperties().containsKey("blocked");
            } else {
                xCollide = false;
            }
            return xCollide;
        } catch(NullPointerException e) {
            return x < 0 || y < 0
                    || x >= collisionLayer.getWidth()
                    || y >= collisionLayer.getHeight();
        }
    }
    public boolean yCollisionDetection() {
        boolean yCollide;
        float tileWidth = collisionLayer.getTileWidth(), tileHeight = collisionLayer.getTileHeight();
        int x = 0,y = 0;
        try {
            x = (int) ((getX() + (getWidth() / 2)) / tileWidth);
            if (movementVelocity.y < 0) {
                y = (int) (((getY() + (getHeight()/2)) - getHeight()) / tileHeight);
                yCollide = collisionLayer.getCell(x,y).getTile().getProperties().containsKey("blocked");
            } else if (movementVelocity.y > 0) {
                y = (int) (((getY() + (getHeight()/2)) + getHeight()) / tileHeight);
                yCollide = collisionLayer.getCell(x, y).getTile().getProperties().containsKey("blocked");
            } else {
                yCollide = false;
            }
            return yCollide;
        } catch(NullPointerException e) {
            return x < 0 || y < 0
                    || x >= collisionLayer.getWidth()
                    || y >= collisionLayer.getHeight();
        }
    }
}
