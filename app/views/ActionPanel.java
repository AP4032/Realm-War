package views;

import javax.swing.*;
import java.awt.*;

public class ActionPanel extends JPanel {
    private JButton endTurnButton;
    private JButton buildButton;
    private JButton recruitButton;
    private JButton moveButton;
    private JButton attackButton;
    
    public ActionPanel() {
        setPreferredSize(new Dimension(800, 100));
        setLayout(new FlowLayout());
        
        endTurnButton = new JButton("End Turn");
        buildButton = new JButton("Build");
        recruitButton = new JButton("Recruit");
        moveButton = new JButton("Move");
        attackButton = new JButton("Attack");
        
        add(buildButton);
        add(recruitButton);
        add(moveButton);
        add(attackButton);
        add(endTurnButton);
        
        // Add action listeners
        endTurnButton.addActionListener(e -> {
            // Trigger next turn in GameState
            // Example: gameState.nextTurn();
        });
        
        buildButton.addActionListener(e -> {
            // Open build menu
            JOptionPane.showMessageDialog(this, "Build menu opened.");
        });

        recruitButton.addActionListener(e -> {
            // Open recruit menu
            JOptionPane.showMessageDialog(this, "Recruit menu opened.");
        });

        moveButton.addActionListener(e -> {
            // Enable move mode
            JOptionPane.showMessageDialog(this, "Move mode enabled.");
        });

        attackButton.addActionListener(e -> {
            // Enable attack mode
            JOptionPane.showMessageDialog(this, "Attack mode enabled.");
        });
    }
}