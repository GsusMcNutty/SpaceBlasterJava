package com.game.main;

public  class GameData {
    private int asteroidsDestroyed = 0, enemyBasicDestroyed = 0;
    private int startingLevel = 1, savedLevel =1, curLevel = 1;

    private int startScore = 10, score = 0;
/*
    public void resetObjects(){
        setGameOver(true);
        for (int i = 0; i < objectLL.size(); i++) {
            if (objectLL.get(i).getId() != ID.Player){
                removeObject(objectLL.get(i));
            }
            if(objectLL.size() == 0){
                score = startScore;
            }
        }
    }
 */
    public GameData( PlayerData playerData){
    }

    public int getAsteroidsDestroyed() {
        return asteroidsDestroyed;
    }

    public void setAsteroidsDestroyed(int asteroidsDestroyed) {
        this.asteroidsDestroyed = asteroidsDestroyed;
    }

    public int getEnemyBasicDestroyed() {
        return enemyBasicDestroyed;
    }

    public void setEnemyBasicDestroyed(int enemyBasicDestroyed) {
        this.enemyBasicDestroyed = enemyBasicDestroyed;
    }

    public int getStartScore() {
        return startScore;
    }

    public void setStartScore(int startScore) {
        this.startScore = startScore;
    }

    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }

    public int getStartingLevel() {
        return startingLevel;
    }

    public void setStartingLevel(int startingLevel) {
        this.startingLevel = startingLevel;
    }

    public int getSavedLevel() {
        return savedLevel;
    }

    public void setSavedLevel(int savedLevel) {
        this.savedLevel = savedLevel;
    }

    public int getCurLevel() {
        return curLevel;
    }

    public void setCurLevel(int curLevel) {
        this.curLevel = curLevel;
    }
}
