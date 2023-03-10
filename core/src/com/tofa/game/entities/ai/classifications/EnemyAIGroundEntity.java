package com.tofa.game.entities.ai.classifications;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.tofa.game.entities.player.PlayerCharacterGroundEntity;

public abstract class EnemyAIGroundEntity extends AIGroundEntity implements Damageable
{
    protected final PlayerCharacterGroundEntity target;
    protected final float damage, range;

    public EnemyAIGroundEntity(Sprite sprite, TiledMapTileLayer collisionLayer,
                               int xSpawnTile, int ySpawnTile,
                               float speed, float health ,float vision,
                               PlayerCharacterGroundEntity target, float range, float damage) {
        super(sprite, collisionLayer,
                xSpawnTile, ySpawnTile,
                speed, health, vision);
        //System.out.println("Enemy AI Ground Entity");

        this.target = target;
        this.range = range;
        this.damage = damage;
    }

    @Override
    public void update(float delta) {
        movementVelocity.x=0;
        movementVelocity.y=0;
        if(checkHealth()) {
            die();
        } else {
            updateHealthBar();
        }
        if(checkForPlayerInVision()) {
            setVelocity();
            if(checkForPlayerInRange()) { attack(); }
            move(delta);
        }
    }
    public boolean checkForPlayerInVision() {
        float xDist = Math.abs((target.getX()-this.getX()));
        float yDist = Math.abs((target.getY()-this.getY()));
        float dist = (float) Math.sqrt(((Math.pow(xDist,2))+Math.pow(yDist,2)));
        return (dist <= vision);
    }
    public boolean checkForPlayerInRange() {
        float xDist = Math.abs((target.getX()-this.getX()));
        float yDist = Math.abs((target.getY()-this.getY()));
        float dist = (float) Math.sqrt(((Math.pow(xDist,2))+Math.pow(yDist,2)));
        return (dist <= range);
    }
    @Override
    public void move(float delta) {
        if(!this.xCollisionDetection()) {
            this.setX(this.getX() + movementVelocity.x * delta);
        }
        if(!this.yCollisionDetection()) {
            this.setY(this.getY() + movementVelocity.y * delta);
        }
    }
    abstract public void attack();
    @Override
    public void updateHealthBar() {
        if(currentHealth==maxHealth) {

        } else {
            float healthRatio = currentHealth/maxHealth;
        }
    }
    @Override
    public void receiveDamage(float damage) {
        currentHealth = currentHealth - damage;
    }
}
