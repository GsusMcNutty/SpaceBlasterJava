package com.game.main;

public enum ID {
    Asteroid(25),
    Basic(50),
    PickUp(10),
    Player(-1000),
    Projectile(-1);

    final int scoreWorth;

    ID(int scoreWorth){
        this.scoreWorth = scoreWorth;
    }

}
