package view;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    public GameFrame() {
        setTitle("Realm War");
        setSize(1000, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel rootPanel = new JPanel(new BorderLayout());

        GamePanel gamePanel = new GamePanel();
        JPanel gridWrapper = new JPanel();
        gridWrapper.setPreferredSize(new Dimension(640, 640));
        gridWrapper.add(gamePanel);

        rootPanel.add(gridWrapper, BorderLayout.CENTER);

        JPanel sidePanel = new JPanel();
        sidePanel.setPreferredSize(new Dimension(200, 640));
        sidePanel.setBackground(Color.LIGHT_GRAY);
        rootPanel.add(sidePanel, BorderLayout.EAST);

        add(rootPanel);
        setVisible(true);
    }
}
