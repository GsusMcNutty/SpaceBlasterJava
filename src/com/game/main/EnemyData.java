package com.game.main;

import java.awt.*;

public class EnemyData {
    // TODO: 8/27/2022 pull from EnemyType enum to instantiate enemy data as the player does at initialization
    // TODO: 8/27/2022 this now feels redundant/obsolete as ship handles the data per object
    private ID id;
    private float startX, startY;
    private int width, height;
    private int hull, armor, shield;
    private int maxHull, maxArmor, maxShield;
    private Color color = Color.blue;
    private EnemyType type;
    private DamageTypes damageTypes;

    public EnemyData(EnemyType eT) {
        this.type = eT;
        this.hull = type.hull;
        this.armor = type.armor;
        this.shield = type.shield;
    }

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public float getStartX() {
        return startX;
    }

    public void setStartX(float startX) {
        this.startX = startX;
    }

    public float getStartY() {
        return startY;
    }

    public void setStartY(float startY) {
        this.startY = startY;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHull() {
        return hull;
    }

    public void setHull(int hull) {
        this.hull = hull;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getShield() {
        return shield;
    }

    public void setShield(int shield) {
        this.shield = shield;
    }

    public int getMaxHull() {
        return maxHull;
    }

    public void setMaxHull(int maxHull) {
        this.maxHull = maxHull;
    }

    public int getMaxArmor() {
        return maxArmor;
    }

    public void setMaxArmor(int maxArmor) {
        this.maxArmor = maxArmor;
    }

    public int getMaxShield() {
        return maxShield;
    }

    public void setMaxShield(int maxShield) {
        this.maxShield = maxShield;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public DamageTypes getDamageTypes() {
        return damageTypes;
    }

    public void setDamageTypes(DamageTypes damageTypes) {
        this.damageTypes = damageTypes;
    }
}
