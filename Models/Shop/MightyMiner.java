package Models.Shop;

import Models.Structures.GoldMine;

public class MightyMiner extends Shop {
    GoldMine goldMine = new GoldMine();
    public void increaseMine() {
        goldMine.setGoldProduction(goldMine.getGoldProduction() * 2);
    }
    public void decreaseMine() {
        goldMine.setGoldProduction(goldMine.getGoldProduction() / 2);
    }
}
