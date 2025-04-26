package game.blocks;

public class EmptyBlock extends Block {

    public EmptyBlock() {
        super();
    }

    @Override
    public String getType() {
        return "Empty";
    }
}
