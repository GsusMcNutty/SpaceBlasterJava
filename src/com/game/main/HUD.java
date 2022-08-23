package com.game.main;

import java.awt.*;

public class HUD {

    private final Handler handler;

    private GameObject player;

    private int hullMax;

    public HUD (Handler handler){
        this.handler = handler;
    }

    public void tick(){
        if(player == null){
            findPlayer();
            //System.out.println("player not found");
        }
        if(handler.getScore() <= 0){
            handler.setGameOver(true);
        }
    }
    public void render(Graphics g){
        g.setColor(Color.lightGray);
        g.fillRect(10, 10,150, 30);

        g.setColor(Color.black);
        g.drawString( "Score "+handler.getScore(), 13,25);
        if (handler.getLevel() != null){
            g.drawString(handler.getLevel(), 100, 25);
        }


        if(player!= null){
            drawShields(g);
            drawArmor(g);
            drawHull(g);
        }
        g.setColor(Color.gray);
        g.drawRect(10,10,150,30);
    }

    public void drawHull(Graphics g){
        int hull = player.getHull();
        g.setColor(Color.red);
        g.fillRect(10 ,26,3+((hullMax)*10),14);
        for(int i = 0; i < hull; i ++){
            g.setColor(Color.green);
            g.fillRect(10 ,26,3+((i+1)*10),14);
            g.setColor(Color.darkGray);
            g.drawRect(10 ,26,3+((i+1)*10),15);
        }

    }

    public void drawArmor(Graphics g){
        int armor = player.getArmor();
        for(int i = 0; i < armor; i ++){
            g.setColor(Color.darkGray);
            g.fillRect(10 ,27,10+((i+3)*10),12);
            g.setColor(Color.black);
            g.drawRect(10 ,27,9+((i+3)*10),12);
        }
    }
    public void drawShields(Graphics g){
        int shield = player.getShield();
        for(int i = 0; i < shield; i ++){
            g.setColor(Color.black);
            g.drawRect(10 ,27,15+((i+5)*10),12);
            g.setColor(Color.blue);
            g.drawRect(10 ,27,14+((i+5)*10),12);
        }
    }

    public void findPlayer(){
        for(int i = 0; i < handler.objectLL.size(); i ++){
            {
                if(handler.objectLL.get(i).getId() == ID.Player){
                player = handler.objectLL.get(i);
                hullMax = player.getHull();
                //System.out.println("player found");
                    break;
                }

            }
        }
    }

}
