package Block;

public class EmptyBlock extends Block {
    public EmptyBlock(int x, int y) {
        super(x, y);
    }
    @Override
    public boolean canBuildStructure() {
   return  false;
    }
    @Override
    public String produceResources() {
        return null;
    }
}
