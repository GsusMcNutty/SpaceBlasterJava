package com.game.main;

import java.awt.*;

public class EnemyBasic extends Ship{
    private final Handler handler;
    private final float speed;
    public EnemyBasic(float x, float y, Handler handler) {
        super(x, y, 20, 20, ID.Basic, handler, 3, 0, 0, Color.red);
        this.handler = handler;
        speed = 2f;
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
        if (!this.tookDamage){
            trackPlayer();
        }
    }
    public void trackPlayer() {
            for (int i = 0; i < handler.objectLL.size(); i++) {
                GameObject obj = handler.objectLL.get(i);
                if (obj.getId() == ID.Player) {
                    float difX =  this.getX() - obj.getX();
                    float difY = this.getY() - obj.getY();
                    float dist = (float) (Math.sqrt( (this.getX() - obj.getX()) * difX + difY * difY) );

                    this.setVelX( ((-1.0f/dist)* difX) * speed);
                    this.setVelY( ((-1.0f/dist)*difY) * speed);
                }
            }
    }

    public void render(Graphics g) {
        drawRectangle(g, getX(), getY(), width,height);
    }

    @Override
    public void collisionResult() {

    }
}
