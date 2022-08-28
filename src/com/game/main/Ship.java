package com.game.main;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public abstract class Ship extends GameObject {
    private  Handler handler;
    private GameData gData;
    private PlayerData pData;
    private int hull;
    private int shield;
    private int armor;
    protected boolean tookDamage;
    protected float timer;
    private final Color color;

    // TODO: 8/27/2022 get working with EnemyType NOT EnemyData (obsolete?) 
    protected Ship(float x, float y, int w, int h,ID id, Handler hL, int hl, int a, int s, Color c, GameData gd) {
        super(x, y, w, h, id, hL);
        this.handler = hL;
        this.color = c;
        this.hull = hl;
        this.armor = a;
        this.shield = s;
        this.gData = gd;
        this.pData = hL.getpData();
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
                //handler.setGameOver(true);
            }
            gData.setScore(gData.getScore() + this.getId().scoreWorth);
            handler.removeObject(this);
        }
    }

    protected void takeDamage(DamageTypes d){
        switch (d){
            case Shield:
                tookDamage = true;
                this.shield--;
                System.out.println(this.getId() + " Shield "+ this.shield);
                if(this.getId() == ID.Player){
                    gData.setScore(gData.getScore() - 30);
                    pData.setShield(pData.getShield() -1);
                }
                timer = 0;
                break;

            case Armor:
                tookDamage = true;
                this.armor--;
                if(this.getId() == ID.Player){
                    gData.setScore(gData.getScore() - 60);
                    pData.setArmor(pData.getArmor() -1);
                }
                timer = 0;
                break;

            case Hull:
                tookDamage = true;
                this.hull--;
                System.out.println(this.getId() +" Hull "+this.hull);
                if(this.getId() == ID.Player){
                    pData.setHull(pData.getHull() -1);
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
    //for asteroids and projectiles
    protected void drawEllipse(Graphics g, double x, double y, double width, double height){
        Graphics2D g2d = (Graphics2D) g;
        Ellipse2D ellipse = new Ellipse2D.Double(x, y, width, height);
        g2d.setColor(color);
        g2d.draw(ellipse);
    }
    //for ships
    protected void drawRectangle(Graphics g, double x, double y, double width, double height){
        Graphics2D g2d = (Graphics2D) g;
        Rectangle2D rectangle = new Rectangle2D.Double(x, y, width, height);
        g2d.setColor(color);
        g2d.draw(rectangle);
    }
}
