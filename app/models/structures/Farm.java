package models.structures;

import models.blocks.Block;
import models.Position;

public class Farm extends Structure {
    private static final int[] FOOD_PRODUCTION_BY_LEVEL = {5, 8, 12};
    private static final int[] BUILDING_COST_BY_LEVEL = {5, 10, 15};
    private static final int[] DURABILITY_BY_LEVEL = {50, 75, 100};
    
    private int foodProduction;

    public Farm(Position position, Block baseBlock, int kingdomId) {
        super(3, DURABILITY_BY_LEVEL[0], 5, position, baseBlock, kingdomId);
        this.foodProduction = FOOD_PRODUCTION_BY_LEVEL[0];
    }

    @Override
    public boolean canUpgrade() {
        return getLevel() < getMaxLevel();
    }

    @Override
    public void upgrade() {
        if (!canUpgrade()) {
            throw new IllegalStateException("Farm is already at max level");
        }
        
        setLevel(getLevel() + 1);
        setDurability(DURABILITY_BY_LEVEL[getLevel() - 1]);
        this.foodProduction = FOOD_PRODUCTION_BY_LEVEL[getLevel() - 1];
    }

    @Override
    public void performTurnAction() {
        // Food production is handled by the Kingdom class
    }
    
    public int getFoodProduction() {
        return foodProduction;
    }
    
    public int getUpgradeCost() {
        return BUILDING_COST_BY_LEVEL[getLevel() - 1];
    }
    
    public static int getBuildingCost(int farmsCount) {
        return 5 + (farmsCount * 5); // Each new farm costs 5 more than the previous
    }
}