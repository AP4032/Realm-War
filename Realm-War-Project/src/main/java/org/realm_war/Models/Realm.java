package org.realm_war.Models;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import org.realm_war.Models.blocks.Block;
import org.realm_war.Models.structure.classes.Structure;
import org.realm_war.Models.structure.classes.TownHall;
import org.realm_war.Models.units.Unit;

public class Realm {
    private int gold;
    private final int ID;
    private TownHall townHall;
    private int food;
    private List<Structure> structures;
    private List<Unit> units;
    private List<Block> possessedBlocks;
    private int allUnitSpace;
    private int usedUnitSpace;

    private Color realmColor;

    public Realm(int ID) {
        this.ID = ID;
        structures = new ArrayList<>();
        units = new ArrayList<>();
        possessedBlocks = new ArrayList<>();
        this.townHall = null;
        this.allUnitSpace = 5;
        this.gold = 25;
        this.food = 25;
    }

    public void updateResources(){
        for (Structure s : structures){
            s.performTurnAction(this);
        }

        for (Structure s : structures){
            gold -= s.getMaintenanceCost();
        }

        for (Block b : possessedBlocks){
            gold += b.getResourceItem("gold");
            food += b.getResourceItem("food");
        }

        for (Unit u : units){
            gold -= u.getPayment();
            food -= u.getRation();
        }

        if (gold <= 0){
            gold = 0;
            units.clear();
            structures.clear();
            throw new RuntimeException("you ran out of gold. you lost all your units and structures.");
        }
    }

    public boolean canBuildStructure(Structure s){
        if (s.getMaintenanceCost() > this.gold) {
            return false;
        }
        if (!this.possessedBlocks.contains(s.getBaseBlock())) {
            return false;
        }
        return true;
    }

    public void addStructure(Structure s){
        if (canBuildStructure(s)){
            structures.add(s);
            gold -= s.getMaintenanceCost();
        }else throw new IllegalArgumentException("Can't build structure here!");
    }

    public void addUnit(Unit u){
        if (usedUnitSpace + u.getUnitSpace() > allUnitSpace){
            throw new IllegalArgumentException("insufficient space!");
        }
        units.add(u);
        usedUnitSpace += u.getUnitSpace();
    }

    public void mergeUnit(Unit u, Unit target){
        usedUnitSpace -= target.getUnitSpace();
        units.remove(target);
        if (usedUnitSpace + u.getUnitSpace() > allUnitSpace){
            throw new IllegalArgumentException("insufficient space!");
        }
        units.add(u);
        usedUnitSpace += u.getUnitSpace();
    }

    public void removeUnit(Unit u){
        units.remove(u);
        usedUnitSpace -= u.getUnitSpace();
    }

    public void possessBlock(Block b) {
        b.setAbsorbed(true, this.ID);
        if (!possessedBlocks.contains(b)) {
            possessedBlocks.add(b);
            allUnitSpace++;
        }
    }

    public Color getRealmColor (){
        return realmColor;
    }

    public void setTownHall(TownHall t){
        this.townHall = t;
    }

    public void setRealmColor(Color c){
        this.realmColor=c;
    }

    public int getGold() {
        return gold;
    }

    public void setGold (int n){ this.gold = n; }

    public void addGold(int amount) {
        this.gold += amount;
    }

    public int getFood() {
        return food;
    }

    public void addFood(int amount) {
        this.food += amount;
    }

    public int getID() {
        return ID;
    }

    public List<Structure> getStructures() {
        return structures;
    }

    public List<Unit> getUnits() {
        return units;
    }

    public int getUsedUnitSpace() {
        return usedUnitSpace;
    }

    public int getAllUnitSpace() {
        return allUnitSpace;
    }

    public List<Block> getPossessedBlocks() {
        return possessedBlocks;
    }

}
