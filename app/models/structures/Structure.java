package models.structures;

import models.Position;
import models.blocks.Block;

public abstract class Structure {
    private int level;
    private final int maxLevel;
    private int durability;
    private int maintenanceCost;
    private Position position;
    private Block baseBlock;
    private int kingdomId;

    public Structure(int maxLevel, int initialDurability, int maintenanceCost, Position position, Block baseBlock, int kingdomId) {
        this.level = 1;
        this.maxLevel = maxLevel;
        this.durability = initialDurability;
        this.maintenanceCost = maintenanceCost;
        this.position = position;
        this.baseBlock = baseBlock;
        this.kingdomId = kingdomId;
    }

    public abstract boolean canUpgrade();
    public abstract void upgrade();
    public abstract void performTurnAction();
    
    // Getters and setters
    public int getLevel() { return level; }
    protected void setLevel(int level) { this.level = level; }
    public int getMaxLevel() { return maxLevel; }
    public int getDurability() { return durability; }
    public void setDurability(int durability) { this.durability = durability; }
    public int getMaintenanceCost() { return maintenanceCost; }
    public Position getPosition() { return position; }
    public Block getBaseBlock() { return baseBlock; }
    public int getKingdomId() { return kingdomId; }
}
