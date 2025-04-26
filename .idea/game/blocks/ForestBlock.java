package game.blocks;

public class ForestBlock extends Block {

    private boolean forestPresent;

    public ForestBlock() {
        super();
        this.forestPresent = true;
    }

    @Override
    public String getType() {
        return "Forest";
    }

    public boolean hasForest() {
        return forestPresent;
    }

    public void removeForest() {
        this.forestPresent = false;
    }
}
