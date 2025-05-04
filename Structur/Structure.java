package Structur;
import Game.Player;

public abstract class  Structure {
    private int durability;
    private Player Owner;
    private int level;
    private int maintenanceCost;
    private int buildingCost;
    private int levelUpCost;



    public Structure(int durability, Player player, int level,
                     int maintenanceCost, int buildingCost, int levelUpCost) {
        this.durability = durability;
        this.Owner = player;
        this.level = level;
        this.maintenanceCost = maintenanceCost;
        this.buildingCost = buildingCost;
        this.levelUpCost = levelUpCost;
    }


    public int getDurability() {
        return durability;
    }

    public Player getOwner() {
        return Owner;
    }

    public int getLevel() {
        return level;
    }
    public void setOwner(Player player) {
        this.Owner = player;
    }

    public int getMaintenanceCost() {
        return maintenanceCost;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public void setLevelUpCost(int levelUpCost) {
        this.levelUpCost = levelUpCost;
    }

    public void setBuildingCost(int buildingCost) {
        this.buildingCost = buildingCost;
    }

    public void setMaintenanceCost(int maintenanceCost) {
        this.maintenanceCost = maintenanceCost;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getBuildingCost() {
        return buildingCost;
    }

    public int getLevelUpCost() {
        return levelUpCost;
    }
    public abstract void upgradeLevel();
} //
