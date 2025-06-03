package Unit;

import Game.Player;

public class Spearman extends Unit implements UnitProperties {
    public Spearman(int hitPoints, int movementBlock, int attackPower, int attackRange, int paymentGold, int rationFood,int unitSpace , Player plsyerUnits) {
super(hitPoints, movementBlock, attackPower, attackRange, paymentGold,rationFood, unitSpace, plsyerUnits);
    }

    @Override
    public Unit merge(Unit other) {
        if( other instanceof Spearman ) {
            return  new Swordman(getHitPoints(),getMovementBlockRange(),getAttackPower(),getAttackRange(),getPaymentGold(),getRationFood(),getUnitSpace(),getPlsyerUnits());
        }
        return null;
    }
    public boolean isAlive() {
        return getHitPoints() > 0;
    }

    @Override
    public boolean canAttack(Unit target) {
        return true;
    }

    @Override
    public boolean canMerge(Unit other) {
        return other instanceof Spearman;
    }

    @Override
    public void dealDamage(int damage) {
        setHitPoints(getHitPoints() - damage);
    }
    public void heal( int damage ) {
        setHitPoints(getHitPoints() + damage);
    }
}
