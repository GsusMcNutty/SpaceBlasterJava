package com.game.main;

import java.awt.*;
import java.util.LinkedList;

public class Handler {
    public LinkedList<GameObject> objectLL = new LinkedList<>();
    private boolean gameOver = false;
    private boolean restart = false;
    private String level;
    private GameData gData;
    private PlayerData pData;

    public Handler(GameData gameData, PlayerData playerData){
        this.gData = gameData;
        this.pData = playerData;
    }
    public void tick(){
        if(!gameOver){
            for (int i = 0; i < objectLL.size(); i++) {
                objectLL.get(i).tick();
            }
        }
        if(restart){
            //gdata.resetObjects();
        }
    }

    public void render(Graphics g){
        for (int i = 0; i < objectLL.size(); i++) {
            GameObject obj = objectLL.get(i);
            obj.render(g);
        }
    }

    public GameObject addObject(GameObject obj){
        this.objectLL.add(obj);
        return obj;
    }

    public void removeObject(GameObject obj){
        this.objectLL.remove(obj);
        if(obj.getId() == ID.Asteroid){
            gData.setAsteroidsDestroyed(gData.getAsteroidsDestroyed()+1);
            System.out.println(gData.getAsteroidsDestroyed());
        }
        if(obj.getId() == ID.Basic){
            gData.setEnemyBasicDestroyed(gData.getEnemyBasicDestroyed()+1);
            System.out.println(gData.getEnemyBasicDestroyed());
        }
    }


    public String getLevel() {
        return level;
    }
    public void setLevel(String level) {
        this.level = level;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public GameData getGData() {
        return gData;
    }

    public PlayerData getpData() {
        return pData;
    }
}
