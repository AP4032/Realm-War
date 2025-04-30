

import javax.swing.SwingUtilities;

import com.realmwar.views.GameFrame;

public class Main {
    public static void main(String[] args) {
        // Start the game
        SwingUtilities.invokeLater(() -> {
            GameFrame gameFrame = new GameFrame();
            gameFrame.setVisible(true);
        });
    }
}