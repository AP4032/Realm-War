package model.units;
import model.structures.*;

public abstract class Units {
    private int hitPoint;
    private int movementRange;
    private int attackPower;
    private int attackRange;
    private int payment;
    private int ration;
    private int unitSpace;

    public Units(int hitPoint,int movementRange,int attackPower,int attackRange,int payment,int ration,int unitSpace){
        this.hitPoint = hitPoint;
        this.movementRange = movementRange;
        this.attackPower = attackPower;
        this.attackRange = attackRange;
        this.payment = payment;
        this.ration = ration;
        this.unitSpace = unitSpace;
    }

    public abstract void attack(Units target);

    public abstract void structAttack(Structures target);

    //public abstract Units deleteUnits(Units unit);
    //public abstract Structures deleteStruct(Structures structure);

    public int getHitPoint() {
        return hitPoint;
    }

    public void setHitPoint(int hitPoint) {
        this.hitPoint = hitPoint;
    }

    public int getMovementRange() {
        return movementRange;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getAttackRange() {
        return attackRange;
    }

    public int getPayment() {
        return payment;
    }

    public int getRation() {
        return ration;
    }

    public int getUnitSpace() {
        return unitSpace;
    }
}
