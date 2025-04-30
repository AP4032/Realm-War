package controllers;

import models.structures.Structure;
import java.util.List;

public class StructureController {
    private List<Structure> structures;

    public StructureController(List<Structure> structures) {
        this.structures = structures;
    }

    public void createStructure(Structure structure) {
        structures.add(structure);
        // Additional logic for creating a structure
    }

    public void upgradeStructure(Structure structure) {
        structure.upgrade();
        // Additional logic for upgrading a structure
    }

    public void removeStructure(Structure structure) {
        structures.remove(structure);
        // Additional logic for removing a structure
    }

    public List<Structure> getStructures() {
        return structures;
    }
}
