package Kingdom.Structur;

import Game.Player;

public class TownHall extends Structure implements StructureProperties {
    public TownHall(int durability, Player player, int level, int maintenanceCost, int buildingCost, int levelUpCost) {
        super(durability, player, level, maintenanceCost, buildingCost, levelUpCost);
    }

    @Override
    public void upgradeLevel() {

    }
}
