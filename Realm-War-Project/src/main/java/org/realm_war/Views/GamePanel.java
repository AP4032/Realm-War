package org.realm_war.Views;

import org.realm_war.Controllers.UnitCtrl;
import org.realm_war.Models.GameState;
import org.realm_war.Models.Position;
import org.realm_war.Models.Realm;
import org.realm_war.Models.blocks.Block;
import org.realm_war.Models.blocks.VoidBlock;
import org.realm_war.Models.structure.classes.*;
import org.realm_war.Models.units.Unit;
import org.realm_war.Utilities.Constants;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class GamePanel extends JPanel {
    private int rows;
    private int cols;
    private GameState gameState;
    private InfoPanel infoPanel;
    private JButton[][] btnGrid;
    private Block[][] mapGrid;
    private final Dimension blockSize = new Dimension(45, 45);
    private Position selectedPos;
    private Position targetPos;
    private UnitCtrl unitCtrl;

    public GamePanel(GameState gameState, InfoPanel infoPanel, UnitCtrl unitCtrl) {
        this.gameState = gameState;
        this.infoPanel = infoPanel;
        this.unitCtrl = unitCtrl;
        this.rows = Constants.getMapSize();
        this.cols = Constants.getMapSize();
        this.btnGrid = new JButton[rows][cols];
        this.gameState = gameState;
        mapGrid = GameState.getMapGrid();

        setLayout(new GridLayout(rows, cols));
        setPreferredSize(new Dimension(900, 900));
        initializeGrid();
    }

    private void initializeGrid() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                JButton blockButton = new JButton();
                blockButton.setPreferredSize(blockSize);

                Block block = mapGrid[row][col];

                if (block != null) {
                    // Set background color based on realm or block color
                    blockButton.setBackground(
                            block.getRealmByID(gameState.getRealms()) != null
                                    ? block.getRealmByID(gameState.getRealms()).getRealmColor()
                                    : block.getColor()
                    );

                    // Set icon for structure, if present
                    if (block.getStructure() != null) {
                        ImageIcon icon = getIconForButton(block.getStructure());
                        if (icon != null) {
                            blockButton.setIcon(icon);
                        }
                    }
                    // Set icon for unit, if present and structure is not set
                    else if (block.getUnit() != null) {
                        ImageIcon icon = getIconForButton(block.getUnit());
                        if (icon != null) {
                            blockButton.setIcon(icon);
                        }
                    }
                } else {
                    blockButton.setBackground(Constants.clr_3); // fallback color
                }

                // VoidBlock handling
                if (block instanceof VoidBlock) {
                    URL banIconURL = getClass().getResource("/org/realm_war/Utilities/Resources/ban.jpg");
                    if (banIconURL != null) {
                        ImageIcon icon = new ImageIcon(banIconURL);
                        Image scaled = icon.getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH);
                        blockButton.setIcon(new ImageIcon(scaled));
                    } else {
                        System.err.println("Missing resource: ban.jpg");
                    }
                    blockButton.setEnabled(false);
                } else {
                    int finalRow = row;
                    int finalCol = col;
                    blockButton.addActionListener(e -> handleBlockClick(finalRow, finalCol));
                }

                btnGrid[row][col] = blockButton;
                add(blockButton);
            }
        }
    }


    public void refresh() {
        this.mapGrid = gameState.getMapGrid();// reload after setupGame()
        infoPanel.updateInfo(gameState);
        removeAll();
        initializeGrid();
        revalidate();
        repaint();
        selectedPos = targetPos = null;
        unitCtrl.setSelectedUnit(null);
        unitCtrl.setTargetBlock(null);
    }

    public void handleBlockClick(int row, int col) {
       Block clickedBlock = mapGrid[row][col];
       Position clickedPos = clickedBlock.getPosition();

       if (selectedPos == null) {
           // First click: select unit
           Unit selectedUnit = gameState.getUnitAt(clickedPos);
           if (selectedUnit != null) {
               if (selectedUnit.getRealmID() == gameState.getCurrentRealm().getID()){
                   selectedPos = clickedPos;
                   unitCtrl.setSelectedUnit(selectedUnit);
                   JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Selected unit at " + selectedPos.getX() + ", " + selectedPos.getY() + ".");
               }else {
                   JOptionPane.showMessageDialog(this, "Please select a valid unit you own.");
               }
           }else{
               selectedPos = clickedPos;
               JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Selected pos at " + selectedPos.getX() + ", " + selectedPos.getY() + ".");
           }
       } else {
           // Second click: select destination
           targetPos = clickedPos;
           Block targetBlock = gameState.getBlockAt(targetPos);
           unitCtrl.setTargetBlock(targetBlock);

           // Move the unit
           try {
               unitCtrl.moveUnitToBlock(unitCtrl.getSelectedUnit(), targetBlock);
               refresh(); // refresh UI after move
           } catch (Exception e) {
               JOptionPane.showMessageDialog(this, "Failed to move unit: " + e.getMessage());
               e.printStackTrace();
               refresh();
           }

           // Reset selection
       }
   }

    public Position getSelectedPosition() {
        return selectedPos;
    }

    public Position getTargetPosition() {
        return targetPos;
    }

    public Realm getSelectedRealm() {
        return gameState.getCurrentRealm();
    }

    public int getSelectedRealmID() {
        return gameState.getCurrentRealm().getID();
    }

    public GameState getGameState() {
        return gameState;
    }

    public void updateStructure(Structure s) {
        Position pos = s.getPosition();
        int x = pos.getX();
        int y = pos.getY();

        // Update model (game state)
        Block baseBlock = s.getBaseBlock();
        GameState.getMapGrid()[x][y] = baseBlock;
        baseBlock.setStructure(s);

        // Update UI
        JButton button = btnGrid[x][y];
        if (button != null) {
            // Update background color based on block (optional)
            button.setBackground(baseBlock.getColor());

            // Set appropriate structure icon
            ImageIcon icon = getIconForButton(s);
            button.setIcon(icon);
        }
    }

    public void updateUnit(Unit unit) {
        Position pos = unit.getPosition();
        int x = pos.getX();
        int y = pos.getY();
        JButton button = btnGrid[x][y];

        gameState.getCurrentRealm().updateResources();

        if (gameState.getCurrentRealm().getGold() < unit.getPayment()) {
            JOptionPane.showMessageDialog(this, "You don't have enough gold", "Error", JOptionPane.ERROR_MESSAGE);
            return; // 🚨 Prevents placing the unit
        }

        // Deduct gold
        gameState.getCurrentRealm().setGold(gameState.getCurrentRealm().getGold() - unit.getPayment());

        infoPanel.updateInfo(gameState);
        selectedPos = targetPos = null;

        if (button != null) {
            button.setBackground(gameState.getCurrentRealm().getRealmColor());
            ImageIcon icon = getIconForButton(unit);
            button.setIcon(icon);
        }
    }


    public ImageIcon getIconForButton(Object obj) {
        String path = switch (obj.getClass().getSimpleName()) {
            case "TownHall" -> "/org/realm_war/Utilities/Resources/townhall.png";
            case "Barrack" -> "/org/realm_war/Utilities/Resources/barrack.png";
            case "Farm" -> "/org/realm_war/Utilities/Resources/farm.png";
            case "Tower" -> "/org/realm_war/Utilities/Resources/tower.png";
            case "Market" -> "/org/realm_war/Utilities/Resources/market.png";
            case "Peasant" -> "/org/realm_war/Utilities/Resources/peasant.png";
            case "Swordsman" -> "/org/realm_war/Utilities/Resources/swordsman.png";
            case "Spearman" -> "/org/realm_war/Utilities/Resources/spearman.png";
            case "Knight" -> "/org/realm_war/Utilities/Resources/knight.png";
            default -> "/org/realm_war/Utilities/Resources/empty.png";
        };

        if (path == null) return null;

        ImageIcon icon = new ImageIcon(getClass().getResource(path));
        Image img = icon.getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }
}
