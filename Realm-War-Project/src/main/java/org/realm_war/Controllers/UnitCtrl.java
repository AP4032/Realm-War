package org.realm_war.Controllers;

import org.realm_war.Models.GameState;
import org.realm_war.Models.Player;
import org.realm_war.Models.Position;
import org.realm_war.Models.Realm;
import org.realm_war.Models.blocks.Block;
import org.realm_war.Models.blocks.ForestBlock;
import org.realm_war.Models.blocks.VoidBlock;
import org.realm_war.Models.units.Unit;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class UnitCtrl {
    private final List<Unit> units;
    private Unit selectedUnit;
    private Block targetBlock;

    private GameState gameState = new GameState();

    public UnitCtrl() {
        units = new ArrayList<Unit>();
    }

    public Unit getSelectedUnit() {
        return selectedUnit;
    }

    public void setSelectedUnit(Unit u) {
        this.selectedUnit = u;
    }

    public Block getTargetBlock() {
        return targetBlock;
    }

    public void setTargetBlock(Block b) {
        this.targetBlock = b;
    }

    public void addUnit(Unit unit) {
        units.add(unit);
        gameState.getRealms().get(unit.getRealmID() - 1001).possessBlock(gameState.getBlockAt(unit.getPosition()));
        gameState.getRealms().get(unit.getRealmID() - 1001).addUnit(unit);
        gameState.getBlockAt(unit.getPosition()).setUnit(unit);
    }

    public void removeUnit(Unit unit) {
        units.remove(unit);
        gameState.getRealms().get(unit.getRealmID() - 1001).removeUnit(unit);
        gameState.getBlockAt(unit.getPosition()).setOwnerID(0);
        gameState.getBlockAt(unit.getPosition()).setUnit(null);
        gameState.getBlockAt(unit.getPosition()).setOwnerID(unit.getRealmID());
    }

    public boolean isPlayerTurn(Player player) {
        return gameState.getCurrentPlayer().equals(player);
    }

    public void moveUnitToBlock(Unit unit, Block targetBlock) {
        if (targetBlock.getPosition().distanceTo(unit.getPosition()) > unit.getMovementRange()) {
            throw new IllegalArgumentException("Target block is out of movement range");
        }
        claimBlocks(unit.getPosition(), targetBlock.getPosition(), unit.getRealmID());
        removeUnit(unit);
        targetBlock.setUnit(unit);
        unit.setPosition(targetBlock.getPosition());
        addUnit(unit);
    }

    public void attackUnit(Unit attacker, Block targetBlock) {
        // Validate input
        if (attacker == null || targetBlock == null || targetBlock.getUnit() == null) {
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "invalid attack or target.", "Attacker or target", JOptionPane.ERROR_MESSAGE);
            throw new IllegalArgumentException("Invalid attacker or target.");
        }

        Unit defender = targetBlock.getUnit();

        // Check for friendly fire
        if (attacker.getOwner().equals(defender.getOwner())) {
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Cannot attack your own unit!", "Attacker or target", JOptionPane.ERROR_MESSAGE);
            throw new IllegalArgumentException("Cannot attack your own unit.");
        }

        // Check attack range
        if (attacker.getPosition().distanceTo(defender.getPosition()) > attacker.getAttackRange()) {
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Target is out of attack range", "Attacker or target", JOptionPane.ERROR_MESSAGE);
            throw new IllegalArgumentException("Target is out of attack range.");
        }

        // Perform attack

        // Check if defender is defeated
        if (attacker.canAttackUnit(defender)) {
            // Remove defender
            removeUnit(defender);
            addUnit(attacker);
        }
        //else {
        // Optionally: counterattack logic or effects could go here
        //}
    }

    public void claimBlocks(Position start, Position end, int ID) {
        int dx = end.getX() - start.getX();
        int dy = end.getY() - start.getY();
        int steps = Math.max(Math.abs(dx), Math.abs(dy));

        for (int i = 1; i < steps; i++) {
            int x = Math.round(start.getX() + i * dx / (float) steps);
            int y = Math.round(start.getY() + i * dy / (float) steps);
            if (x >= 0 && x < gameState.getMapGrid()[0].length && y >= 0 && y < gameState.getMapGrid().length) {
                Block b = gameState.getMapGrid()[x][y];
                if (!(b instanceof VoidBlock)){
                    b.setOwnerID(ID);
                    gameState.getRealms().get(ID - 1001).possessBlock(b);
                }
            }
        }
    }


    public List<Unit> getAllUnits() {
        return units;
    }
}
