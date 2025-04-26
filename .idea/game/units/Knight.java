package game.units;

public class Knight extends Unit {

    public Knight() {
        super(80, 25, 3, 1, 12, 5, 4);
    }

    @Override
    public int getMovementRange() {
        return movementRange;
    }
}
