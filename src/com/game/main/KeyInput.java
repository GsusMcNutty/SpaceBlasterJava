package com.game.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    private final Handler handler;


    public KeyInput(Handler handler){
        this.handler = handler;
    }

    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();

        for (int i = 0; i < handler.objectLL.size(); i++){
            GameObject obj = handler.objectLL.get(i);

            if(key == KeyEvent.VK_ESCAPE) System.exit(1);
            if(obj.getId() == ID.Player){

                if(key == KeyEvent.VK_D) obj.setVelX(10);
                if(key == KeyEvent.VK_A) obj.setVelX(-10);
                if(key == KeyEvent.VK_W) obj.setVelY(-10);
                if(key == KeyEvent.VK_S) obj.setVelY(10);

            }
        }
        if(key == KeyEvent.VK_R) {
            System.out.println("Restart");
            //handler.resetObjects();
            //reset will be called from elsewhere
        }
    }

    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();

        for (int i = 0; i < handler.objectLL.size(); i++){
            GameObject obj = handler.objectLL.get(i);

            if(obj.getId() == ID.Player){
                if(key == KeyEvent.VK_W) {
                    obj.setLastVelY(-10);
                    obj.setVelY(0);
                }
                if(key == KeyEvent.VK_A){
                    obj.setLastVelX(-10);
                    obj.setVelX(0);
                }
                if(key == KeyEvent.VK_S) {
                    obj.setLastVelY(10);
                    obj.setVelY(0);
                }
                if(key == KeyEvent.VK_D){
                    obj.setLastVelX(10);
                    obj.setVelX(0);
                }
            }
        }
    }


}
