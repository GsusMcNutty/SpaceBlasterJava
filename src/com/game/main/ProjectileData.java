package com.game.main;

public class ProjectileData {

    private Handler handler;
    private DamageTypes damage;

    public ProjectileData (){

    }

    public DamageTypes getDamage() {
        return damage;
    }

    public void setDamage(DamageTypes damage) {
        this.damage = damage;
    }
}
