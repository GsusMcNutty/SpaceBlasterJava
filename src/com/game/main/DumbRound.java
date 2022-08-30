package com.game.main;

import java.awt.*;

public class DumbRound extends Projectile{
    private ProjectileData projData;
    public DumbRound(float x, float y, Handler hL, GameObject s) {
        super(x, y, 5, 5, ID.Projectile,  hL, Color.yellow);
        setOrigin(s);
        projData = new ProjectileData();

        projData.setDamage(DamageTypes.NotSpecial);
    }
    public void render(Graphics g) {
        drawEllipse(g, getX(), getY(), width,height);
    }

    @Override
    public void collisionResult() {

    }
}

