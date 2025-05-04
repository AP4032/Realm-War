package Block;

public class VoidBlock extends Block {
    public VoidBlock(int x, int y) {
        super(x, y);
    }
    @Override
    public String produceResources() {
        return null;
    }

    @Override
    public boolean canBuildStructure() {
        return false;
    }
}
