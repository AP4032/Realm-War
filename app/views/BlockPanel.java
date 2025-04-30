package views;

import javax.swing.*;
import java.awt.*;
import models.blocks.Block;

public class BlockPanel extends JPanel {
    private JLabel blockTypeLabel;
    private JLabel resourceLabel;
    private JLabel structureLabel;
    private JLabel unitLabel;

    public BlockPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(200, 150));

        blockTypeLabel = new JLabel("Block Type: ");
        resourceLabel = new JLabel("Resources: ");
        structureLabel = new JLabel("Structure: ");
        unitLabel = new JLabel("Unit: ");

        add(blockTypeLabel);
        add(resourceLabel);
        add(structureLabel);
        add(unitLabel);
    }

    public void updateBlockInfo(Block block) {
        blockTypeLabel.setText("Block Type: " + block.getClass().getSimpleName());
        resourceLabel.setText("Resources: " + block.getResourceYield("Gold") + " Gold");
        
        if (block.hasStructure()) {
            structureLabel.setText("Structure: " + block.getStructure().getClass().getSimpleName());
        } else {
            structureLabel.setText("Structure: None");
        }

        if (block.hasUnit()) {
            unitLabel.setText("Unit: " + block.getUnit().getClass().getSimpleName());
        } else {
            unitLabel.setText("Unit: None");
        }
    }
}
