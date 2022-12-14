package com.game.main;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public abstract class Ship extends GameObject{
    private  Handler handler;
    private int hull;
    private int shield;
    private int armor;
    protected boolean tookDamage;
    protected float timer;
    private final Color color;

    protected Ship(float x, float y, int w, int h,ID id, Handler hL,int l, int a, int s, Color c) {
        super(x, y, w, h, id, hL);
        this.handler = hL;
        this.hull = l;
        this.armor = a;
        this.shield = s;
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
            if(timer > 30){
                tookDamage = false;
            }
        }
        if(this.hull == 0) {
            if(this.getId() == ID.Player){
                handler.setScore(handler.getScore() + this.getId().scoreWorth);
                handler.setGameOver(true);
            }
            handler.removeObject(this);
        }
    }

    protected void collision(){
        for(int i = 0; i < handler.objectLL.size(); i++){
            GameObject obj = handler.objectLL.get(i);
            if(obj.getId() != this.id){
                if(getBounds().intersects(obj.getBounds())){
                    if (obj.getId() != ID.Projectile){
                        if(!tookDamage){
                            //System.out.println("Collision with a type Ship");
                            setVelX(getVelX() * -1);
                            setVelY(getVelY() * -1);
                            takeDamage(DamageTypes.NotSpecial);
                        }
                    }
                    else{
                        if(obj.getOrigin() != this){
                            takeDamage(obj.getDamageType());
                            if((obj.getOrigin().getId() == ID.Player && this.hull == 0)){
                                handler.setScore(handler.getScore()+ this.getId().scoreWorth);
                            }
                            //System.out.println("Collision with a type Projectile");
                            handler.removeObject(obj);
                        }

                    }
                }
            }
        }
    }

    protected void takeDamage(DamageTypes d){
        switch (d){
            case Shield:
                tookDamage = true;
                this.shield--;
                if(this.getId() == ID.Player){
                    handler.setScore(handler.getScore() - 10);
                }
                timer = 0;
                break;
            case Armor:
                tookDamage = true;
                this.armor--;
                if(this.getId() == ID.Player){
                    handler.setScore(handler.getScore() - 25);
                }
                timer = 0;
                break;
            case Hull:
                tookDamage = true;
                this.hull--;
                if(this.getId() == ID.Player){
                    handler.setScore(handler.getScore() - 50);
                }
                timer = 0;
                break;
            case ShieldHull:
                tookDamage = true;
                this.shield--;
                this.hull--;
                timer = 0;
                break;
            case ArmorHull:
                tookDamage = true;
                this.armor--;
                this.hull--;
                break;
            case ShieldAArmor:
                tookDamage = true;
                this.shield--;
                this.armor--;
                break;
            case All:
                tookDamage = true;
                this.hull--;
                this.shield--;
                this.armor--;
                break;
            case NotSpecial:
                if(this.shield > 0){
                    takeDamage(DamageTypes.Shield);
                }else{
                    if(this.armor > 0){
                        takeDamage(DamageTypes.Armor);
                    }else{
                        takeDamage(DamageTypes.Hull);
                    }
                }
                break;
            default:
                System.out.println("Not a Damage Type, Try: Shields, Hull, Armor, SH, HA, SA, All, or NotSpecial");
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
    @Override
    public int getHull() {
        return this.hull;
    }
    @Override
    public void setHull(int hull) {
        this.hull = hull;
    }

    @Override
    public int getArmor() {
        return armor;
    }

    @Override
    public void setArmor(int armor) {
        this.armor = armor;
    }
    @Override
    public int getShield() {
        return this.shield;
    }
    @Override
    public void setShield(int shield) {
        this.shield = shield;
    }
}
