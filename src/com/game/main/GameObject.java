package com.game.main;

import java.awt.*;

public abstract class GameObject{
    protected float x, y;
    protected int width, height;
    protected ID id;
    protected Handler handler;
    protected float velX, velY;
    //origin for if it is "spawned from another obj"
    protected GameObject origin;

    // TODO: 8/23/2022 remove damagetype from GO
    protected DamageTypes damageType;

    // TODO: 8/23/2022 move hull armor shield to child class
    protected int hull, armor, shield;
    //GO constructor
    public GameObject(float x, float y, int w, int h, ID id, Handler hl){
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
        this.id = id;
        this.handler = hl;
    }
    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract Rectangle getBounds();

    public void setId(ID id) {
        this.id = id;
    }

    public ID getId() {
        return id;
    }

    public void setVelX(float velX) {
        this.velX = velX;
    }

    public float getVelX() {
        return velX;
    }

    public void setVelY(float velY) {
        this.velY = velY;
    }

    public float getVelY() {
        return velY;
    }

    public void setX(float x){
        this.x = x;
    }

    public float getX() {
        return x;
    }

    public void setY(float y){
        this.y =y;
    }

    public float getY() {
        return y;
    }
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    public GameObject getOrigin() {
        return origin;
    }

    public void setOrigin(GameObject origin) {
        this.origin = origin;
    }

    public DamageTypes getDamageType() {
        return damageType;
    }

    public void setDamageType(DamageTypes damageType) {
        this.damageType = damageType;
    }

    public int getShield() {
        return shield;
    }

    public void setShield(int shield) {
        this.shield = shield;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getHull() {
        return hull;
    }

    public void setHull(int hull) {
        this.hull = hull;
    }
}
