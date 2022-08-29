package com.game.main;
import java.awt.*;

public class ShipData {
    private ID id;
    private float startX, startY;
    private int width, height;
    private int hull, armor, shield;
    private int maxHull, maxArmor, maxShield;
    private Color color;
    private DamageTypes damageTypes;

    private final ShipType  sType;

    public ShipData(ShipType type){
        this.sType = type;
        this.setWidth(this.sType.width);
        this.setHeight(this.sType.height);
        this.setColor(this.sType.color);
        this.setMaxHull(this.sType.hull);
        this.setMaxArmor(this.sType.armor);
        this.setMaxShield(this.sType.shield);
        this.setHull(this.maxHull);
        this.setArmor(this.maxArmor);
        this.setShield(this.maxShield);
        this.setId(this.sType.id);


    }
    public void resetPlayerData(){
        setHull(sType.hull);
        setArmor(getMaxArmor());
        setShield(getMaxShield());
    }

    public ID getId() {
        return this.id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public float getStartX() {
        return this.startX;
    }

    public void setStartX(float startX) {
        this.startX = startX;
    }

    public float getStartY() {
        return this.startY;
    }

    public void setStartY(float startY) {
        this.startY = startY;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHull() {
        return this.hull;
    }

    public void setHull(int hull) {
        this.hull = hull;
    }

    public int getArmor() {
        return this.armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getShield() {
        return this.shield;
    }

    public void setShield(int shield) {
        this.shield = shield;
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getMaxHull() {
        return this.maxHull;
    }

    public void setMaxHull(int maxHull) {
        this.maxHull = maxHull;
    }

    public int getMaxArmor() {
        return this.maxArmor;
    }

    public void setMaxArmor(int maxArmor) {
        this.maxArmor = maxArmor;
    }

    public int getMaxShield() {
        return this.maxShield;
    }

    public void setMaxShield(int maxShield) {
        this.maxShield = maxShield;
    }

    public DamageTypes getDamageTypes() {
        return this.damageTypes;
    }

    public void setDamageTypes(DamageTypes damageTypes) {
        this.damageTypes = damageTypes;
    }
}
