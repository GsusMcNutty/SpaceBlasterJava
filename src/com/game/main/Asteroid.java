package com.game.main;

import java.awt.*;

public class Asteroid extends Ship{
    private Handler handler;

        public Asteroid(int x, int y, Handler handler, int vX, int vY, EnemyType t, GameData gd) {
            super(x, y, t.width, t.height, t.id, handler, t.hull, t.armor, t.shield, t.color, gd);
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
                    if (obj.getId() != ID.Projectile) {
                        if (!tookDamage) {
                            System.out.println("Asteroid Collision with a type Ship");
                            this.takeDamage(DamageTypes.NotSpecial);
                            setVelX(getVelX() * -1);
                            setVelY(getVelY() * -1);
                        }
                    }
                    if (obj.getId() == ID.Projectile) {
                        if(obj.getOrigin() != this){
                            //System.out.println("Collision with a type Projectile");
                            this.takeDamage(DamageTypes.NotSpecial);
                            handler.removeObject(obj);
                        }

                    }
                }
            }
        }
    }
}

