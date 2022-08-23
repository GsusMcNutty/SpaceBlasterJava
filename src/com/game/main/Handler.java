package com.game.main;

import java.awt.*;
import java.util.LinkedList;

public class Handler {
    LinkedList<GameObject> objectLL = new LinkedList<>();

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
    }



}
