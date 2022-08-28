package com.game.main;
import java.awt.*;

public enum EnemyType {
    ASTEROID(1, 0, 0, 20, 20, Color.gray, ID.Asteroid),
    ENEMYBASIC(3, 0, 0, 20, 20, Color.red, ID.Basic);

    int hull, armor, shield, width, height;
    ID id;
    Color color;

    EnemyType(int h, int a, int s, int w, int ht, Color c, ID id){
        this.hull = h;
        this.armor = a;
        this.shield = s;
        this.color = c;
        this.width = w;
        this.height = ht;
        this.id = id;
    }
}


