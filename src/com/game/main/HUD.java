package com.game.main;

import java.awt.*;

public class HUD {

    private final Handler h;
    private final PlayerData pD;
    private GameData gData;

    public HUD (Handler handler, PlayerData playerData){
        this.h = handler;
        this.pD = playerData;
        this.gData = h.getGData();
    }

    public void tick(){

    }
    public void render(Graphics g){
        g.setColor(Color.lightGray);
        g.fillRect(10, 10,150, 30);

        g.setColor(Color.black);
        g.drawString( "Score "+ gData.getScore(), 13,25);
        if (h.getLevel() != null){
            g.drawString(h.getLevel(), 100, 25);
        }

        if(pD != null){
            //System.out.println("drawing hud");
            drawShields(g);
            drawArmor(g);
            drawHull(g);
        }
        g.setColor(Color.gray);
        g.drawRect(10,10,150,30);
    }

    // TODO: 8/27/2022 need to migrate data from or to player data 
    public void drawHull(Graphics g){
        //red background for hull
        g.setColor(Color.red);
        g.fillRect(10 ,26,3+((pD.getMaxHull())*10),14);
        for(int i = 0; i < pD.getHull(); i ++){
            g.setColor(Color.green);
            g.fillRect(10 ,26,3+((i+1)*10),14);
            g.setColor(Color.darkGray);
            g.drawRect(10 ,26,3+((i+1)*10),15);
        }
    }

    public void drawArmor(Graphics g){
        for(int i = 0; i < pD.getArmor(); i ++){
            g.setColor(Color.darkGray);
            g.fillRect(10 ,27,10+((i+3)*10),12);
            g.setColor(Color.black);
            g.drawRect(10 ,27,9+((i+3)*10),12);
        }
    }
    public void drawShields(Graphics g){
        for(int i = 0; i < pD.getShield(); i ++){
            System.out.println("drawing shield" + i);
            g.setColor(Color.black);
            g.drawRect(10 ,27,15+((i+5)*10),12);
            g.setColor(Color.blue);
            g.drawRect(10 ,27,14+((i+5)*10),12);
        }
    }
}
