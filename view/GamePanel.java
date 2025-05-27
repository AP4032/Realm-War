package view;

import model.blocks.*;
import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    public static final int ROWS = 10;
    public static final int COLS = 10;

    public GamePanel() {
        setLayout(new GridLayout(ROWS, COLS, 0, 0));
        setPreferredSize(new Dimension(640, 640));

        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                Block block;
                if (row + col < 7 && row + col > 2)
                    block = new ForestBlock(row, col);
                else if ((row + col) % 7 == 0)
                    block = new VoidBlock(row, col);
                else
                    block = new EmptyBlock(row, col);

                BlockView blockView = new BlockView(block);
                add(blockView);
            }
        }
    }
}
