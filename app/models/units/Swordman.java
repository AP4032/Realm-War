package models.units;

import models.Position;

public class Swordman extends Unit {
    public Swordman(Position position, int kingdomId) {
        super(80, 2, 15, 1, 8, 4, 3, position, kingdomId);
    }

    @Override
    public boolean canMerge(Unit other) {
        return other instanceof Swordman && this.getKingdomId() == other.getKingdomId();
    }

    @Override
    public Unit merge(Unit other) {
        if (!canMerge(other)) {
            throw new IllegalArgumentException("Cannot merge these units");
        }
        return new Knight(this.getPosition(), this.getKingdomId());
    }
}