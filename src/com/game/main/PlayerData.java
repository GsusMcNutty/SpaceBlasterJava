package com.game.main;
import java.awt.*;

public class PlayerData {
    private int hull , armor, shield;
    private int maxHull, maxArmor, maxShield;
    private Color color;
    private HUD hud;

    public PlayerData(){
        maxHull = 3;
        maxArmor = 3;
        maxShield =3;
    }
    public void resetPlayerData(){
        setHull(getMaxHull());
        setArmor(getMaxArmor());
        setShield(getMaxShield());
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

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public HUD getHud() {
        return hud;
    }

    public void setHud(HUD hud) {
        this.hud = hud;
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
}
