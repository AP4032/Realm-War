package model.structures;



abstract class Structures {
    int DURABILITY;
    int MAINTENANCE_COST;
    int LEVEL;
    int MAX_LEVEL;
    int LEVEL_UP_COST;
    int BUILDING_COST;

    public Structures(int durability, int maintenanceCost, int level, int maxLevel, int levelUpCost, int buildingCost) {
        this.DURABILITY = durability;
        this.MAINTENANCE_COST = maintenanceCost;
        this.LEVEL = level;
        this.MAX_LEVEL = maxLevel;
        this.LEVEL_UP_COST = levelUpCost;
        this.BUILDING_COST = buildingCost;
    }

    public void levelUp() {
        if (LEVEL <= MAX_LEVEL) {
            this.LEVEL++;
            DURABILITY += 10;
        }
    }

}
