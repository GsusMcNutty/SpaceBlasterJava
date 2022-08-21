package com.game.main;

import java.util.Random;

public class EnemySpawner {

    private Handler handler;
    private Random r = new Random();
    private boolean isSpawning = false;

    public EnemySpawner(Handler handler){
        this.handler = handler;
    }
    public void tick(){

    }

    public void spawnEnemy(ID id){
        if(isSpawning == true){
            handler.addObject(new EnemyBasic(200,200, 10,10, id, handler));
            setSpawning(false);
        }
    }

    public boolean isSpawning() {
        return isSpawning;
    }

    public void setSpawning(boolean spawning) {
        isSpawning = spawning;
    }

}
