package controllers;

import models.units.Unit;
import models.Position;
import java.util.List;

public class UnitController {
    private List<Unit> units;

    public UnitController(List<Unit> units) {
        this.units = units;
    }

    public void createUnit(Unit unit) {
        units.add(unit);
        // Additional logic for creating a unit
    }

    public void moveUnit(Unit unit, int x, int y) {
        Position newPosition = new Position(x, y);
        unit.setPosition(newPosition);
        // Additional logic for moving a unit
    }

    public void removeUnit(Unit unit) {
        units.remove(unit);
        // Additional logic for removing a unit
    }

    public List<Unit> getUnits() {
        return units;
    }
}
