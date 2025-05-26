package model.blocks;

public class ForestBlock extends Blocks{

    private boolean forestCut = false;

    public ForestBlock(int row, int col) {
        super(row,col);
    }

    public void cutForest() {
        this.forestCut = true;
    }

    public boolean hasForest() {
        return !forestCut;
    }

    @Override
    public boolean isBuildable() {
        return owned && forestCut;
    }

    @Override
    public String getType() {
        return "Forest Block";
    }

    @Override
    public int getGoldGeneration() {
        return 0;
    }

    @Override
    public int getFoodGeneration() {
        return (owned && forestCut) ? 20 : 0;
    }
}
