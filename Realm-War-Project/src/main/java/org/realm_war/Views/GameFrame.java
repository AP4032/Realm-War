package org.realm_war.Views;

import org.realm_war.Controllers.UnitCtrl;
import org.realm_war.Models.GameState;
import org.realm_war.Utilities.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GameFrame extends JFrame {
    private GamePanel gamePanel;
    private GameState gameState;
    private InfoPanel infoPanel;
    private UnitCtrl unitCtrl;
    private ActionPanel actionPanel;
    private MenuPanel menuPanel;
    private JPanel sidePanel;
    private static JLabel guidanceLabel;

    public GameFrame() {
        unitCtrl = new UnitCtrl();
        gameState = new GameState();
        infoPanel = new InfoPanel();
        gamePanel = new GamePanel(gameState, infoPanel, unitCtrl);
        actionPanel = new ActionPanel(this, gamePanel);
        menuPanel = new MenuPanel(gameState, gamePanel);

        guidanceLabel = new JLabel("Please choose an action");
        guidanceLabel.setFont(Constants.setBoldFont(23));
        guidanceLabel.setForeground(Constants.clr_1);
        guidanceLabel.setBorder(BorderFactory.createEmptyBorder(0,40,0,0));

        setSize(1050, 1050);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Realm War - a Medieval Strategy Game");
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout(10, 10));

        JPanel temp = new JPanel();
        temp.setLayout(new BorderLayout());
        temp.add(actionPanel, BorderLayout.WEST);
        temp.add(guidanceLabel, BorderLayout.CENTER);

        add(gamePanel, BorderLayout.CENTER);
        initSidePanel();
        add(sidePanel, BorderLayout.EAST);
        add(temp, BorderLayout.SOUTH);
        add(menuPanel, BorderLayout.NORTH);

        setupKeybinding();

        JOptionPane.showMessageDialog(null, "Welcome to Realm War!\n" +
                "Please add players (at least 2) with 'Add player' button.\n" +
                "After that press 'Start game' button to go through the game.\n" +
                "Good Luck!", "Welcome", JOptionPane.INFORMATION_MESSAGE);
        setVisible(true);
    }

    private void initSidePanel() {
        sidePanel = new JPanel();
        sidePanel.setLayout(new BorderLayout());
        sidePanel.add(infoPanel, BorderLayout.NORTH);
    }

    public void updateSidePanel(JPanel panel) {
        sidePanel.removeAll();
        infoPanel.updateInfo(gameState);
        sidePanel.add(infoPanel, BorderLayout.NORTH);
        sidePanel.add(panel, BorderLayout.CENTER);
        sidePanel.revalidate();
        sidePanel.repaint();
    }

    public void setupKeybinding(){
        JRootPane rootPane = this.getRootPane();

        KeyStroke enterKey = KeyStroke.getKeyStroke("ENTER");
        String actionKey = "menuAction";

        rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(enterKey, actionKey);

        rootPane.getActionMap().put(actionKey, new AbstractAction() {
           @Override
            public void actionPerformed(ActionEvent e){
               if(gameState.getPlayers().size() < 2){
                   menuPanel.addPlayersToList();
               }else if (!gameState.isRunning()){
                   menuPanel.startGame();
               }else if(gameState.isRunning()){
                   actionPanel.nextTurn();
               }
           }
        });
    }

    public void setGamePanel(GamePanel newPanel) {
        this.gamePanel = newPanel;
    }
    public static JLabel getGuidanceLabel(){
        return guidanceLabel;
    }
}
