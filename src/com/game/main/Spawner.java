package com.game.main;

import java.util.Objects;
import java.util.Random;

public class Spawner {

    private final Handler handler;
    private final GameData gData;
    private LevelData level;
    private final Random r = new Random();
    private LevelState state;
    private int curLevel;
    private int timer;
    private int astSpawned;
    private int eBasicSpawned;

    public Spawner(Handler handler, GameData gameData){
        this.handler = handler;
        this.gData = gameData;
        state = LevelState.START;
        curLevel = 4;
        level = LevelData.LEVEL1;
    }
    public void tick(){
        timer++;

        runSpawner();
    }
    enum  LevelState {
        START, SPAWNENEMIES, WAITINGTOSPAWN, ENDLEVEL, SWITCHLEVEL, PAUSED, RESETGAME,GAMEOVER
    }
    protected void runSpawner(){
        switch (state){
            case START:
                if (Objects.equals(level.toString(), "LEVEL" + curLevel)){
                    System.out.println(level.toString());
                    System.out.println(level);
                    handler.setLevel("Level "+curLevel);
                    astSpawned=0;
                    eBasicSpawned = 0;
                    gData.setAsteroidsDestroyed(0);
                    gData.setEnemyBasicDestroyed(0);
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

                if(gData.getAsteroidsDestroyed() + gData.getEnemyBasicDestroyed() >= level.totalEnemies){
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
                if(curLevel < LevelData.values().length){
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
            case GAMEOVER:
                break;
            case RESETGAME:
                break;
            default:
                System.out.println("Unknown State");
        }
    }

    public void spawnEnemy(){
        GameObject asteroid = new Asteroid( handler, r.nextInt( 3- 1) + 1, r.nextInt(3-1)+1, new ShipData(ShipType.ASTEROID));
        //GameObject asteroid = new Asteroid(r.nextInt(Game.WIDTH), Game.HEIGHT -20,  handler, r.nextInt( 3- 1) + 1, r.nextInt(3-1)+1, ShipType.ASTEROID, gData);
        GameObject enemyBasic = new EnemyBasic( handler, new ShipData(ShipType.ENEMYBASIC));
        //GameObject enemyBasic = new EnemyBasic(-Game.WIDTH +100, r.nextInt(Game.HEIGHT-20), handler, ShipType.ENEMYBASIC, gData);

            if(astSpawned < level.maxNumberAsteroids){
               this.handler.addObject(asteroid);
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
        level = LevelData.valueOf("LEVEL"+l);
    }

}
