package models.blocks;

import models.Position;

public class EmptyBlock extends Block {
    public EmptyBlock(Position position) {
        super(position);
    }

    @Override
    public boolean canBuildStructure() {
        return isAbsorbed();
    }

    @Override
    public int getResourceYield(String resourceType) {
        if (!isAbsorbed()) return 0;
        
        int resourceYield;
        switch (resourceType) {
            case "GOLD":
                resourceYield = 1;
                break;
            case "FOOD":
                resourceYield = 0;
                break;
            default:
                resourceYield = 0;
                break;
        }
        return resourceYield;
    }
}