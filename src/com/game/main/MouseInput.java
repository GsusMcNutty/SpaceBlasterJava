package com.game.main;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class MouseInput extends Frame implements MouseListener {

    private  Handler handler;
    public MouseInput(Handler handler){
        this.handler = handler;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1){

            System.out.println("Left Click");
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

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
