package Structur;

import Game.Player;

public class Market extends Structure  implements StructureProperties {

    public Market(int durability, Player player, int level, int maintenanceCost, int buildingCost, int levelUpCost) {
        super(durability, player, level, maintenanceCost, buildingCost, levelUpCost);
    }
    @Override
    public void upgradeLevel() {

    }
}
