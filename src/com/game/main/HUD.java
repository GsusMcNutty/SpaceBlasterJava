package com.game.main;

import java.awt.*;

public class HUD {

    private final Handler handler;

    private GameObject player;
    private final EnemySpawner spawner;

    private int hull;
    private int armor;
    private int shield;

    public HUD (Handler handler){
        this.handler = handler;
        this.spawner = new EnemySpawner(handler);
    }

    public void tick(){
        if(player != null){
            hull = player.getHull();
            armor = player.getArmor();
            shield = player.getShield();
        } else findPlayer();

    }
    public void render(Graphics g){
        g.setColor(Color.lightGray);
        g.fillRect(10, 10,100, 30);
        g.setColor(Color.blue);
        g.drawRect(10,10,100,30);

        g.setColor(Color.black);
        g.drawString( "Score "+spawner.getScore(), 15,25);
    }

    public void findPlayer(){
        for(int i = 0; i < handler.objectLL.size(); i ++){
            {
                if(handler.objectLL.get(i).getId() == ID.Player){
                player = handler.objectLL.get(i);
                break;
                }

            }
        }
    }

}
