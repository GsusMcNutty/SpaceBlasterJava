package com.game.main;

import java.awt.*;

public class Asteroid extends Ship{
        public Asteroid(int x, int y, int w, int h, ID id, Handler handler, int hl, int a, int s, Color color) {
            super(x, y, w, h, id, handler,h ,a ,s , color);

            setVelX(2);
            setVelY(-2);
        }

        @Override
        public void tick() {
            super.tick();
            if(y <= -height*2){
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
        }
    public void render(Graphics g) {
        drawEllipse(g, getX(), getY(), width,height);
    }

    @Override
    public void collisionResult() {

    }
}

