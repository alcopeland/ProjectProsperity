package com.tofa.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;

public class PlayerCharacter extends Sprite
{
    private Vector2 velocity = new Vector2(0,0); //the movement velocity
    private float speed = 60*2; //the movement speed

    private TiledMapTileLayer collisionLayer;

    public PlayerCharacter(Sprite sprite, TiledMapTileLayer collisionLayer) {
        super(sprite);
        this.collisionLayer=collisionLayer;
    }

    @Override
    public void draw(Batch batch) {
        update(Gdx.graphics.getDeltaTime());
        super.draw(batch);
    }

    public void update(float delta) {
        velocity.x = 0;
        velocity.y = 0;
        if(Gdx.input.isKeyPressed(Input.Keys.D)) { velocity.x = speed; }
        if(Gdx.input.isKeyPressed(Input.Keys.A)) { velocity.x = -speed; }
        if(Gdx.input.isKeyPressed(Input.Keys.W)) { velocity.y = speed; }
        if(Gdx.input.isKeyPressed(Input.Keys.S)) { velocity.y = -speed; }

        float tileWidth = collisionLayer.getTileWidth(), tileHeight = collisionLayer.getTileHeight();
        boolean xCollide = false, yCollide = false;

        try {
            if (velocity.x < 0) {
                xCollide = collisionLayer.getCell((int) ((getX() - getWidth()) / tileWidth), (int) ((getY() + (getHeight() / 2)) / tileHeight)).getTile().getProperties().containsKey("blocked");
            } else if (velocity.x > 0) {
                xCollide = collisionLayer.getCell((int) ((getX() + getWidth()) / tileWidth), (int) ((getY() + (getHeight() / 2)) / tileHeight)).getTile().getProperties().containsKey("blocked");
            }
            if (!xCollide) { this.setX(getX() + velocity.x * delta); }

            if (velocity.y < 0) {
                yCollide = collisionLayer.getCell((int) ((getX() + (getWidth() / 2)) / tileWidth), (int) ((getY() - getHeight()) / tileHeight)).getTile().getProperties().containsKey("blocked");
            } else if (velocity.y > 0) {
                yCollide = collisionLayer.getCell((int) ((getX() + (getWidth() / 2)) / tileWidth), (int) ((getY() + getHeight()) / tileHeight)).getTile().getProperties().containsKey("blocked");
            }
            if(!yCollide) { this.setY(getY() + velocity.y * delta); }

        } catch(NullPointerException e) {
            velocity.x = 0;
            velocity.y = 0;
        }

    }
}
