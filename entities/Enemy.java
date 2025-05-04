package entities;

import main.Geme;
public abstract class Enemy extends Entity{

    public Enemy() {
    }

    protected void firstUpdateCheck() {
    }

    protected void updateInAir() {
    }

    protected void move() {
    }

    protected void turnTowardPlayer() {
    }

    protected boolean canSeePlayer() {
    }

    protected boolean isPlayerInRange() {
    }

    protected boolean isPlayerCloseForAttack() {
    }

    protected void newState() {
    }

    public void hurt() {
    }

    protected void checkEnemyHit() {
    }

    protected void updateAnimationTick() {
    }

    protected void changeWalkDir() {
    }

    public void resetEnemy(){
    }

    public boolean isActive()
    {
        return active;
    }
}
