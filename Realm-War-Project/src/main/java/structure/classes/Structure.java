package structure.classes;

public class Structure {
    protected int durability;
    protected int level;
    protected int maxLevel;
    protected int maintenanceCost;
    protected int buildingCost;
    protected int levelUpCost;

    //================================
    //GETTERS
    //================================
    public int getDurability() {
        return durability;
    }
    public int getLevel() {
        return level;
    }
    public int getMaxLevel() {
        return maxLevel;
    }
    public int getMaintenanceCost() {
        return maintenanceCost;
    }
    public int getBuildingCost() {
        return buildingCost;
    }
    public void levelUp() {
        if (level < maxLevel) {
            level += 1;
            durability += 10;
            levelUpCost += 5;
        }
    }
}
