package com.game.main;

import java.util.Objects;
import java.util.Random;

public class EnemySpawner {

    private Handler handler;
    private HUD hud;
    private Level level;
    private Random r = new Random();
    private LevelState state;
    private int curLevel;
    private int curSpawn;
    private int score;
    private int timer;
    private boolean isSpawning = false;
    private GameObject asteroid;
    private int astSpawned;
    private GameObject enemyBasic;
    private int eBasicSpawned;

    public EnemySpawner(Handler handler){
        this.handler = handler;
        this.hud = hud;
        state = LevelState.START;
        curLevel = 2;
        level = Level.LEVEL1;
    }
    public void tick(){
        timer++;
        runSpawner();
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
    enum  LevelState {
        START, SPAWNENEMIES, WAITINGTOSPAWN, ENDLEVEL, SWITCHLEVEL, PAUSED;
    }
    protected void runSpawner(){
        switch (state){
            case START:
                if (Objects.equals(level.toString(), "LEVEL" + curLevel)){
                    System.out.println(level.toString());
                    System.out.println(level);
                    curSpawn = 0;
                    astSpawned = 0;
                    eBasicSpawned = 0;
                    state = LevelState.SPAWNENEMIES;

                }else {
                    state = LevelState.SWITCHLEVEL;
                    System.out.println("NoMatch");
                }
                break;
            case SPAWNENEMIES:
                if(curSpawn <= level.totalEnemies){
                    spawnEnemy();
                    System.out.println(curSpawn);
                    state = LevelState.WAITINGTOSPAWN;
                    timer = 0;
                    curSpawn++;
                }
                if(curSpawn >= level.totalEnemies){
                    state = LevelState.ENDLEVEL;
                    curLevel++;
                }

               break;
            case WAITINGTOSPAWN:
                if(timer > r.nextInt(600-300)){
                    state = LevelState.SPAWNENEMIES;
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
                break;
            case PAUSED:
                break;
            default:
                System.out.println("Unknown State");
        }
    }

    public void spawnEnemy(){
        asteroid = new Asteroid(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT),handler);
        enemyBasic = new EnemyBasic(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT),handler);
            if(astSpawned <= level.maxNumberAsteroids){
                handler.addObject(asteroid);
                astSpawned++;
            }
            if(level.canSpawnBasic){
                if(eBasicSpawned <= level.maxNumberBasic){
                    handler.addObject(enemyBasic);
                    eBasicSpawned++;
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
