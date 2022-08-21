package com.game.main;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Player extends GameObject {
    private Handler handler;
    private int life;

    public Player(int x, int y, int w, int h, ID id, Handler handler) {
        super(x, y, w, h, id);
        this.handler = handler;
        life = 1;
    }
    public Rectangle getBounds(){
        return new Rectangle( x, y, width, height);
    }

    public void tick() {
        x += velX;
        y += velY;

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

        collision();
    }

    private void collision(){
        for(int i = 0; i < handler.objectLL.size(); i++){
            GameObject obj = handler.objectLL.get(i);

            if(obj.getId() == ID.Basic){
                if(getBounds().intersects(obj.getBounds())){
                    life -= 1;
                    System.out.println(life);
                    handler.removeObject(obj);
                }
            }
        }
    }

    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        drawRectangle(g, getX(), getY(), width,height);
        //drawRectangle(g, Color.blue, getX(), getY()-10, width,height);
        g.setColor(Color.GREEN);
        g2d.draw(getBounds());
    }

    private void drawEllipse(Graphics g, double x, double y, double width, double height){
        Graphics2D g2d = (Graphics2D) g;
        double centerX = x - width;
        double centerY = y - height;
        Ellipse2D ellipse = new Ellipse2D.Double(centerX,centerY, width, height);
        g2d.setColor(Color.blue);
        g2d.draw(ellipse);
    }
    private void drawRectangle(Graphics g, double x, double y, double width, double height){
        Graphics2D g2d = (Graphics2D) g;
        double centerX = x;
        double centerY = y;
        Rectangle2D rectangle = new Rectangle2D.Double(centerX,centerY, width, height);
        g2d.setColor(Color.blue);
        g2d.draw(rectangle);
    }



}
