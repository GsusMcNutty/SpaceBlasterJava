package com.game.main;
import java.awt.*;

public enum ShipType {
    PLAYER(3, 3, 3, Game.WIDTH/2, Game.HEIGHT/2 ,20, 20, Color.blue, ID.Player),
    ASTEROID(1, 0, 0, 0, 0,20, 20, Color.gray, ID.Asteroid),
    ENEMYBASIC(3, 0, 0, -Game.WIDTH +100, Game.HEIGHT -20,20, 20, Color.red, ID.Basic);

    final int hull;
    final int armor;
    final int shield;
    final int width;
    final int height;
    final int startingX;
    final int startingY;
    final ID id;
    final Color color;

    ShipType(int h, int a, int s, int sX, int sY, int w, int ht, Color c, ID id){
        this.hull = h;
        this.armor = a;
        this.shield = s;
        this.color = c;
        this.startingX = sX;
        this.startingY = sY;
        this.width = w;
        this.height = ht;
        this.id = id;
    }
}


