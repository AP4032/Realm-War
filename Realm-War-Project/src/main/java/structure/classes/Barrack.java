package structure.classes;

import structure.interfaces.UnitProductions;

public class Barrack extends Structure implements UnitProductions {
    private int unitSpace;

    public Barrack(int buildCost) {
        this.level = 1;
        this.maxLevel = 3;
        this.durability = 50;
        this.maintenanceCost = 5;
        this.buildingCost = buildCost;
        this.levelUpCost = 5;
        this.unitSpace = 5;
    }

    @Override
    public void levelUp() {
        if (level < maxLevel) {
            level++;
            durability += 10;
            levelUpCost += 5;
            //We are suppose that units increases by level up
            unitSpace += 5;
        } else {
            //Probably will replace with error handling (e.g. try/catch )
            System.out.println("Barrack is already at max level.");
        }
    }

    @Override
    public int getUnitSpace() {
        return unitSpace;
    }
}
