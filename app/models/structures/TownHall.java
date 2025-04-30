package models.structures;

import models.blocks.Block;
import models.Position;

public class TownHall extends Structure {
    private static final int GOLD_PRODUCTION = 5;
    private static final int FOOD_PRODUCTION = 5;
    private static final int UNIT_SPACE = 5;

    public TownHall(Position position, Block baseBlock, int kingdomId) {
        super(1, 50, 0, position, baseBlock, kingdomId);
    }

    @Override
    public boolean canUpgrade() {
        return false; // TownHall cannot be upgraded
    }

    @Override
    public void upgrade() {
        throw new UnsupportedOperationException("TownHall cannot be upgraded");
    }

    @Override
    public void performTurnAction() {
        // TownHall generates resources each turn
        // This will be handled by the Kingdom class
    }
    
    public int getGoldProduction() {
        return GOLD_PRODUCTION;
    }
    
    public int getFoodProduction() {
        return FOOD_PRODUCTION;
    }
    
    public int getUnitSpace() {
        return UNIT_SPACE;
    }
}