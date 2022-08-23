package com.game.main;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class MouseInput extends MouseAdapter implements MouseListener {
    private  Handler handler;
    private int mouseX;
    private int mouseY;
    private  GameObject shooter;
    public MouseInput(Handler handler){
        this.handler = handler;
    }

    public void findPlayer(){
        for(int i = 0; i < handler.objectLL.size(); i ++){
            if (handler.objectLL.get(i).getId() == ID.Player) {
                shooter = handler.objectLL.get(i);
                break;
            }
        }
    }
    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1){
            setMouseX(e.getX());
            setMouseY(e.getY());
            shootWeapon();
        }
        if(e.getButton() == MouseEvent.BUTTON2){
            System.out.println("Middle Click");
        }
        if(e.getButton() == MouseEvent.BUTTON3){

            System.out.println("Right Click");
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1){

            System.out.println("Left Click up");
        }
        if(e.getButton() == MouseEvent.BUTTON2){
            System.out.println("Middle Click up");
        }
        if(e.getButton() == MouseEvent.BUTTON3){

            System.out.println("Right Click up");

        }

    }
    public void findShooter(){
        for(int i = 0; i < handler.objectLL.size(); i ++){
           {
                shooter = handler.objectLL.get(i);
                break;
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

    public GameObject getShooter() {
        return shooter;
    }
}
