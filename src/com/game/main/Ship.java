package com.game.main;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public abstract class Ship extends GameObject {
    private Handler handler;
    private int life;
    private int shields;
    protected boolean tookDamage;
    protected float timer;
    private Color color;

    protected Ship(float x, float y, int w, int h,ID id, Handler hL,int l, int s, Color c) {
        super(x, y, w, h, id);
        this.handler = hL;
        this.life = l;
        this.shields = s;
        this.color = c;
    }
    public Rectangle getBounds(){
        return new Rectangle((int) getX(), (int) getY(), getWidth(), getHeight());
    }

    public void tick() {
        x += getVelX();
        y += getVelY();
        if(tookDamage){
            timer++;
            if(timer > 60){
                tookDamage = false;
            }
        }
    }
    protected void collision(ID id){
        for(int i = 0; i < handler.objectLL.size(); i++){
            GameObject obj = handler.objectLL.get(i);
            if(obj.getId() != id){
                if(getBounds().intersects(obj.getBounds())){
                    setVelX(getVelX() * -1);
                    setVelY(getVelY() * -1);
                    if(this.shields > 0){
                        takeDamage("Shield");
                    }
                    else{
                        if(this.life > 0){
                            takeDamage("Hull");
                        }
                        if(this.life == 0) {
                            System.out.println(this.life);
                            handler.removeObject(this);

                        }
                    }
                }
            }
        }
    }
    protected void takeDamage(String s){
        switch (s){
            case "Shield":
                tookDamage = true;
                this.shields --;
                timer = 0;
                System.out.println(this.shields + s + id);
                break;
            case "Hull":
                tookDamage = true;
                this.life--;
                timer = 0;
                System.out.println(this.life + s + id);
                break;
            case "Armor":
                System.out.println("Damage type not implemented");
                break;
            case "SH":
                tookDamage = true;
                this.shields--;
                this.life--;
                timer = 0;
                System.out.println(this.shields + s + id);
                System.out.println(this.life + s + id);
                break;
            case "HA":
                System.out.println("Damage type not implemented");
                break;
            case "SA":
                System.out.println("Damage type not implemented");
                break;
            case "CoolDown":

                break;
            default:
                System.out.println("Not a Damage Type, Try: Shields, Hull, Armor, SH, HA, SA");
        }

    }
    protected void drawEllipse(Graphics g, double x, double y, double width, double height){
        Graphics2D g2d = (Graphics2D) g;
        Ellipse2D ellipse = new Ellipse2D.Double(x, y, width, height);
        g2d.setColor(color);
        g2d.draw(ellipse);
    }
    protected void drawRectangle(Graphics g, double x, double y, double width, double height){
        Graphics2D g2d = (Graphics2D) g;
        Rectangle2D rectangle = new Rectangle2D.Double(x, y, width, height);
        g2d.setColor(color);
        g2d.draw(rectangle);
    }

    public int getLife() {
        return this.life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getShields() {
        return this.shields;
    }

    public void setShields(int shields) {
        this.shields = shields;
    }
}
