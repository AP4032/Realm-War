package game.blocks;

public abstract class Block {
    protected boolean isOwned;

    public Block() {
        this.isOwned = false;
    }

    public abstract String getType();

    public boolean isOwned() {
        return isOwned;
    }

    public void setOwned(boolean owned) {
        this.isOwned = owned;
    }
}
