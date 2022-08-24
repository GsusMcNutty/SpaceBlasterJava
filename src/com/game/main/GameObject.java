package com.game.main;

import java.awt.*;

public abstract class GameObject{
    protected float x, y;
    protected int width, height;
    protected ID id;
    protected Handler handler;
    protected float velX, velY;
    protected float lastVelX, lastVelY;
    //origin for if it is "spawned from another obj"
    protected GameObject origin;
    protected boolean hasCollision;
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
    public abstract void collisionResult();
    
    public ID collision(){
        ID collide = this.getId();
        for(int i = 0; i < handler.objectLL.size(); i++){
             GameObject obj = handler.objectLL.get(i);
                if(getBounds().intersects(obj.getBounds())) {
                    collide = obj.getId();
                    //System.out.println(collide);
            }
        }
        return collide;
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

    public float getLastVelX() {
        return lastVelX;
    }

    public void setLastVelX(float lastVelX) {
        this.lastVelX = lastVelX;
    }

    public float getLastVelY() {
        return lastVelY;
    }

    public void setLastVelY(float lastVelY) {
        this.lastVelY = lastVelY;
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
}
