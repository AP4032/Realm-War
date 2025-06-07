package org.realm_war.Models.blocks;

import org.realm_war.Models.Position;

import java.awt.*;

import static java.awt.Color.LIGHT_GRAY;

public class EmptyBlock extends Block {
    public EmptyBlock(Position position) {
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

            // EmptyBlock can provide gold but can't provide food.

            if (resourceType.equalsIgnoreCase("GOLD")) {
                getResourceItem = 1;
            }
            else if (resourceType.equalsIgnoreCase("FOOD")) {
                getResourceItem = 0;
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
    @Override
    public Color getColor() {
        return LIGHT_GRAY;
    }
}
