package com.game.main;

import java.awt.*;

public class HUD {

    private final Handler h;
    private ShipData playerData;
    private final GameData gameData;

    public HUD (Handler handler){
        h = handler;
        playerData = h.getPlayerData();
        gameData = h.getGameData();
    }

    public void tick(){

    }
    public void render(Graphics g){
        g.setColor(Color.lightGray);
        g.fillRect(10, 10,150, 30);

        g.setColor(Color.black);
        g.drawString( "Score "+ gameData.getScore(), 13,25);
        if (h.getLevel() != null){
            g.drawString(h.getLevel(), 100, 25);
        }

        if(playerData != null){
            //System.out.println("drawing hud");
            drawShields(g);
            drawArmor(g);
            drawHull(g);
        } else{
            playerData = h.getPlayerData();
            System.out.println("Player is null");
        }
        g.setColor(Color.gray);
        g.drawRect(10,10,150,30);
    }

    public void drawHull(Graphics g){
        //red background for hull
        g.setColor(Color.red);
        g.fillRect(10 ,26,3+((playerData.getMaxHull())*10),14);
        for(int i = 0; i < playerData.getHull(); i ++){
            g.setColor(Color.green);
            g.fillRect(10 ,26,3+((i+1)*10),14);
            g.setColor(Color.darkGray);
            g.drawRect(10 ,26,3+((i+1)*10),15);
        }
    }

    public void drawArmor(Graphics g){
        for(int i = 0; i < playerData.getArmor(); i ++){
            g.setColor(Color.darkGray);
            g.fillRect(10 ,27,10+((i+3)*10),12);
            g.setColor(Color.black);
            g.drawRect(10 ,27,9+((i+3)*10),12);
        }
    }
    public void drawShields(Graphics g){
        for(int i = 0; i < playerData.getShield(); i ++){
            //System.out.println("drawing shield" + i);
            g.setColor(Color.black);
            g.drawRect(10 ,27,15+((i+5)*10),12);
            g.setColor(Color.blue);
            g.drawRect(10 ,27,14+((i+5)*10),12);
        }
    }
}
