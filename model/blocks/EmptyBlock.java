package model.blocks;

import java.awt.*;

public class EmptyBlock extends Block {

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
    public Color getColor() {
        return Color.LIGHT_GRAY;
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
