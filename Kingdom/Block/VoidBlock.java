package Kingdom.Block;

import Game.ResourceYield;
import Game.ResourceType;
import Kingdom.Block.Block;

public class VoidBlock extends Block {
    public VoidBlock(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean canBuildStructure() {
        return false;
    }

    @Override
    public ResourceYield produceResources() {
        return new ResourceYield(ResourceType.NONE, 0);
    }
}