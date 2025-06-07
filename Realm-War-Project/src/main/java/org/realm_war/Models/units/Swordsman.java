package org.realm_war.Models.units;

import org.realm_war.Models.Position;

public class Swordsman extends Unit{

    public Swordsman(Position position, int realm) {
        super(98, 2, 24, 1, 11, 4, 1, position, realm);
    }

    @Override
    public boolean canMerge(Unit otherUnit) {
        return otherUnit instanceof Swordsman && otherUnit.getRealmID() == getRealmID();
    }

    @Override
    public Unit merge(Unit otherUnit) {
        if(!canMerge(otherUnit)) {
            throw new IllegalArgumentException("Unable to Merge Units!");
        }else return new Knight(this.getPosition(), this.getRealmID());
    }
}
