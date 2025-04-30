package models.structures;

import models.blocks.Block;
import models.Position;

public class Tower extends Structure {
    private static final int[] ATTACK_POWER_BY_LEVEL = {10, 15, 20};
    private static final int[] BUILDING_COST_BY_LEVEL = {10, 20, 30};
    private static final int[] DURABILITY_BY_LEVEL = {100, 150, 200};
    
    private int attackPower;

    public Tower(Position position, Block baseBlock, int kingdomId) {
        super(3, DURABILITY_BY_LEVEL[0], 10, position, baseBlock, kingdomId);
        this.attackPower = ATTACK_POWER_BY_LEVEL[0];
    }

    @Override
    public boolean canUpgrade() {
        return getLevel() < getMaxLevel();
    }

    @Override
    public void upgrade() {
        if (!canUpgrade()) {
            throw new IllegalStateException("Tower is already at max level");
        }
        
        setLevel(getLevel() + 1);
        setDurability(DURABILITY_BY_LEVEL[getLevel() - 1]);
        this.attackPower = ATTACK_POWER_BY_LEVEL[getLevel() - 1];
    }

    @Override
    public void performTurnAction() {
        // Logic for attacking enemies
    }
    
    public int getAttackPower() {
        return attackPower;
    }
    
    public int getUpgradeCost() {
        return BUILDING_COST_BY_LEVEL[getLevel() - 1];
    }
    
    public static int getBuildingCost(int towersCount) {
        return 10 + (towersCount * 10); // Each new tower costs 10 more than the previous
    }
}
