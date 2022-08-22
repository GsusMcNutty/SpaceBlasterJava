package com.game.main;

import java.awt.*;

public class Player extends Ship {
    public Player(int x, int y, Handler handler) {
        super(x, y, 20, 20, ID.Player, handler, 3,3, Color.blue);
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
        collision(this.id);

    }

    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        super.drawRectangle(g, getX(), getY(), width,height);
        g2d.draw(getBounds());
    }


}
