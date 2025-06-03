package Kingdom.Block;

import Game.ResourceYield;
import Game.ResourceType;

public class EmptyBlock extends Block {
    private static final int GOLD_YIELD_AMOUNT = 1; // مقدار طلای تولیدی

    public EmptyBlock(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean canBuildStructure() {
        return true;
    }

    @Override
    public ResourceYield produceResources() {
        // فقط در صورتی که بلوک مالک داشته باشد، طلا تولید می‌کند
        if (getBlockOwner() != null) {
            return new ResourceYield(ResourceType.GOLD, GOLD_YIELD_AMOUNT);
        } else {
            // اگر مالکی نداشته باشد، منبعی تولید نمی‌کند
            return new ResourceYield(ResourceType.NONE, 0);
        }
    }
}