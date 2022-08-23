package com.game.main;

import java.awt.*;

public class DumbRound extends Projectile{
    public DumbRound(float x, float y, Handler hL, GameObject s) {
        super(x, y, 5, 5, ID.Projectile,  hL, Color.yellow, DamageTypes.NotSpecial);
        setOrigin(s);
    }
    public void render(Graphics g) {
        drawEllipse(g, getX(), getY(), width,height);
    }


}
