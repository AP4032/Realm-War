package game.units;

public class Swordman extends Unit {

    public Swordman() {
        super(50, 15, 2, 1, 8, 3, 3);
    }

    @Override
    public int getMovementRange() {
        return movementRange;
    }
}
