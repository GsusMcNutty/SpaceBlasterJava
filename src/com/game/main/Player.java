package com.game.main;

import java.awt.*;

public class Player extends Ship {
    private final Handler handler;

    public Player(Handler handler, ShipData shipData) {
        super(handler, handler.getGameData(),shipData);
        this.handler = handler;
        handler.setPlayerData(shipData);
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
        this.collisionResult();
    }

    public void render(Graphics g) {
        drawRectangle(g, getX(), getY(), width,height);
    }
    public Rectangle getBounds(){
        return new Rectangle((int) this.getX(), (int) this.getY(), this.getWidth()/2, this.getHeight()/2);
    }
    @Override
    public void collisionResult() {
        for(int i = 0; i < this.handler.objectLL.size(); i++){
            GameObject obj = this.handler.objectLL.get(i);
            if(obj.getId() != this.id){
                if(getBounds().intersects(obj.getBounds())) {
                    if (obj.getId() != ID.Projectile) {
                        if (!this.tookDamage) {
                            System.out.println("Player Collision with a type Ship");
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
