package Unit;

import Game.Player;

public  abstract class Unit {

    private int hitPoints;
    private int movementBlockRange;
    private int attackPower;
    private int attackRange ;
    private int paymentGold;
    private int rationFood;
    private int unitSpace ;
    private Player plsyerUnits;
    public Unit( int hitPoints,int movementBlock,int attackPower,int attackRange,int paymentGold,int rationFood,int unitSpace,Player plsyerUnits ) {
        this.hitPoints = hitPoints;
        this.movementBlockRange = movementBlock;
        this.attackPower = attackPower;
        this.attackRange = attackRange;
        this.paymentGold = paymentGold;
        this.rationFood = rationFood;
        this.unitSpace = unitSpace;
        this.plsyerUnits = plsyerUnits;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getMovementBlockRange() {
        return movementBlockRange;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getAttackRange() {
        return attackRange;
    }

    public int getPaymentGold() {
        return paymentGold;
    }

    public int getRationFood() {
        return rationFood;
    }

    public int getUnitSpace() {
        return unitSpace;
    }

    public Player getPlsyerUnits() {
        return plsyerUnits;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public void setMovementBlockRange(int movementBlockRange) {
        this.movementBlockRange = movementBlockRange;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public void setAttackRange(int attackRange) {
        this.attackRange = attackRange;
    }

    public void setPaymentGold(int paymentGold) {
        this.paymentGold = paymentGold;
    }

    public void setRationFood(int rationFood) {
        this.rationFood = rationFood;
    }

    public void setUnitSpace(int unitSpace) {
        this.unitSpace = unitSpace;
    }

    public void setPlsyerUnits(Player plsyerUnits) {
        this.plsyerUnits = plsyerUnits;
    }
}
