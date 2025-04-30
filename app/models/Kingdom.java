package models;

import models.blocks.Block;
import models.structures.Structure;
import models.units.Unit;
import models.structures.TownHall;
import models.structures.Farm;
import models.structures.Market;

import java.util.ArrayList;
import java.util.List;

public class Kingdom {
    private int id;
    private int gold;
    private int food;
    private int totalUnitSpace;
    private int usedUnitSpace;
    private TownHall townHall;
    private List<Structure> structures;
    private List<Unit> units;
    private List<Block> absorbedBlocks;

    public Kingdom(int id, TownHall townHall) {
        this.id = id;
        this.townHall = townHall;
        this.structures = new ArrayList<>();
        this.units = new ArrayList<>();
        this.absorbedBlocks = new ArrayList<>();
        
        this.structures.add(townHall);
        this.totalUnitSpace = townHall.getUnitSpace();
        this.gold = 20; // Starting gold
        this.food = 20; // Starting food
    }

    public void startTurn() {
        // Generate resources from structures
        for (Structure structure : structures) {
            if (structure instanceof TownHall) {
                this.gold += ((TownHall) structure).getGoldProduction();
                this.food += ((TownHall) structure).getFoodProduction();
            } else if (structure instanceof Farm) {
                this.food += ((Farm) structure).getFoodProduction();
            } else if (structure instanceof Market) {
                this.gold += ((Market) structure).getGoldProduction();
            }
        }
        
        // Generate resources from absorbed blocks
        for (Block block : absorbedBlocks) {
            this.gold += block.getResourceYield("GOLD");
            this.food += block.getResourceYield("FOOD");
        }
        
        // Pay maintenance costs
        for (Structure structure : structures) {
            this.gold -= structure.getMaintenanceCost();
        }
        
        // Pay unit costs
        for (Unit unit : units) {
            this.gold -= unit.getPaymentCost();
            this.food -= unit.getRationCost();
        }
    }

    public boolean canBuildStructure(Structure structure) {
        // Check if player has enough resources
        // Check if position is valid
        // Check if max structures of this type hasn't been reached
        return true; // Simplified for example
    }
    
    public void addStructure(Structure structure) {
        structures.add(structure);
    }
    
    public void addUnit(Unit unit) {
        if (usedUnitSpace + unit.getUnitSpace() > totalUnitSpace) {
            throw new IllegalStateException("Not enough unit space");
        }
        units.add(unit);
        usedUnitSpace += unit.getUnitSpace();
    }
    
    public void absorbBlock(Block block) {
        block.setAbsorbed(true, this.id);
        absorbedBlocks.add(block);
    }
    
    public void updateResources() {
        // Generate resources from structures
        for (Structure structure : structures) {
            if (structure instanceof TownHall) {
                this.gold += ((TownHall) structure).getGoldProduction();
                this.food += ((TownHall) structure).getFoodProduction();
            } else if (structure instanceof Farm) {
                this.food += ((Farm) structure).getFoodProduction();
            } else if (structure instanceof Market) {
                this.gold += ((Market) structure).getGoldProduction();
            }
        }

        // Generate resources from absorbed blocks
        for (Block block : absorbedBlocks) {
            this.gold += block.getResourceYield("GOLD");
            this.food += block.getResourceYield("FOOD");
        }

        // Pay maintenance costs
        for (Structure structure : structures) {
            this.gold -= structure.getMaintenanceCost();
        }

        // Pay unit costs
        for (Unit unit : units) {
            this.gold -= unit.getPaymentCost();
            this.food -= unit.getRationCost();
        }
    }
    
    // Getters and setters
    public int getId() { return id; }
    public int getGold() { return gold; }
    public void setGold(int gold) { this.gold = gold; }
    public int getFood() { return food; }
    public void setFood(int food) { this.food = food; }
    public int getTotalUnitSpace() { return totalUnitSpace; }
    public int getUsedUnitSpace() { return usedUnitSpace; }
    public TownHall getTownHall() { return townHall; }
    public List<Structure> getStructures() { return structures; }
    public List<Unit> getUnits() { return units; }
    public List<Block> getAbsorbedBlocks() { return absorbedBlocks; }
}