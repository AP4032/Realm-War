package org.realm_war.Models.blocks;

import org.realm_war.Models.Position;

import java.awt.*;

public class VoidBlock extends Block {
    public VoidBlock (Position position) {
        super(position);
    }

    @Override
    public boolean canBuildStructure() {
        return false;
    }

    @Override
    public int getResourceItem(String resourceType) {
        // VoidBlock can't provide anything.
        return 0;
    }
    @Override
    public Color getColor() {
        return new Color(59, 59, 59);
    }
}
