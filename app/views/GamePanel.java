package views;

import models.*;
import models.blocks.*;
import models.structures.*;
import models.units.*;
import models.blocks.*;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GamePanel extends JPanel {
    private static final int BLOCK_SIZE = 50;
    private GameState gameState;
    private Unit selectedUnit;
    private boolean moveMode;
    
    public GamePanel() {
        setPreferredSize(new Dimension(800, 600));
        setBackground(Color.DARK_GRAY);
        
        // Initialize with a default game state
        this.gameState = new GameState(15, 10, 2);
        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                handleClick(e.getX(), e.getY());
            }
        });
    }
    
    public void enableMoveMode() {
        moveMode = true;
        selectedUnit = null;
    }
    
    private void handleClick(int x, int y) {
        int blockX = x / BLOCK_SIZE;
        int blockY = y / BLOCK_SIZE;
        
        if (blockX >= 0 && blockX < gameState.getGameMap().length &&
            blockY >= 0 && blockY < gameState.getGameMap()[0].length) {
            Block clickedBlock = gameState.getGameMap()[blockX][blockY];

            if (moveMode) {
                if (selectedUnit == null) {
                    // Select a unit
                    selectedUnit = findUnitAt(blockX, blockY);
                    if (selectedUnit != null) {
                        System.out.println("Unit selected at: " + blockX + ", " + blockY);
                    }
                } else {
                    // Move the selected unit
                    if (isValidMove(selectedUnit, blockX, blockY)) {
                        selectedUnit.setPosition(new Position(blockX, blockY));
                        System.out.println("Unit moved to: " + blockX + ", " + blockY);
                        moveMode = false;
                        selectedUnit = null;
                        repaint();
                    }
                }
            } else {
                System.out.println("Selected block at: " + blockX + ", " + blockY);
            }
        }
    }
    
    private Unit findUnitAt(int x, int y) {
        for (Kingdom kingdom : gameState.getKingdoms()) {
            for (Unit unit : kingdom.getUnits()) {
                if (unit.getPosition().getX() == x && unit.getPosition().getY() == y) {
                    return unit;
                }
            }
        }
        return null;
    }
    
    private boolean isValidMove(Unit unit, int x, int y) {
        // Check if the move is within the unit's movement range
        int currentX = unit.getPosition().getX();
        int currentY = unit.getPosition().getY();
        int distance = Math.abs(currentX - x) + Math.abs(currentY - y);
        return distance <= unit.getMovementRange() &&
               x >= 0 && x < gameState.getGameMap().length &&
               y >= 0 && y < gameState.getGameMap()[0].length &&
               !(gameState.getGameMap()[x][y] instanceof EmptyBlock);
    }
    
    private void handleAttack(Unit attacker, int targetX, int targetY) {
        Unit targetUnit = findUnitAt(targetX, targetY);
        if (targetUnit != null && isValidAttack(attacker, targetUnit)) {
            targetUnit.setHitPoints(targetUnit.getHitPoints() - attacker.getAttackPower());
            System.out.println("Attacked unit at: " + targetX + ", " + targetY);
            if (targetUnit.getHitPoints() <= 0) {
                System.out.println("Unit defeated at: " + targetX + ", " + targetY);
                removeUnit(targetUnit);
            }
            repaint();
        }
    }

    private boolean isValidAttack(Unit attacker, Unit target) {
        int attackerX = attacker.getPosition().getX();
        int attackerY = attacker.getPosition().getY();
        int targetX = target.getPosition().getX();
        int targetY = target.getPosition().getY();
        int distance = Math.abs(attackerX - targetX) + Math.abs(attackerY - targetY);
        return distance <= attacker.getAttackRange();
    }

    private void removeUnit(Unit unit) {
        for (Kingdom kingdom : gameState.getKingdoms()) {
            kingdom.getUnits().remove(unit);
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Block[][] map = gameState.getGameMap();
        for (int x = 0; x < map.length; x++) {
            for (int y = 0; y < map[x].length; y++) {
                drawBlock(g, map[x][y], x * BLOCK_SIZE, y * BLOCK_SIZE);
            }
        }
        
        // Draw structures and units
        for (Kingdom kingdom : gameState.getKingdoms()) {
            for (Structure structure : kingdom.getStructures()) {
                drawStructure(g, structure);
            }
            for (Unit unit : kingdom.getUnits()) {
                drawUnit(g, unit);
            }
        }
        
        // Highlight valid moves for the selected unit
        if (selectedUnit != null) {
            int currentX = selectedUnit.getPosition().getX();
            int currentY = selectedUnit.getPosition().getY();
            int range = selectedUnit.getMovementRange();
            g.setColor(new Color(0, 255, 255, 128)); // Semi-transparent cyan
            for (int dx = -range; dx <= range; dx++) {
                for (int dy = -range; dy <= range; dy++) {
                    int x = currentX + dx;
                    int y = currentY + dy;
                    if (isValidMove(selectedUnit, x, y)) {
                        g.fillRect(x * BLOCK_SIZE, y * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);
                    }
                }
            }
        }

        // Highlight selected unit
        if (selectedUnit != null) {
            Position pos = selectedUnit.getPosition();
            g.setColor(Color.CYAN);
            g.drawRect(pos.getX() * BLOCK_SIZE, pos.getY() * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);
        }
    }
    
    private void drawBlock(Graphics g, Block block, int x, int y) {
        if (block instanceof EmptyBlock) {
            g.setColor(Color.BLACK);
        } else if (block instanceof ForestBlock) {
            g.setColor(new Color(34, 139, 34)); // Forest green
        } else if (block instanceof EmptyBlock) {
            if (block.isAbsorbed()) {
                g.setColor(new Color(210, 180, 140)); // Tan for absorbed
            } else {
                g.setColor(new Color(144, 238, 144)); // Light green for empty
            }
        }
        
        g.fillRect(x, y, BLOCK_SIZE, BLOCK_SIZE);
        g.setColor(Color.BLACK);
        g.drawRect(x, y, BLOCK_SIZE, BLOCK_SIZE);
    }
    
    private void drawStructure(Graphics g, Structure structure) {
        Position pos = structure.getPosition();
        int x = pos.getX() * BLOCK_SIZE;
        int y = pos.getY() * BLOCK_SIZE;
        
        // Different colors for different structure types
        if (structure instanceof TownHall) {
            g.setColor(Color.RED);
        } else if (structure instanceof Barrack) {
            g.setColor(Color.BLUE);
        } else if (structure instanceof Farm) {
            g.setColor(Color.GREEN);
        } else if (structure instanceof Market) {
            g.setColor(Color.YELLOW);
        } else if (structure instanceof Tower) {
            g.setColor(Color.ORANGE);
        }
        
        g.fillRect(x + 10, y + 10, BLOCK_SIZE - 20, BLOCK_SIZE - 20);
        
        // Draw structure level
        g.setColor(Color.WHITE);
        g.drawString("" + structure.getLevel(), x + BLOCK_SIZE/2, y + BLOCK_SIZE/2);
    }
    
    private void drawUnit(Graphics g, Unit unit) {
        Position pos = unit.getPosition();
        int x = pos.getX() * BLOCK_SIZE;
        int y = pos.getY() * BLOCK_SIZE;
        
        // Different shapes for different unit types
        g.setColor(Color.WHITE);
        if (unit instanceof Peasant) {
            g.fillOval(x + 15, y + 15, 20, 20);
        } else if (unit instanceof Spearman) {
            g.fillRect(x + 15, y + 15, 20, 20);
        } else if (unit instanceof Swordman) {
            int[] xPoints = {x + 25, x + 15, x + 35};
            int[] yPoints = {y + 15, y + 35, y + 35};
            g.fillPolygon(xPoints, yPoints, 3);
        } else if (unit instanceof Knight) {
            g.fillOval(x + 10, y + 10, 30, 30);
        }
        
        // Draw unit health
        g.setColor(Color.RED);
        int healthWidth = (int)((BLOCK_SIZE - 4) * ((double)unit.getHitPoints() / unit.getMaxHitPoints()));
        g.fillRect(x + 2, y + BLOCK_SIZE - 8, healthWidth, 4);
    }
    
    public void setGameState(GameState gameState) {
        this.gameState = gameState;
        repaint();
    }
}