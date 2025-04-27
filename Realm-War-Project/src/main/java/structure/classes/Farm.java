package structure.classes;

import structure.interfaces.FoodProduction;

public class Farm extends Structure implements FoodProduction {
    private int foodAmount;

    public Farm (int buildCost){
        this.level = 1;
        this.maxLevel = 3;
        this.durability = 50;
        this.maintenanceCost = 5;
        this.buildingCost = buildCost;
        this.levelUpCost = 5;
        this.foodAmount = 5;
    }
    @Override
    public int produceFoodPerTurn() {
        return foodAmount;
    }
    @Override
    public void levelUp() {
        super.levelUp();
        foodAmount += 5;
    }
}



