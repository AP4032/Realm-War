package models.structures;

import models.Position;
import models.blocks.Block;

public class Market extends Structure {
    private int goldProduction;

    public Market(int goldProduction, int maxLevel, int initialDurability, int maintenanceCost, Position position, Block baseBlock, int kingdomId) {
        super(maxLevel, initialDurability, maintenanceCost, position, baseBlock, kingdomId);
        this.goldProduction = goldProduction;
    }

    public int getGoldProduction() {
        return goldProduction;
    }

    @Override
    public int getMaintenanceCost() {
        // Implement maintenance cost logic
        return 0;
    }

    @Override
    public void performTurnAction() {
        // Implement turn action logic
    }

    @Override
    public boolean canUpgrade() {
        // Implement upgrade check logic
        return false;
    }

    @Override
    public void upgrade() {
        // Implement upgrade logic
    }
}
