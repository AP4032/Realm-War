package game.structures;

public class TownHall extends Structure {

    private final int goldPerTurn;
    private final int foodPerTurn;
    private final int unitSpace;

    public TownHall() {
        super(50, 0, 1);
        this.goldPerTurn = 5;
        this.foodPerTurn = 5;
        this.unitSpace = 5;
    }

    public int getGoldPerTurn() {
        return goldPerTurn;
    }

    public int getFoodPerTurn() {
        return foodPerTurn;
    }

    public int getUnitSpace() {
        return unitSpace;
    }

    @Override
    public void upgrade() {
        System.out.println("Town Hall cannot be upgraded.");
    }
}
