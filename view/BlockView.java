package view;

import model.blocks.Block;
import model.blocks.EmptyBlock;
import model.blocks.ForestBlock;
import model.blocks.VoidBlock;

import javax.swing.*;
import java.awt.*;

public class BlockView extends JButton {

    private Block block;

    public BlockView(Block block) {

        this.block = block;

        setPreferredSize(new Dimension(64, 64));
        setMinimumSize(new Dimension(64, 64));
        setMaximumSize(new Dimension(64, 64));
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);

        updateDisplay();

        addActionListener(e -> {

            JOptionPane.showMessageDialog(this,
                    "Type: " + block.getType() +
                            "\nOwner: " + (block.isOwned() ? block.getOwner() : "None") +
                            "\nGold: " + block.getGoldGeneration() +
                            "\nFood: " + block.getFoodGeneration()
            );

            if (block instanceof ForestBlock forest) {
                forest.cutForest();
            }

            updateDisplay();
        });
    }

    public void updateDisplay() {


        if (block instanceof ForestBlock forest) {
            if (forest.hasForest()) {
                ImageIcon icon = new ImageIcon(getClass().getResource("/Images/forest.png"));
                setIcon(resizeIcon(icon, 64, 64));
            }
            else {
                ImageIcon icon = new ImageIcon(getClass().getResource("/Images/cutForest.png"));
                setIcon(resizeIcon(icon, 64, 64));
            }
        }
        else if (block instanceof VoidBlock) {
            ImageIcon icon = new ImageIcon(getClass().getResource("/Images/void.png"));
            setIcon(resizeIcon(icon, 64, 64));
        }
        else if (block instanceof EmptyBlock) {
            ImageIcon icon = new ImageIcon(getClass().getResource("/Images/empty.png"));
            setIcon(resizeIcon(icon, 64, 64));
        }
        setOpaque(true);
        setBorderPainted(false);
    }

    public Block getBlock() {
        return block;
    }

    private ImageIcon resizeIcon(ImageIcon icon, int w, int h) {
        Image img = icon.getImage();
        Image resized = img.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        return new ImageIcon(resized);
    }
}
