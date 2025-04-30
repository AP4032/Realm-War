package views;

import models.GameState;
import models.Kingdom;

import javax.swing.*;
import java.awt.*;

public class InfoPanel extends JPanel {
    private JLabel playerLabel;
    private JLabel goldLabel;
    private JLabel foodLabel;
    private JLabel unitSpaceLabel;
    private JLabel turnLabel;
    
    public InfoPanel() {
        setPreferredSize(new Dimension(200, 600));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        playerLabel = new JLabel("Player: ");
        goldLabel = new JLabel("Gold: ");
        foodLabel = new JLabel("Food: ");
        unitSpaceLabel = new JLabel("Unit Space: ");
        turnLabel = new JLabel("Turn: ");
        
        add(playerLabel);
        add(goldLabel);
        add(foodLabel);
        add(unitSpaceLabel);
        add(turnLabel);
        
        add(Box.createVerticalGlue());
    }
    
    public void updateInfo(GameState gameState) {
        Kingdom currentKingdom = gameState.getCurrentKingdom();
        
        playerLabel.setText("Player: " + gameState.getCurrentPlayerTurn());
        goldLabel.setText("Gold: " + currentKingdom.getGold());
        foodLabel.setText("Food: " + currentKingdom.getFood());
        unitSpaceLabel.setText("Unit Space: " + currentKingdom.getUsedUnitSpace() + 
                              "/" + currentKingdom.getTotalUnitSpace());
        turnLabel.setText("Turn: " + gameState.getTurnNumber());
    }
}