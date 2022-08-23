package com.game.main;

import java.security.PublicKey;
import java.util.Objects;
import java.util.Random;

public class EnemySpawner {

    private final Handler handler;
    private Level level;
    private final Random r = new Random();
    private LevelState state;
    private int curLevel;
    private int curSpawn;
    private int score;
    private int timer;
    private int astSpawned;
    private boolean astMaxed;
    private int eBasicSpawned;

    public EnemySpawner(Handler handler){
        this.handler = handler;
        state = LevelState.START;
        curLevel = 1;
        level = Level.LEVEL1;
    }
    public void tick(){
        timer++;

        runSpawner();
    }
    enum  LevelState {
        START, SPAWNENEMIES, WAITINGTOSPAWN, ENDLEVEL, SWITCHLEVEL, PAUSED
    }
    protected void runSpawner(){
        switch (state){
            case START:
                if (Objects.equals(level.toString(), "LEVEL" + curLevel)){
                    System.out.println(level.toString());
                    System.out.println(level);
                    curSpawn = 0;
                    astSpawned=0;
                    eBasicSpawned = 0;
                    handler.setAsteroidsDestroyed(0);
                    handler.setEnemyBasicDestroyed(0);
                    state = LevelState.SPAWNENEMIES;
                    System.out.println("Start");

                }else {
                    state = LevelState.SWITCHLEVEL;
                    System.out.println("NoMatch");
                }
                break;
            case SPAWNENEMIES:
                spawnEnemy();

                astSpawned = 0;
                eBasicSpawned = 0;
                state = LevelState.WAITINGTOSPAWN;

                if(handler.getAsteroidsDestroyed() + handler.getEnemyBasicDestroyed() >= level.totalEnemies){
                    state = LevelState.ENDLEVEL;
                    curLevel++;
                }
               break;
            case WAITINGTOSPAWN:
                checkEnemies();
                if(timer > r.nextInt(60-30)){
                    state = LevelState.SPAWNENEMIES;

                    timer = 0;
                }
                break;
            case ENDLEVEL:
                if(curLevel < Level.values().length){
                    state = LevelState.SWITCHLEVEL;
                }
                else{
                    System.out.println("Congrats, you win!");
                    state =LevelState.PAUSED;
                }
                break;
            case SWITCHLEVEL:
                ChooseLevel(curLevel);
                state = LevelState.START;
                System.out.println("LevelSwitch");
                break;
            case PAUSED:
                break;
            default:
                System.out.println("Unknown State");
        }
    }

    public void spawnEnemy(){
        GameObject asteroid = new Asteroid(r.nextInt(Game.WIDTH), Game.HEIGHT -20, handler);
        GameObject enemyBasic = new EnemyBasic(-Game.WIDTH +100, r.nextInt(Game.HEIGHT-20), handler);

            if(astSpawned < level.maxNumberAsteroids){
                handler.addObject(asteroid);
            }

            if(level.canSpawnBasic){
                if(eBasicSpawned < level.maxNumberBasic){
                    handler.addObject(enemyBasic);

            }
        }
    }
    public void checkEnemies(){
        for (int i = 0; i < handler.objectLL.size(); i++){
            GameObject obj = handler.objectLL.get(i);
            if(obj.getId() == ID.Asteroid){
                if(astSpawned < level.maxNumberAsteroids){
                    astSpawned++;
                }
            }
            if(obj.getId() == ID.Basic){
                if(eBasicSpawned < level.maxNumberBasic){
                    eBasicSpawned++;
                }
            }
        }
    }
    public void ChooseLevel(int l)
    {
        level = Level.valueOf("LEVEL"+l);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

}
