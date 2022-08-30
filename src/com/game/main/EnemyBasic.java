package com.game.main;

import java.awt.*;
import java.util.Random;

public class EnemyBasic extends Ship{

    private final Handler handler;
    private final float speed;

    // TODO: 8/27/2022 pull data into here like the player does from its data class 
    public EnemyBasic(Handler handler, ShipData shipData) {
        super(handler, handler.getGameData(),shipData);
        this.handler = handler;

        setX(-Game.WIDTH +100);
        Random r = new Random();
        setY(r.nextInt(Game.HEIGHT-20));
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
        if (!tookDamage){
            trackPlayer();
        }
        collisionResult();
    }
    public void trackPlayer() {
            for (int i = 0; i < handler.objectLL.size(); i++) {
                GameObject obj = handler.objectLL.get(i);
                if (obj.getId() == ID.Player) {
                    float difX =  getX() - obj.getX();
                    float difY = getY() - obj.getY();
                    float dist = (float) (Math.sqrt( (getX() - obj.getX()) * difX + difY * difY) );

                    setVelX( ((-1.0f/dist)* difX) * speed);
                    setVelY( ((-1.0f/dist)*difY) * speed);
                }
            }
    }

    public void render(Graphics g) {
        drawRectangle(g, getX(), getY(), width,height);
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
                            System.out.println("BasicEnemy Collision with a type Ship");
                            this.takeDamage(DamageTypes.NotSpecial);
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
