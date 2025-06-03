package Kingdom.Block;

import Game.Player;
import Game.ResourceYield;
import Game.ResourceType;

public class ForestBlock extends Block {
    private static final int FOOD_YIELD_AMOUNT = 1;
    private boolean hasForest; // وضعیتی برای اینکه آیا هنوز جنگل وجود دارد یا خیر

    public ForestBlock(int x, int y) {
        super(x, y);
        this.hasForest = true; // در ابتدا جنگل وجود دارد
    }

    @Override
    public boolean canBuildStructure() {
        return false;
    }

    @Override
    public ResourceYield produceResources() {
        return null;
    }

    public boolean hasForest() {
        return hasForest;
    }

    /**
     * این متد زمانی فراخوانی می‌شود که سازه‌ای روی بلوک جنگلی ساخته شود
     * و در نتیجه جنگل از بین برود.
     */
    public void removeForest() {
        this.hasForest = false;
    }
}
