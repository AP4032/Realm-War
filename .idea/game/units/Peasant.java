package game.units;

public class Peasant extends Unit {

    public Peasant() {
        super(20, 5, 2, 1, 2, 1, 1);
    }

    @Override
    public int getMovementRange() {
        return movementRange;
    }
}
