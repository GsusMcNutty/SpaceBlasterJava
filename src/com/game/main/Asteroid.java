package com.game.main;

import java.awt.*;

public class Asteroid extends Ship{
        public Asteroid(int x, int y, Handler handler) {
            super(x, y, 20, 20, ID.Asteroid,handler,1, 0, Color.gray);
            setVelX(2);
            setVelY(-2);
        }

        @Override
        public void tick() {
            super.tick();
            if(y <= 0 || y >= Game.HEIGHT - height *2){
                setVelY(getVelY() * -1);
            }
            if(x <= -width|| x >= Game.WIDTH - width){
                setVelX(getVelX()*-1);
            }
            collision();
        }
    public void render(Graphics g) {
        drawEllipse(g, getX(), getY(), width,height);
    }
}

