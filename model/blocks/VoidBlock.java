package model.blocks;

import java.awt.*;

public class VoidBlock extends Block {

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
    public Color getColor() {
        return Color.DARK_GRAY;
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
