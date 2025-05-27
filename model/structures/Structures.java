package model.structures;

public abstract class Structures {
    private int durability;
    private int maintenanceCost;
    private int level;
    private int maxLevel;
    private int levelUpCost;
    private int buildingCost;

    public Structures(int durability, int maintenanceCost, int level, int maxLevel, int levelUpCost, int buildingCost) {
        this.durability = durability;
        this.maintenanceCost = maintenanceCost;
        this.level = level;
        this.maxLevel = maxLevel;
        this.levelUpCost = levelUpCost;
        this.buildingCost = buildingCost;
    }

    public void levelUp() {
        if (level <= maxLevel) {
            this.level++;
            durability += 10;
        }
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }
}
