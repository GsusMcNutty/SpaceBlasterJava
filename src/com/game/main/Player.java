package com.game.main;

import java.awt.*;

public class Player extends Ship {
    public Player(int x, int y, Handler handler, PlayerData playerData) {
        super(x, y, 20, 20, ID.Player, handler, 3,3, 3, Color.blue);

    }

    @Override
    public void tick() {
        super.tick();
        if(y <= -height){
            y = Game.HEIGHT - height;
        }
        if(y >= Game.HEIGHT + height){
            y = -height;
        }
        if(x <= -width){
            x = Game.WIDTH - width;
        }
        if(x >= Game.WIDTH + width){
            x = -width;
        }
        collisionResult();
    }

    public void render(Graphics g) {
        drawRectangle(g, getX(), getY(), width,height);
    }

    @Override
    public void collisionResult() {
        if(this.collision() != this.id){
            if(this.collision() != ID.Projectile){
                if(!tookDamage){
                    System.out.println("Collision with a type Ship");
                    takeDamage(DamageTypes.NotSpecial);
                }
            }
            if(this.collision() == ID.Projectile){
                System.out.println("Collision with a type Projectile");
            }
        }
    }
}
