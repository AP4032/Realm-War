package game.structures;

public class Market extends Structure {

    private int goldProduction;
    private int buildingCost;
    private int levelUpCost;

    public Market(int initialBuildingCost) {
        super(50, 5, 3);
        this.goldProduction = 5;
        this.buildingCost = initialBuildingCost;
        this.levelUpCost = 5;
    }

    public int getGoldProduction() {
        return goldProduction;
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
            goldProduction += 3;
            levelUpCost += 5;
        }
    }
}
