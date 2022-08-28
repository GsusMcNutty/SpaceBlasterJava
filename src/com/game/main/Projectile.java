package com.game.main;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public abstract class Projectile extends GameObject{
    private final Color color;
    private DamageTypes damage;

    public Projectile(float x, float y, int w, int h, ID id, Handler hL, Color c) {
        super(x, y, w, h, id, hL);
        this.color = c;
        //setDamageType(d);
    }
    @Override
    public void tick() {
        x += velX;
        y += velY;
        //Remove if out of render
        if(y <= -height*2){
            handler.removeObject(this);
        }
        if(y >= Game.HEIGHT + height){
            handler.removeObject(this);
        }
        if(x <= -width){
            handler.removeObject(this);
        }
        if(x >= Game.WIDTH + width){
            handler.removeObject(this);
        }
    }

    public Rectangle getBounds(){
        return new Rectangle((int) getX(), (int) getY(), getWidth(), getHeight());
    }
    protected void drawEllipse(Graphics g, double x, double y, double width, double height){
        Graphics2D g2d = (Graphics2D) g;
        Ellipse2D ellipse = new Ellipse2D.Double(x, y, width, height);
        g2d.setColor(color);
        g2d.draw(ellipse);
    }

    // TODO: 8/27/2022 will be used later?
    public DamageTypes getDamage() {
        return damage;
    }

    public void setDamage(DamageTypes damage) {
        this.damage = damage;
    }
}
