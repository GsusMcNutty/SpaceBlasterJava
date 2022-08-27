package com.game.main;

import java.awt.*;

public class Asteroid extends Ship{
    private Handler handler;

    // TODO: 8/27/2022 pull data into here like the player does from its data class
        public Asteroid(int x, int y, int w, int h, ID id, Handler handler, int hl, int a, int s, Color color, int vX, int vY) {
            super(x, y, w, h, id, handler, 0, 0, 1, color);
            this.handler = handler;
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


            /*
            if(y <= -height*2){
                handler.removeObject(this);
            }
            if(y >= Game.HEIGHT + height){
                handler.removeObject(this);
            }
            if(x <= -width){
                handler.removeObject(this);
            }
            if(x >= Game.WIDTH + width){
                handler.removeObject(this);
            }

             */
            this.collisionResult();
        }
    public void render(Graphics g) {
        drawEllipse(g, this.getX(), this.getY(), width, height);
    }
    public Rectangle getBounds(){
        return new Rectangle((int) this.getX(), (int) this.getY(), this.getWidth(), this.getHeight());
    }
    @Override
    public void collisionResult() {
        for(int i = 0; i < handler.objectLL.size(); i++){
            GameObject obj = handler.objectLL.get(i);
            if(obj.getId() != this.id){
                if(getBounds().intersects(obj.getBounds())) {
                    if (this.collision() != ID.Projectile) {
                        if (!tookDamage) {
                            System.out.println("Asteroid Collision with a type Ship");
                            this.takeDamage(DamageTypes.NotSpecial);
                            setVelX(getVelX() * -1);
                            setVelY(getVelY() * -1);
                        }
                    }
                    if (this.collision() == ID.Projectile) {
                        System.out.println("ASteroidCollision with a type Projectile");
                    }
                }
            }
        }
    }
}

