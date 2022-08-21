package com.game.main;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class EnemyBasic extends GameObject{
    private Handler handler;
    public EnemyBasic(int x, int y, int w, int h, ID id, Handler handler) {
        super(x, y, w, h, id);
        this.handler = handler;

        velX = 2;
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        if(y <= 0 || y >= Game.HEIGHT ){
            velY *= -1;
        }
        if(x <= 0|| x >= Game.WIDTH){
            velX *= -1;
        }
    }

    private void collision(){
        for(int i = 0; i < handler.objectLL.size(); i++){
            GameObject obj = handler.objectLL.get(i);

            if(obj.getId() == ID.Asteroids){
                if(getBounds().intersects(obj.getBounds())){
                    //life -= 1;
                    //System.out.println(life);
                    handler.removeObject(obj);
                }
            }
        }
    }
    public void render(Graphics g) {

        drawRectangle(g, getX(), getY(), width,height);
        //drawRectangle(g, Color.blue, getX(), getY()-10, width,height);

    }

    private void drawRectangle(Graphics g, double x, double y, double width, double height){
        Graphics2D g2d = (Graphics2D) g;
        double centerX = x;
        double centerY = y;
        Rectangle2D rectangle = new Rectangle2D.Double(centerX,centerY, width, height);
        g2d.setColor(Color.RED);
        g2d.draw(rectangle);
    }
}
