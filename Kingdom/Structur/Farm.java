package Structur;

import Game.Player;

public class Farm extends Structure implements StructureProperties {

    public Farm(int durability, Player player, int level,int maintenanceCost,int buildingCost, int levelUpCost) {
        super(durability, player, level, maintenanceCost, buildingCost, levelUpCost);
    }
    public void produceFood(){

    }

    @Override
    public void upgradeLevel() {

    }
}
