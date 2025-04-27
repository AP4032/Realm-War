package structure.classes;

import structure.interfaces.FoodProduction;
import structure.interfaces.GoldProduction;
import structure.interfaces.UnitProductions;

public class TownHall extends Structure implements GoldProduction, FoodProduction, UnitProductions {
    private int goldProduction;
    private int foodProduction;
    private int unitSpace;

    public TownHall(){
        this.maxLevel=1;
        this.level=1;
        this.maintenanceCost = 0;
        this.durability = 50;
        this.goldProduction = 5;
        this.foodProduction = 5;
        this.unitSpace = 5;
    }

    @Override
    public int produceFoodPerTurn() {
        return foodProduction;
    }

    @Override
    public int produceGoldPerTurn() {
        return goldProduction;
    }

    @Override
    public int getUnitSpace() {
        return unitSpace;
    }
}
