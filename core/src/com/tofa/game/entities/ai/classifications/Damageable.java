package com.tofa.game.entities.ai.classifications;

public interface Damageable {

    void receiveDamage(float damage);
    boolean checkHealth();
    void updateHealthBar();
     void die();
}
