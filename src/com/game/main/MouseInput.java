package com.game.main;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class MouseInput extends MouseAdapter implements MouseListener {
    private final Handler handler;
    private int mouseX;
    private int mouseY;
    private  GameObject shooter;
    public MouseInput(Handler handler){
        this.handler = handler;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1){
            setMouseX(e.getX());
            setMouseY(e.getY());

            shootWeapon();
        }
    }

    public void findShooter(){

        for(int i = 0; i < handler.objectLL.size(); i++) {
           {
               GameObject obj = handler.objectLL.get(i);
                if(obj.getId() == ID.Player){
                    shooter = handler.objectLL.get(i);
                }
            }
        }
    }
    public void shootWeapon(){
        if(shooter != null) {
            double mX = getMouseX();
            double mY = getMouseY();
            float angle = (float) Math.atan2(mY - shooter.getY(), mX - shooter.getX());
            int pVel = 5;

            GameObject projectile = handler.addObject(new DumbRound(shooter.getX(), shooter.getY(), handler, shooter));

            projectile.velX = (float) (pVel * Math.cos(angle));
            projectile.velY = (float) (pVel * Math.sin(angle));
        }else{
            findShooter();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

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
