package com.game.main;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class MouseInput extends MouseAdapter implements MouseListener {
    private final Handler handler;
    private int mouseX;
    private int mouseY;
    private  GameObject player;
    private ProjectileData projectileD;
    public MouseInput(Handler handler){
        this.handler = handler;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1){
            if(!handler.isGameOver()){
                if(player != null){
                    setMouseX(e.getX());
                    setMouseY(e.getY());

                    shootWeapon();
                } else findShooter();
            }
        }
    }

    public void findShooter(){

        for(int i = 0; i < handler.objectLL.size(); i++) {
           {
               GameObject obj = handler.objectLL.get(i);
                if(obj.getId() == ID.Player){
                    player = handler.objectLL.get(i);
                }
            }
        }
    }
    public void shootWeapon(){
        double mX = getMouseX();
        double mY = getMouseY();
        float angle = (float) Math.atan2(mY - player.getY(), mX - player.getX());
        int pVel = 5;

        GameObject projectile = handler.addObject(new DumbRound(player.getX(), player.getY(), handler, player));

        projectile.velX = (float) (pVel * Math.cos(angle));
        projectile.velY = (float) (pVel * Math.sin(angle));

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        findShooter();
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public int getMouseX() {
        return mouseX;
    }

    public void setMouseX(int mouseX) {
        this.mouseX = mouseX;
    }

    public int getMouseY() {
        return mouseY;
    }

    public void setMouseY(int mouseY) {
        this.mouseY = mouseY;
    }

}
