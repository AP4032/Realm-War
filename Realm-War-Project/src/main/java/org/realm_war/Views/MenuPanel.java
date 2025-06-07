package org.realm_war.Views;

import org.realm_war.Controllers.GameCtrl;
import org.realm_war.Models.GameState;
import org.realm_war.Models.Player;
import org.realm_war.Utilities.Constants;
import org.realm_war.Utilities.Resources.RoundedBorder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel implements ActionListener {
    GameFrame gameFrame;
    GameState gameState;
    GamePanel gamePanel;
    GameCtrl gameCtrl;
    JButton addPlayerBtn;
    JButton startGameBtn;
    JButton exitGameBtn;
    JButton playAgainBtn;

    public MenuPanel(GameState gameState, GamePanel gamePanel) {
        this.gameState = gameState;
        this.gamePanel = gamePanel;
        addPlayerBtn = createButton("Add Player");
        startGameBtn = createButton("Start Game");
        startGameBtn.setEnabled(false); // disabled until two players added
        exitGameBtn = createButton("Exit Game");
        playAgainBtn = createButton("Play Again");

        setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
        add(addPlayerBtn);
        add(startGameBtn);
        add(exitGameBtn);
        add(playAgainBtn);
    }

    private JButton createButton(String text) {
        JButton b = new JButton(text);
        b.setFocusPainted(false);
        b.setFocusable(false);
        b.setBackground(Constants.clr_2);
        b.setForeground(Constants.clr_1);
        b.setPreferredSize(new Dimension(140, 30));
        b.setBorder(new RoundedBorder(10));
        b.setFont(new Font("SansSerif", Font.BOLD, 15));
        b.addActionListener(this);
        return b;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        switch (action) {
            case "Add Player" -> addPlayersToList();
            case "Start Game" -> startGame();
            case "Exit Game" -> exitGame();
            case "Play Again" -> playAgain();
        }
    }

    public void addPlayersToList() {
        if (gameState.getPlayers().size() >= 4) {
            addPlayerBtn.setEnabled(false);
            JOptionPane.showMessageDialog(null, "Maximum 4 players allowed.");
            return;
        }

        String name = JOptionPane.showInputDialog("Enter Player " + (gameState.getPlayers().size() + 1) + " name:");
        if (name != null && !name.trim().isEmpty()) {
            Player player = new Player(name.trim(), 0);
            gameState.addPlayer(player);

            JOptionPane.showMessageDialog(null, "Player added: " + name);

            if (gameState.getPlayers().size() >= 2) {
                startGameBtn.setEnabled(true);
            }if (gameState.getPlayers().size() == 4)  addPlayerBtn.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(null, "Name cannot be empty.");
        }
    }

    public void startGame() {
        if (gameState.getPlayers().size() < 2) {
            JOptionPane.showMessageDialog(null, "Please add two players before starting the game.");
            return;
        }
        gameState.setRunning(true);
        gameState.setupGame(); // Initialize map, forests, town halls etc.
        gamePanel.refresh();// <- update the visual grid
        gameState.setRunning(true);
        setEnabled(false); // disable menu panel during game
    }

    public void exitGame(){
        int confirm = JOptionPane.showConfirmDialog(null,
                "Are you sure you want to exit the game?","Exit Game",
                JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if (confirm == JOptionPane.YES_OPTION) {
            gameState.setRunning(false);
            System.exit(0);
            setEnabled(false);
        }
    }
    public void playAgain(){
        int confirm = JOptionPane.showConfirmDialog(null,
                "Are you sure you want to play again?","Play Again",
                JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if (confirm == JOptionPane.YES_OPTION) {
            restartApplication();
        }
    }

    private void restartApplication() {
        try {
            String javaBin = System.getProperty("java.home") + "/bin/java";
            String classpath = System.getProperty("java.class.path");

            String mainClass = "org.realm_war.Launcher";

            ProcessBuilder pb = new ProcessBuilder(
                    javaBin, "-cp", classpath, mainClass
            );
            pb.inheritIO();
            pb.start();

            System.exit(0);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,
                    "Failed to restart the game.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
