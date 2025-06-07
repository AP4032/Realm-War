package org.realm_war.Views;

import javax.swing.*;
import java.awt.*;

import org.realm_war.Models.GameState;
import org.realm_war.Models.Realm;

public class InfoPanel extends JPanel {
    private JLabel playerLabel;
    private JLabel goldLabel;
    private JLabel foodLabel;
    private JLabel unitSpaceLabel;
    private JLabel turnLabel;

    public InfoPanel() {
        setPreferredSize(new Dimension(150, 150));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        playerLabel = new JLabel("Player: ");
        goldLabel = new JLabel("Gold: ");
        foodLabel = new JLabel("Food: ");
        unitSpaceLabel = new JLabel("Unit Space: ");
        turnLabel = new JLabel("Turn: ");

        add(playerLabel);
        add(Box.createVerticalStrut(10));
        add(goldLabel);
        add(Box.createVerticalStrut(10));
        add(foodLabel);
        add(Box.createVerticalStrut(10));
        add(unitSpaceLabel);
        add(Box.createVerticalStrut(10));
        add(turnLabel);

        add(Box.createVerticalGlue());
    }

    public void updateInfo(GameState gameState) {
        Realm currentRealm = gameState.getCurrentRealm();

        playerLabel.setText("Player: " + gameState.getCurrentPlayer().getName());
        goldLabel.setText("Gold: " + currentRealm.getGold());
        foodLabel.setText("Food: " + currentRealm.getFood());
        unitSpaceLabel.setText("Unit Space: " + currentRealm.getUsedUnitSpace() +
                "/" + currentRealm.getAllUnitSpace());
        turnLabel.setText("Turn: " + gameState.getTurnNumber());
    }
}

