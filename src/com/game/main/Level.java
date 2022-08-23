package com.game.main;


public enum Level {
    LEVEL1(5,3,3, 0, false),
    LEVEL2(10,5,5, 0, false),
    LEVEL3(15,10,10, 0,false),
    LEVEL4(20,15,15, 0,false),
    LEVEL5(25,15,10, 3, true),
    LEVEL6(30,15,10, 5, true),
    LEVEL7(35,15,10, 10, true),
    LEVEL8(40,20,10, 10, true),
    LEVEL9(45,20,10, 10, true),
    LEVEL10(50,25,10, 10, true);

    final int totalEnemies;
    final int maxEnemies;
    final int maxNumberAsteroids;
    final int maxNumberBasic;
    final boolean canSpawnBasic;

    Level (int totalEnemies, int maxEnemies, int maxNumberAsteroids, int maxNumberBasic, boolean canSpawnBasic){
        this.totalEnemies = totalEnemies;
        this.maxEnemies = maxEnemies;
        this.maxNumberAsteroids = maxNumberAsteroids;
        this.maxNumberBasic = maxNumberBasic;
        this.canSpawnBasic = canSpawnBasic;
    }
}
