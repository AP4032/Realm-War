package org.realm_war.Models.blocks;

import org.realm_war.Models.Position;

import java.awt.*;

public class ForestBlock extends Block {
    public ForestBlock (Position position) {
        super(position);
    }

    @Override
    public boolean canBuildStructure() {
        return isAbsorbed();
    }

    @Override
    public int getResourceItem (String resourceType) {
        if (isAbsorbed()) {
            int getResourceItem;

            // ForestBlock can't provide gold but provides more food.

            if (resourceType.equalsIgnoreCase("GOLD")) {
                getResourceItem = 0;
            }
            else if (resourceType.equalsIgnoreCase("FOOD")) {
                getResourceItem = 2;
            }
            else {
                getResourceItem = 0;
            }
            return getResourceItem;
        }
        else {
            return 0;
        }
    }
    public double getAttackBonus() {
        return 1.3; // ForestBlock gives 30% attack bonus.
    }
    @Override
    public Color getColor() {
        return new Color(38, 124, 54);
    }

}
