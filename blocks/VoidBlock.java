package blocks;

public class VoidBlock extends Blocks{

    public VoidBlock(int row, int col) {
        super(row,col);
    }

    @Override
    public boolean isBuildable() {
        return false;
    }

    @Override
    public String getType() {
        return "Void Block";
    }

    @Override
    public int getGoldGeneration() {
        return 0;
    }

    @Override
    public int getFoodGeneration() {
        return 0;
    }

}
