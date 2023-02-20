package com.tofa.game.entities.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.tofa.game.entities.ai.classifications.Damageable;
import com.tofa.game.entities.ai.classifications.GroundEntity;

public class PlayerCharacterGroundEntity extends GroundEntity implements Damageable
{
    public PlayerCharacterGroundEntity(Sprite sprite, TiledMapTileLayer collisionLayer,
                                 int xSpawnTile, int ySpawnTile,
                                 float movementSpeed, float health) {
        super(sprite, collisionLayer,
                xSpawnTile, ySpawnTile,
                movementSpeed, health);
        //System.out.println("Player Character Entity");
    }

    @Override
    public void update(float delta) {
        movementVelocity.x = 0;
        movementVelocity.y = 0;
        setVelocity();
        move(delta);
    }
    @Override
    public void setVelocity() {
        if(Gdx.input.isKeyPressed(Input.Keys.D)) { movementVelocity.x = movementSpeed; }
        if(Gdx.input.isKeyPressed(Input.Keys.A)) { movementVelocity.x = -movementSpeed; }
        if(Gdx.input.isKeyPressed(Input.Keys.W)) { movementVelocity.y = movementSpeed; }
        if(Gdx.input.isKeyPressed(Input.Keys.S)) { movementVelocity.y = -movementSpeed; }
        if(xCollisionDetection()) { movementVelocity.x = 0; }
        if(yCollisionDetection()) { movementVelocity.y = 0; }
    }
    @Override
    public void move(float delta) {
        this.setX(getX() + movementVelocity.x * delta);
        this.setY(getY() + movementVelocity.y * delta);
    }

    @Override
    public void receiveDamage(float damage) {
        currentHealth = currentHealth - damage;
    }
    @Override
    public boolean checkHealth() {
        return false;
    }
    @Override
    public void die() {

    }
    @Override
    public void updateHealthBar() {
        if(currentHealth==maxHealth) {

        } else {
            float healthRatio = currentHealth/maxHealth;
        }
    }
}
