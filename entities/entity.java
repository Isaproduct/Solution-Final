package entities;


import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

import main.Geme;

public abstract class Entity {

    protected float x,y;
    protected int width,height;
    protected Rectangle2D.Float hitbox;
    protected int aniTick,aniIndex;
    protected int state;
    protected float airSpeed;
    protected boolean inAir=false;
    protected int maxHealth;
    protected int currentHealth;
    protected Rectangle2D.Float attackBox;
    protected float walkSpeed=1.0f*Geme.SCALE;
    public Entity(float x,float y,int width, int height)
    {
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
    }
    protected void drawAttackBox(Graphics g, int lvlOffsetX) {

    }

    protected void drawHitbox(Graphics g,int xLvlOffset) {

    }
    protected void initHitbox(int width, int height) {

    }
    public Rectangle2D.Float getHitbox()
    {
        return hitbox;
    }
    public int getEnemyState()
    {
        return state;
    }
    public int getAniIndex()
    {
        return aniIndex;
    }
    public int getCurrentHealth() {
        return currentHealth;
    }
}
