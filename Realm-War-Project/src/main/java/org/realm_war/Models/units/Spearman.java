package org.realm_war.Models.units;

import org.realm_war.Models.Position;

public class Spearman extends Unit {
    public Spearman(Position position, int realm) {
        super(85, 1, 18, 2, 8, 2, 1, position, realm);
    }

    @Override
    public boolean canMerge(Unit otherUnit) {
        return otherUnit instanceof Spearman && otherUnit.getRealmID() == getRealmID();
    }

    @Override
    public Unit merge(Unit otherUnit) {
        if (!canMerge(otherUnit)) {
            throw new IllegalArgumentException("Unable to Merge Units!");
        }else return new Swordsman(this.getPosition(), this.getRealmID());
    }
}
