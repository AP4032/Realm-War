package Structur;

import Game.Player;

public class Tower extends Structure implements StructureProperties {
    public Tower(int durability, Player player, int level, int maintenanceCost, int buildingCost, int levelUpCost) {
        super(durability, player, level, maintenanceCost, buildingCost, levelUpCost);
    }

    @Override
    public void upgradeLevel() {

    }
}
