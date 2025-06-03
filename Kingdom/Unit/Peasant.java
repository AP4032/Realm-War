package Unit;

import Game.Player;
import Structur.StructureProperties;

public class Peasant extends Unit implements UnitProperties {
    public Peasant(int hitPoints, int movementBlock, int attackPower, int attackRange, int paymentGold, int rationFood, int unitSpace, Player plsyerUnits) {
        super(hitPoints, movementBlock,attackPower,attackRange, paymentGold, rationFood, unitSpace, plsyerUnits);
    }

    @Override
    public boolean canAttack(Unit target) {
        return true;
    }

    @Override
    public boolean canMerge(Unit other) {
        return other instanceof Peasant;
    }

    @Override
    public void dealDamage(int damage) {
        setHitPoints(getHitPoints() - damage);
    }
    public void heal(int damage) {
        setHitPoints(getHitPoints() + damage);
    }
    public boolean isAlive() {
        return getHitPoints() > 0;
    }

    @Override
    public Unit merge(Unit other) {
        if( other instanceof Peasant ) {
            return new Spearman (getHitPoints(),getMovementBlockRange(),getAttackPower(),getAttackRange(),getPaymentGold(),getRationFood(),getUnitSpace(),getPlsyerUnits());
        }
        return null;
    }
}
