package org.realm_war.Models.units;

import org.realm_war.Models.Position;

public class Knight extends Unit {
    public Knight(Position position, int realmID) {
        super(125, 3, 32, 1, 15, 5, 1, position, realmID);
    }

    @Override
    public boolean canMerge(Unit otherUnit) {
        return false;
    }

    @Override
    public Unit merge(Unit otherUnit) {
        throw new UnsupportedOperationException("Knights have the highest ranks, they can't be merged!");
    }
}
