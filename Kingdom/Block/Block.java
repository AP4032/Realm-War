package Kingdom.Block;

import Game.Player;
import Game.ResourceYield;

public abstract class Block {
    private int x;
    private int y;
    private Player blockOwner; // تغییر نام از BlockOwner به blockOwner برای رعایت قرارداد نامگذاری جاوا

    public Block(int x, int y) {
        this.x = x;
        this.y = y;
        this.blockOwner = null; // مقداردهی اولیه مالک بلوک
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Player getBlockOwner() {
        return blockOwner;
    }

    public void setBlockOwner(Player blockOwner) {
        this.blockOwner = blockOwner;
    }

    public abstract boolean canBuildStructure();
    public abstract ResourceYield produceResources(); // تغییر نوع خروجی
}