package org.realm_war.Controllers;

import org.realm_war.Models.Realm;
import org.realm_war.Models.structure.classes.Structure;

import java.util.List;

public class StructureCtrl {
    private List<Structure> structures;

    public StructureCtrl(List<Structure> structures) {
        this.structures = structures;
    }

    public boolean upgradeStructure(Structure structure, Realm realm) {
        int cost = getUpgradeCost(structure);
        if (structure.canLevelUp() && realm.getGold() >= cost) {
            realm.addGold(-cost); // or realm.reduceGold(cost) if available
            structure.levelUp();
            return true;
        }
        return false;
    }

    public int getUpgradeCost(Structure structure) {
        return structure.getLevel() * 50;
    }

    public boolean repairStructure(Structure structure, Realm realm, int repairAmount, int repairCost) {
        if (realm.getGold() >= repairCost) {
            realm.addGold(-repairCost);
            structure.setDurability(structure.getDurability() + repairAmount);
            return true;
        }
        return false;
    }

    public void removeStructure(Structure structure) {
        structures.remove(structure);
    }

    public List<Structure> getStructures() {
        return structures;
    }
}
