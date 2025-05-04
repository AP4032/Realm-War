package Block;

public class ForestBlock extends Block {
    public ForestBlock(int x, int y) {
        super(x, y);
    }

    @Override
    public String produceResources() {
        return "";
    }

    @Override
    public boolean canBuildStructure() {
        return false;
    }
}
