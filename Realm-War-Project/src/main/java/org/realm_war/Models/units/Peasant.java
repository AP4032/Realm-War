package org.realm_war.Models.units;

import org.realm_war.Models.Position;

public class Peasant extends Unit{
    public Peasant(Position position, int realmID) {
        super(53, 1, 12, 1, 5, 1, 1, position, realmID);
    }

    @Override
    public boolean canMerge(Unit otherUnit) {
        return otherUnit instanceof Peasant && otherUnit.getRealmID() == getRealmID();
    }

    @Override
    public Unit merge(Unit otherUnit) {
        if (!canMerge(otherUnit)) {
            throw new IllegalArgumentException("Unable to Merge Units!");
        }else return new Spearman(this.getPosition(), this.getRealmID());
    }
}