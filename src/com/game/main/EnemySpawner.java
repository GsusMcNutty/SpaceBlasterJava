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

    public void spawnEnemy(float x, float y, ID id){
        if(isSpawning){
            handler.addObject(new EnemyBasic(x,y, handler));
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
