package com.game.main;

import java.awt.*;
import java.util.LinkedList;

public class Handler {
    LinkedList<GameObject> objectLL = new LinkedList<>();

    private int asteroidsDestroyed = 0;
    private int enemyBasicDestroyed = 0;
    public void tick(){
        for (int i = 0; i < objectLL.size(); i++) {
            objectLL.get(i).tick();
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
            asteroidsDestroyed++;
        }
        if(obj.getId() == ID.Basic){
            enemyBasicDestroyed++;
        }
    }

    public int getAsteroidsDestroyed() {
        return asteroidsDestroyed;
    }

    public int getEnemyBasicDestroyed() {
        return enemyBasicDestroyed;
    }

    public void setAsteroidsDestroyed(int asteroidsDestroyed) {
        this.asteroidsDestroyed = asteroidsDestroyed;
    }

    public void setEnemyBasicDestroyed(int enemyBasicDestroyed) {
        this.enemyBasicDestroyed = enemyBasicDestroyed;
    }
}
