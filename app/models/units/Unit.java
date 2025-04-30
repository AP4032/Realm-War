package models.units;

import models.Position;

public abstract class Unit {
    private int hitPoints;
    private int maxHitPoints;
    private int movementRange;
    private int attackPower;
    private int attackRange;
    private int paymentCost;
    private int rationCost;
    private int unitSpace;
    private Position position;
    private int kingdomId;

    public Unit(int hitPoints, int movementRange, int attackPower, int attackRange, 
                int paymentCost, int rationCost, int unitSpace, Position position, int kingdomId) {
        this.hitPoints = hitPoints;
        this.maxHitPoints = hitPoints;
        this.movementRange = movementRange;
        this.attackPower = attackPower;
        this.attackRange = attackRange;
        this.paymentCost = paymentCost;
        this.rationCost = rationCost;
        this.unitSpace = unitSpace;
        this.position = position;
        this.kingdomId = kingdomId;
    }

    public abstract boolean canMerge(Unit other);
    public abstract Unit merge(Unit other);
    
    // Getters and setters
    public int getHitPoints() { return hitPoints; }
    public void setHitPoints(int hitPoints) { this.hitPoints = hitPoints; }
    public int getMaxHitPoints() { return maxHitPoints; }
    public int getMovementRange() { return movementRange; }
    public int getAttackPower() { return attackPower; }
    public int getAttackRange() { return attackRange; }
    public int getPaymentCost() { return paymentCost; }
    public int getRationCost() { return rationCost; }
    public int getUnitSpace() { return unitSpace; }
    public Position getPosition() { return position; }
    public void setPosition(Position position) { this.position = position; }
    public int getKingdomId() { return kingdomId; }
}