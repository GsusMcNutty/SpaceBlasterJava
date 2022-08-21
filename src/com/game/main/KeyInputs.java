package com.game.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInputs extends KeyAdapter {

    private  Handler handler;
    private  EnemySpawner spawner;

    public KeyInputs(Handler handler, EnemySpawner spawner){
        this.handler = handler;
        this.spawner = spawner;
    }

    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();

        for (int i = 0; i < handler.objectLL.size(); i++){
            GameObject obj = handler.objectLL.get(i);
            if(key == KeyEvent.VK_ESCAPE) System.exit(01);

            if(obj.getId() == ID.Player){
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
