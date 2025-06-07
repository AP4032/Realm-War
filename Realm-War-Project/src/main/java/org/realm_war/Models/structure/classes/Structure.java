package org.realm_war.Models.structure.classes;


import org.realm_war.Models.Position;
import org.realm_war.Models.Realm;
import org.realm_war.Models.blocks.Block;

public abstract class Structure {
    private int level;
    private final int maxLevel;
    private int durability;
    protected int maintenanceCost;
    private Position position;
    private Block baseBlock;
    private int kingdomId;

    public Structure(int maxLevel, int initialDurability, int maintenanceCost, org.realm_war.Models.Position position2, Block baseBlock, int kingdomId) {
        this.level = 1;
        this.maxLevel = maxLevel;
        this.durability = initialDurability;
        this.maintenanceCost = maintenanceCost;
        this.position =  position2;
        this.baseBlock = baseBlock;
        this.kingdomId = kingdomId;
    }

    public abstract boolean canLevelUp();
    public abstract void levelUp();
    public abstract void performTurnAction(Realm realm);
    
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
    public boolean isDestroyed(){
        return durability <= 0;
    }
}