package game.structures;

public class Tower extends Structure {

    private int blockingLevel;
    private int buildingCost;
    private int levelUpCost;

    public Tower(int initialBuildingCost) {
        super(50, 5, 3);
        this.blockingLevel = 1;
        this.buildingCost = initialBuildingCost;
        this.levelUpCost = 5;
    }

    public int getBlockingLevel() {
        return blockingLevel;
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
            blockingLevel++;
            levelUpCost += 5;
        }
    }
}
