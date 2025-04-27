package structure.classes;

import structure.interfaces.GoldProduction;

public class Market extends Structure implements GoldProduction {
    private int goldAmount;

    public Market(int buildCost) {
        this.level = 1;
        this.maxLevel = 3;
        this.durability = 50;
        this.maintenanceCost = 5;
        this.levelUpCost = 5;
        this.goldAmount = 5;
        this.buildingCost = buildCost;
    }

    @Override
    public void levelUp() {
        if (level < maxLevel) {
            level++;
            durability += 10;         // Each level adds durability
            goldAmount += 5;         // Each level adds more gold
            levelUpCost += 5;         // Cost increases by 5 each level
        } else {
            System.out.println("Market is already at max level.");
        }
    }


    @Override
    public int produceGoldPerTurn() {
        return goldAmount;
    }
}
