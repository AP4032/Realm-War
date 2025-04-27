package org.entities;

public class Knight extends Unit implements UnitInterface {
    private final double HIT_POINT = 1;
    private final double MOVEMENT_RANGE = 2;
    private final double ATTACK_POWER = 3;
    private final double ATTACK_RANGE = 4;
    private final double PAYMENT = 5;
    private final double RATION = 6;
    private final int UNIT_SPACE = 7;
    private int level;

    public void consumeFood() {}

    public void consumeGold(){}

    public void fillSpace(){}

    public void move() {}

    public void defend() {}

    public void attack() {}

    public void getHit(){}
}
