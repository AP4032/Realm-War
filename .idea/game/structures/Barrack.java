package game.structures;

public class Barrack extends Structure {

    private int unitSpace;
    private int buildingCost;
    private int levelUpCost;

    public Barrack(int initialBuildingCost) {
        super(50, 5, 3);
        this.unitSpace = 5;
        this.buildingCost = initialBuildingCost;
        this.levelUpCost = 5;
    }

    public int getUnitSpace() {
        return unitSpace;
    }

    public int getBuildingCost() {
        return buildingCost;
    }

    public int getLevelUpCost() {
        return levelUpCost;
    }

    @Override
    public void upgrade() {
        if (level < maxLevel) {
            super.upgrade();
            unitSpace += 2;
            levelUpCost += 5;
        }
    }
}
