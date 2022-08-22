package com.game.main;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public abstract class GameObject {

    protected float x, y;
    protected int width, height;
    protected ID id;
    protected float velX, velY;
    //GO constructor
    public GameObject(float x, float y, int w, int h, ID id){
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
        this.id = id;
    }

    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract Rectangle getBounds();

    protected void drawEllipse(Graphics g, double x, double y, double width, double height){
        Graphics2D g2d = (Graphics2D) g;
        Ellipse2D ellipse = new Ellipse2D.Double(x, y, width, height);
        g2d.draw(ellipse);
    }

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
}
