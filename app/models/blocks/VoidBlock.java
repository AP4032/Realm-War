package models.blocks;

import models.Position;

public class VoidBlock extends Block {
    public VoidBlock(Position position) {
        super(position);
    }

    @Override
    public boolean canBuildStructure() {
        return false;
    }

    @Override
    public int getResourceYield(String resourceType) {
        return 0;
    }
}