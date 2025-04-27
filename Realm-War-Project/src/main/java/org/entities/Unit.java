package org.entities;

public abstract class Unit {
    private double HIT_POINT;
    private double MOVEMENT_RANGE;
    private double ATTACK_POWER;
    private double ATTACK_RANGE;
    private double PAYMENT;
    private double RATION;
    private int UNIT_SPACE;

    public double getHitPoint() {
        return HIT_POINT;
    }

    public double getMovementRange() {
        return MOVEMENT_RANGE;
    }

    public double getAttackPower() {
        return ATTACK_POWER;
    }

    public double getAttackRange() {
        return ATTACK_RANGE;
    }

    public double getPayment() {
        return PAYMENT;
    }

    public double getRation() {
        return RATION;
    }

    public int getUnitSpace() {
        return UNIT_SPACE;
    }
}