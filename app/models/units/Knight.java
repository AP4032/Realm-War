package models.units;

import models.Position;

public class Knight extends Unit {
    public Knight(Position position, int kingdomId) {
        super(120, 3, 25, 1, 12, 6, 4, position, kingdomId);
    }

    @Override
    public boolean canMerge(Unit other) {
        return false; // Knight is the highest rank, cannot merge further
    }

    @Override
    public Unit merge(Unit other) {
        throw new UnsupportedOperationException("Knights cannot be merged further");
    }
}