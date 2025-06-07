package org.realm_war.Models.units;

import org.realm_war.Models.Player;
import org.realm_war.Models.Position;
import org.realm_war.Models.blocks.Block;

public abstract class Unit {
    private int HIT_POINT;
    private int MOVEMENT_RANGE;
    private int ATTACK_POWER;
    private int ATTACK_RANGE;
    private int PAYMENT;
    private int RATION;
    private int UNIT_SPACE;
    private Position position;
    private int realmID;
    private Player owner;

    public Unit(int HIT_POINT, int MOVEMENT_RANGE, int ATTACK_POWER, int ATTACK_RANGE, int PAYMENT, int RATION, int UNIT_SPACE, Position position, int realmID) {
        this.HIT_POINT = HIT_POINT;
        this.MOVEMENT_RANGE = MOVEMENT_RANGE;
        this.ATTACK_POWER = ATTACK_POWER;
        this.ATTACK_RANGE = ATTACK_RANGE;
        this.PAYMENT = PAYMENT;
        this.RATION = RATION;
        this.UNIT_SPACE = UNIT_SPACE;
        this.position = position;
        this.realmID = realmID;
    }

    public boolean canMoveTo(Block block) {
        return position.distanceTo(block.getPosition()) <= MOVEMENT_RANGE &&
                block.isWalkable() && block.getUnit() == null;
    }

    public boolean canAttack(Unit target) {
        return position.distanceTo(target.getPosition()) <= ATTACK_RANGE;
    }

    public void takeDamage(int damage) {
        HIT_POINT = Math.max(0, HIT_POINT-damage);
    }

    public int getHitPoint() {
        return HIT_POINT;
    }

    public int getMovementRange() {
        return MOVEMENT_RANGE;
    }

    public int getAttackPower() {
        return ATTACK_POWER;
    }

    public int getAttackRange() {
        return ATTACK_RANGE;
    }

    public int getPayment() {
        return PAYMENT;
    }

    public int getRation() {
        return RATION;
    }

    public int getUnitSpace() {
        return UNIT_SPACE;
    }

    public int getRealmID() {
        return realmID;
    }

    public Position getPosition() {
        return position;
    }

    public int getX() {
        return position.getX();
    }

    public int getY() {
        return position.getY();
    }

    public void setX(int x) {
        position.setX(x);
    }

    public void setY(int y) {
        position.setY(y);
    }

    public Player getOwner() {
        return owner;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public abstract boolean canMerge(Unit otherUnit);

    public abstract Unit merge(Unit otherUnit);

    public boolean canAttackUnit(Unit unit){
        return HIT_POINT > unit.getHitPoint();
    };
}