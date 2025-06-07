package Models.Blocks;

import Models.Structures.Structures;
import Models.Units.Units;

public class Blocks {
private Structures structure;
private Units units;
public void setUnits(Units units) {
    this.units = units;
}
public Units getUnits() {
    return units;
}
public void setStructure(Structures structure) {
    this.structure = structure;
}
public Structures getStructure() {
    return structure;
}
}
