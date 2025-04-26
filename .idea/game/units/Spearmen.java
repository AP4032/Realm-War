package game.units;

public class Spearman extends Unit {

    public Spearman() {
        super(35, 10, 2, 1, 5, 2, 2);
    }

    @Override
    public int getMovementRange() {
        return movementRange;
    }
}
