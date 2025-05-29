package org.realm_war.Models.structure.classes;


import org.realm_war.Models.Position;
import org.realm_war.Models.Realm;
import org.realm_war.Models.blocks.Block;

public class Market extends Structure {
    private int goldProduction;

    public Market(int goldProduction, int maxLevel, int initialDurability, int maintenanceCost, Position position, Block baseBlock, int kingdomId) {
        super(maxLevel, initialDurability, maintenanceCost, position, baseBlock, kingdomId);
        this.goldProduction = goldProduction;
    }

    public int getGoldProduction() {
        return goldProduction;
    }

    @Override
    public int getMaintenanceCost() {
        return getLevel() * maintenanceCost;
    }

    @Override
    public void performTurnAction(Realm realm) {
        int goldProduced = goldProduction;
        realm.addGold(goldProduced);
    }

    public int produceGoldPerTurn() {
        return getLevel() * goldProduction;
    }

    @Override
    public boolean canLevelUp() {
        return (getLevel() < getMaxLevel());
    }

    @Override
    public void levelUp() {
        if (!canLevelUp()){
            throw new IllegalStateException("Market is already in max level");
        }
        setLevel(getLevel()+1);
        goldProduction += 10 * getLevel();
    }
}