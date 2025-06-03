package Unit;

import Game.Player;
import Structur.StructureProperties;

public class Knight extends Unit implements UnitProperties {
    public Knight(int hitPoints, int movementBlock, int attackPower, int attackRange, int paymentGold, int rationFood, int unitSpace, Player plsyerUnits) {
        super(hitPoints,movementBlock,attackPower, attackRange, paymentGold, rationFood, unitSpace, plsyerUnits);

    }

    @Override
    public Unit  merge(Unit  other) {
        return other;

    }

    @Override
    public boolean isAlive() {

        return getHitPoints() > 0;
    }

    @Override
    public boolean canAttack(Unit target) {
        return true;
    }

    @Override
    public boolean canMerge(Unit  other) {
        return other instanceof Knight;
    }

    @Override
    public void dealDamage(int damage) {
        setHitPoints(getHitPoints() - damage);
    }
    public void heal( int damage ) {
        setHitPoints(getHitPoints() + damage);
    }
}
