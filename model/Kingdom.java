package model;

import units.Units;
import model.structures.Structure;
import model.Grid.Grid;
import java.util.ArrayList;

public class Kingdom {
    private Player player;
    private Grid grid;
    private int food;
    private int gold;
    private ArrayList<Units> units = new ArrayList<>();
    private ArrayList<Structure> structures = new ArrayList<>();





    public ArrayList<Units> getUnits() {
        return units;
    }

    public void addUnit(Unit unit) {
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
    public void deleteStructure(Structure structure){
        structures.remove(structure);
    }
}



