package blocks;

public class EmptyBlock extends Blocks{

    public EmptyBlock(int row, int col) {
        super(row,col);
    }

    @Override
    public boolean isBuildable() {
        return owned;
    }

    @Override
    public String getType() {
        return "Empty Block";
    }

    @Override
    public int getGoldGeneration() {
        return owned ? 3 : 0;
    }

    @Override
    public int getFoodGeneration() {
        return owned ? 10 : 0;
    }
}
