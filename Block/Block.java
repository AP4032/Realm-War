package Block;
import Game.Player;

public abstract class Block {
    private int x;
    private int y;
   private Player BlockOwner;
    public Block(int x, int y) {
        this.x = x;
        this.y = y;

    }//
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public Player getBlockOwner() {
        return BlockOwner;
    }
    public void setBlockOwner(Player BlockOwner) {
        this.BlockOwner = BlockOwner;
    }
    public abstract boolean canBuildStructure ();
    public abstract String produceResources();


}
