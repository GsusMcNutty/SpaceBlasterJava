package com.game.main;

import java.awt.*;

public abstract class Pickup extends GameObject{
    public Pickup(float x, float y, int w, int h, ID id, Handler hl) {
        super(x, y, w, h, id, hl);
    }

    @Override
    public void tick() {
        x += getVelX();
        y += getVelY();
    }

    @Override
    public void render(Graphics g) {
        // TODO: 8/22/2022 goes to super
    }

    @Override
    public Rectangle getBounds() {
        return null;
    }
}
