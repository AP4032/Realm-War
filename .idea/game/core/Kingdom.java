package game.core;

import game.structures.*;
import game.units.Unit;

import java.util.ArrayList;
import java.util.List;

public class Kingdom {

    private List<Structure> structures;
    private List<Unit> units;
    private int gold;
    private int food;
    private int unitCapacity;
    private int maxUnits;

    public Kingdom() {
        this.structures = new ArrayList<>();
        this.units = new ArrayList<>();
        this.gold = 0;
        this.food = 0;
        this.unitCapacity = 0;
        this.maxUnits = 0;
    }

    public void addStructure(Structure structure) {
        structures.add(structure);
        if (structure instanceof TownHall) {
            TownHall th = (TownHall) structure;
            this.gold += th.getGoldPerTurn();
            this.food += th.getFoodPerTurn();
            this.maxUnits += th.getUnitSpace();
        } else if (structure instanceof Barrack) {
            this.maxUnits += ((Barrack) structure).getUnitSpace();
        }
    }

    public void addUnit(Unit unit) {
        if (unitCapacity + unit.unitSpace <= maxUnits) {
            units.add(unit);
            unitCapacity += unit.unitSpace;
        } else {
            System.out.println("Not enough unit space!");
        }
    }

    public void removeUnit(Unit unit) {
        units.remove(unit);
        unitCapacity -= unit.unitSpace;
    }

    public void generateResources() {
        for (Structure structure : structures) {
            if (structure instanceof Farm) {
                food += ((Farm) structure).getFoodProduction();
            }
            if (structure instanceof Market) {
                gold += ((Market) structure).getGoldProduction();
            }
        }
    }

    public void payMaintenance() {
        for (Structure structure : structures) {
            gold -= structure.getMaintenanceCost();
        }
    }

    public void levelUpStructure(Structure structure) {
        if (gold >= 5) { // example cost
            structure.upgrade();
            gold -= 5;
        } else {
            System.out.println("Not enough gold to upgrade!");
        }
    }

    public boolean hasTownHall() {
        for (Structure structure : structures) {
            if (structure instanceof TownHall && !structure.isDestroyed()) {
                return true;
            }
        }
        return false;
    }

    public int getGold() {
        return gold;
    }

    public int getFood() {
        return food;
    }

    public int getUnitCapacity() {
        return unitCapacity;
    }

    public int getMaxUnits() {
        return maxUnits;
    }

    public List<Unit> getUnits() {
        return units;
    }

    public List<Structure> getStructures() {
        return structures;
    }
}
