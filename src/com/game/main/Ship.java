package com.game.main;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public abstract class Ship extends GameObject {
    private final Handler handler;
    private final GameData gData;
    private final ShipData sData;
    protected boolean tookDamage;
    protected float timer;

    protected Ship(Handler handler, GameData gameData, ShipData shipData) {
        super(shipData.getStartX(), shipData.getStartY(), shipData.getWidth(), shipData.getHeight(), shipData.getId(), handler);
        this.handler = handler;
        this.gData = gameData;
        this.sData = shipData;
    }
    public void tick() {
        x += getVelX();
        y += getVelY();

        if(tookDamage){
            this.timer++;
            if(timer > 30){
                tookDamage = false;
            }
        }
        if(sData.getHull() <= 0) {
            if(getId() == ID.Player){
                //handler.setGameOver(true);
                handler.removeObject(this);
            }
            gData.setScore(gData.getScore() + this.getId().scoreWorth);
            handler.removeObject(this);
        }
    }

    protected void takeDamage(DamageTypes d){
        switch (d){
            case Shield:
                tookDamage = true;
                sData.setShield(this.sData.getShield() - 1);
                System.out.println(this.getId() + " Shield "+ sData.getShield());
                if(this.getId() == ID.Player){
                    gData.setScore(gData.getScore() - 30);
                }
                timer = 0;
                break;

            case Armor:
                tookDamage = true;
                sData.setArmor(sData.getArmor() - 1);
                if(this.getId() == ID.Player){
                    gData.setScore(gData.getScore() - 60);
                }
                timer = 0;
                break;

            case Hull:
                tookDamage = true;
                sData.setHull(sData.getHull()- 1);
                System.out.println(this.getId() +" Hull "+sData.getHull());
                if(this.getId() == ID.Player){
                    gData.setScore(gData.getScore() - 100);
                }
                timer = 0;
                break;

            case ShieldHull:
                tookDamage = true;
                sData.setShield(sData.getShield() - 1);
                sData.setHull(sData.getHull()- 1);
                timer = 0;
                break;

            case ArmorHull:
                tookDamage = true;
                sData.setArmor(sData.getArmor() - 1);
                sData.setHull(sData.getHull()- 1);
                break;

            case ShieldAArmor:
                tookDamage = true;
                sData.setShield(sData.getShield() - 1);
                sData.setArmor(sData.getArmor() - 1);
                break;

            case All:
                tookDamage = true;
                sData.setHull(sData.getHull()- 1);
                sData.setShield(sData.getShield() - 1);
                sData.setArmor(sData.getArmor() - 1);
                break;

            case NotSpecial:
                if(sData.getShield() > 0){
                    takeDamage(DamageTypes.Shield);
                }else{
                    if(sData.getArmor() > 0){
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
    //for asteroids and projectiles
    protected void drawEllipse(Graphics g, double x, double y, double width, double height){
        Graphics2D g2d = (Graphics2D) g;
        Ellipse2D ellipse = new Ellipse2D.Double(x, y, width, height);
        g2d.setColor(sData.getColor());
        g2d.draw(ellipse);
    }
    //for ships
    protected void drawRectangle(Graphics g, double x, double y, double width, double height){
        Graphics2D g2d = (Graphics2D) g;
        Rectangle2D rectangle = new Rectangle2D.Double(x, y, width, height);
        g2d.setColor(sData.getColor());
        g2d.draw(rectangle);
    }
}
