package com.game.main;

import java.awt.*;
import java.util.Random;

public class Asteroid extends Ship{
    private final Handler handler;

    public Asteroid(Handler handler, int vX, int vY, ShipData shipData) {
            super(handler, handler.getGameData(),new ShipData(ShipType.ASTEROID));
            this.handler = handler;

            Random r = new Random();
            setX(r.nextInt(Game.WIDTH));
            setY(Game.HEIGHT -20);
            setVelX(vX);
            setVelY(-vY);
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
            collisionResult();
        }
    public void render(Graphics g) {
        drawEllipse(g, getX(), getY(), width, height);
    }
    public Rectangle getBounds(){
        return new Rectangle((int) getX(), (int) getY(), getWidth(), getHeight());
    }
    @Override
    public void collisionResult() {
        for(int i = 0; i < handler.objectLL.size(); i++){
            GameObject obj = handler.objectLL.get(i);
            if(obj.getId() != this.id){
                if(getBounds().intersects(obj.getBounds())) {
                    if (obj.getId() != ID.Projectile) {
                        if (!tookDamage) {
                            System.out.println("Asteroid Collision with a type Ship");
                            takeDamage(DamageTypes.NotSpecial);
                            setVelX(getVelX() * -1);
                            setVelY(getVelY() * -1);
                        }
                    }
                    if (obj.getId() == ID.Projectile) {
                        if(obj.getOrigin() != this){
                            //System.out.println("Collision with a type Projectile");
                            takeDamage(DamageTypes.NotSpecial);
                            handler.removeObject(obj);
                        }

                    }
                }
            }
        }
    }
}

