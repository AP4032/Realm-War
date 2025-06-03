package Structur;

import Game.Player;

public class Barrack extends Structure implements StructureProperties {
    public Barrack(int durability, Player player, int level,int maintenanceCost,int buildingCost, int levelUpCost) {
        super(durability, player, level, maintenanceCost, buildingCost, levelUpCost);
    }

    @Override
    public void upgradeLevel() {

    }
}
