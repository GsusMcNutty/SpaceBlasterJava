package com.game.main;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class KeyInput extends KeyAdapter {

    private Handler handler;
    private EnemySpawner spawner;
    private GameObject shooter;

    public KeyInput(Handler handler, EnemySpawner spawner){
        this.handler = handler;
        this.spawner = spawner;
    }

    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();

        for (int i = 0; i < handler.objectLL.size(); i++){
            GameObject obj = handler.objectLL.get(i);

            if(key == KeyEvent.VK_ESCAPE) System.exit(01);
            if(obj.getId() == ID.Player){


                shooter = handler.objectLL.get(i);
                if(key == KeyEvent.VK_D) obj.setVelX(10);
                if(key == KeyEvent.VK_A) obj.setVelX(-10);
                if(key == KeyEvent.VK_W) obj.setVelY(-10);
                if(key == KeyEvent.VK_S) obj.setVelY(10);

            }
        }
    }

    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();

        for (int i = 0; i < handler.objectLL.size(); i++){
            GameObject obj = handler.objectLL.get(i);

            if(obj.getId() == ID.Player){
                if(key == KeyEvent.VK_W) obj.setVelY(0);
                if(key == KeyEvent.VK_A) obj.setVelX(0);
                if(key == KeyEvent.VK_S) obj.setVelY(0);
                if(key == KeyEvent.VK_D) obj.setVelX(0);
            }
        }
    }


}
