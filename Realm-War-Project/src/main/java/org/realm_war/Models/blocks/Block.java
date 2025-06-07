package org.realm_war.Models.blocks;

import org.realm_war.Models.Position;
import org.realm_war.Models.Realm;
import org.realm_war.Models.structure.classes.Structure;
import org.realm_war.Models.units.Unit;

import java.awt.*;
import java.util.List;
import java.util.Objects;


public abstract class Block {
    private Position position;
    private Unit unit;
    private Structure structure;
    private boolean isAbsorbed;
    private int realmID; // 0 for not absorbed.
    private Color ownerColor;
    public Block(Position position) {
        this.position = position;
        this.isAbsorbed = false;
        this.realmID = 0;
    }

    public abstract boolean canBuildStructure();
    public abstract int getResourceItem(String resourceType);

    public abstract Color getColor();

    public Position getPosition() { return position; }
    public int getX() { return position.getX(); }
    public int getY() { return position.getY(); }
    public boolean isAbsorbed() { return isAbsorbed; }

    public Realm getRealmByID(List<Realm> realms) {
        if (realmID == -1) return null; // or some invalid ID

        for (Realm realm : realms) {
            if (realm.getID() == realmID) {
                return realm;
            }
        }
        return null;
    }


    public void setAbsorbed(boolean isAbsorbed, int realmName) {
        this.isAbsorbed = isAbsorbed;
        this.realmID = realmID;
    }

    public Structure getStructure() {
        return structure;
    }

    public void setStructure(Structure structure) {
        this.structure = structure;
    }

    public boolean hasStructure() {
        return structure != null;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
        realmID = unit == null ? 0 : unit.getRealmID();
    }

    public boolean isWalkable() {
        return !(this instanceof VoidBlock);
    }

    public boolean hasUnit() {
        return unit != null;
    }

    public boolean isOccupied() {
        return unit != null || structure != null;
    }

    public int getRealmID() {
        return realmID;
    }

    public void setOwnerID (int id){ this.realmID = id; }

    public void setOwnerColor(Color color) {
        this.ownerColor = color;
    }

    public Color getOwnerColor() {
        return ownerColor;

    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Block other = (Block) obj;
        return this.getX() == other.getX() && this.getY() == other.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }

}
