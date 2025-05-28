package model;

import model.structures.Farm;
import model.structures.Market;
import model.units.Units;
import model.blocks.Block;
import model.structures.Structures;
import model.Grid.Grid;
import java.util.ArrayList;

public class Kingdom {
    private Player player;
    private Grid grid;
    private int food;
    private int gold;
    private ArrayList<Units> units = new ArrayList<>();
    private ArrayList<Structures> structures = new ArrayList<>();
    private ArrayList<Block> blocks = new ArrayList<>();


    public ArrayList<Structures> getStructures() {
        return structures;
    }


    public void resources() {

        for (Block b : blocks) {
            this.gold += b.getGoldGeneration();
            this.food += b.getFoodGeneration();
        }

        for (Structures s : structures) {
            this.gold -= s.getMaintenanceCost();
            if (s instanceof Market) {
                ((Market) s).produce_gold(this);
            }
            ;

            if (s instanceof Farm) {
                ((Farm) s).produce_food(this);
            }
            ;
        }

        for (Units u : units) {
            gold -= u.getPayment();
            food -= u.getRation();
        }


    }

    public ArrayList<Units> getUnits() {
        return units;
    }

    public void addUnit(Units unit) {
        units.add(unit);
    }


    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public int getGold() {
        return gold;
    }

    public void deleteUnit(Units unit){
        units.remove(unit);
    }
    public void deleteStructure(Structures structure){
        structures.remove(structure);
    }
}



