package main.java.com.realmwar.game.entities.blocks;

import main.java.com.realmwar.game.entities.units.Unit;
import main.java.com.realmwar.game.util.GameLogger;

public class VoidBlock extends Block {
    public VoidBlock(int row, int col) {
        super(row, col);
    }

    @Override
    public boolean isAbsorbable() {
        return false;
    }

    @Override
    public boolean allowsBuilding() {
        return false;
    }

    @Override
    public void onUnitEnter(Unit unit) {
        GameLogger.logWarning(unit.getClass().getSimpleName() + " attempted to enter " +
                "VoidBlock at (" + row + "," + col + "). " +
                "This should be prevented by movement logic.");
    }
}