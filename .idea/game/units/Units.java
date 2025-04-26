package game.units;

import game.core.Attackable;
import game.core.Movable;

public abstract class Unit implements Attackable, Movable {
    protected int hitPoints;
    protected int attackPower;
    protected int movementRange;
    protected int attackRange;
    protected int goldCost;
    protected int foodCost;
    public int unitSpace;

    public Unit(int hitPoints, int attackPower, int movementRange, int attackRange, int goldCost, int foodCost, int unitSpace) {
        this.hitPoints = hitPoints;
        this.attackPower = attackPower;
        this.movementRange = movementRange;
        this.attackRange = attackRange;
        this.goldCost = goldCost;
        this.foodCost = foodCost;
        this.unitSpace = unitSpace;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public boolean isAlive() {
        return hitPoints > 0;
    }

    @Override
    public void receiveDamage(int damage) {
        hitPoints -= damage;
    }
}
