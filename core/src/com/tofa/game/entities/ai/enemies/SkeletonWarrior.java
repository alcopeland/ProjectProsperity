package com.tofa.game.entities.ai.enemies;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.utils.TimeUtils;
import com.tofa.game.entities.player.PlayerCharacterGroundEntity;
import com.tofa.game.entities.ai.classifications.EnemyAIGroundEntity;

public class SkeletonWarrior extends EnemyAIGroundEntity
{
    private static final float DAMAGE = 10;
    private static final float HEALTH = 100;
    private static final float SPEED = 34*2f;
    private static final float VISION = 300;
    private static final float RANGE = 50;
    private float lastAttackTime = TimeUtils.nanoTime();

    public SkeletonWarrior(Sprite sprite, TiledMapTileLayer collisionLayer,
                           int xSpawnTile, int ySpawnTile,
                            /* speed, health, vision */
                           PlayerCharacterGroundEntity target /*, range, damage */) {
        super(sprite, collisionLayer,
                xSpawnTile, ySpawnTile,
                SPEED, HEALTH, VISION,
                target, RANGE, DAMAGE);
        //System.out.println("Skeleton Warrior");
    }

    @Override
    public void setVelocity() {
        float xDist = Math.abs((target.getX()-this.getX()));
        float yDist = Math.abs((target.getY()-this.getY()));
        float xSpeed = movementSpeed * ((xDist)/(xDist+yDist));
        float ySpeed = movementSpeed * ((yDist)/(xDist+yDist));

        if(target.getX()<this.getX()) {
            movementVelocity.x = -xSpeed;
        } else if(target.getX()>this.getX()) {
            movementVelocity.x = xSpeed;
        }
        if(target.getY()<this.getY()) {
            movementVelocity.y = -ySpeed;
        } else if(target.getY()>this.getY()) {
            movementVelocity.y = ySpeed;
        }
    }
    @Override
    public void attack() {
        if(TimeUtils.nanoTime() - lastAttackTime > 1000000000) {
            System.out.println("attack");
            lastAttackTime = TimeUtils.nanoTime();
        }
    }
    @Override
    public boolean checkHealth() {
        return currentHealth <= 0;
    }
    @Override
    public void die() {

    }
}
