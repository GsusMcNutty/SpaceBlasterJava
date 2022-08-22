package com.game.main;

import java.awt.*;

public class Projectile extends GameObject{
    private Color color;

    public Projectile(float x, float y, int w, int h,ID id, Handler hL, Color c) {
        super(x, y, w, h, id);
        this.color = c;
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;
    }

    @Override
    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        super.drawEllipse(g, getX(), getY(), width,height);
        g2d.setColor(color);
    }

    @Override
    public Rectangle getBounds(){
        return new Rectangle((int) getX(), (int) getY(), getWidth(), getHeight());
    }

}
