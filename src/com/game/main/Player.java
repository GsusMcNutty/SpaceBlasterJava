package com.game.main;

import java.awt.*;

public class Player extends Ship {
    private Handler handler;
    private PlayerData pData;
    private int hull, armor, shield;
    public Player(Handler handler, PlayerData pData) {
        super(pData.getStartX(), pData.getStartY(), pData.getWidth(), pData.getHeight(), pData.getId(), handler, pData.getShield(), pData.getArmor(), pData.getHull(), pData.getColor());
        this.pData = pData;
        this.handler = handler;
        this.hull = pData.getHull();
        this.armor = pData.getArmor();
        this.shield = pData.getShield();
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
        for(int i = 0; i < handler.objectLL.size(); i++){
            GameObject obj = handler.objectLL.get(i);
            if(obj.getId() != this.id){
                if(getBounds().intersects(obj.getBounds())) {
                    if (obj.getId() != ID.Projectile) {
                        if (!tookDamage) {
                            System.out.println("Player Collision with a type Ship");
                            this.takeDamage(DamageTypes.NotSpecial);
                            setVelX(getVelX() * -1);
                            setVelY(getVelY() * -1);
                        }
                    }
                    if (this.collision() == ID.Projectile) {
                        if(obj.getOrigin() != this){
                            //System.out.println("Collision with a type Projectile");
                            this.takeDamage(DamageTypes.NotSpecial);
                        }

                    }
                }
            }
        }
    }
}
