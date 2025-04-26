package game.structures;

public class Farm extends Structure {

    private int foodProduction;
    private int buildingCost;
    private int levelUpCost;

    public Farm(int initialBuildingCost) {
        super(50, 5, 3);
        this.foodProduction = 5;
        this.buildingCost = initialBuildingCost;
        this.levelUpCost = 5;
    }

    public int getFoodProduction() {
        return foodProduction;
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
            foodProduction += 3;
            levelUpCost += 5;
        }
    }
}
