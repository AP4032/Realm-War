package Models.Shop;

import Models.Structures.FarmLand;

public class Fertilizer extends Shop {
    FarmLand farmLand = new FarmLand();
    public void farmingIncrease() {
        farmLand.setFoodProduction(farmLand.getFoodProduction() * 2);
    }

}
