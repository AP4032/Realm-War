package org.example.swing;

import org.example.controller.Game;
import org.example.models.player.Player;
import org.example.models.units.Knight;
import org.example.models.units.Swordman;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class GUI extends JFrame{
    private JPanel currentPanel;
    int numberOfPlayers;
    ArrayList<Player> players = new ArrayList<Player>();
    String playerName;

    public GUI() {
        setTitle("RealM War");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);

        currentPanel = new JPanel(new BorderLayout());
        this.add(currentPanel, BorderLayout.CENTER);

        ShowMainMenu();

        setVisible(true);
    }

    public void ShowMainMenu(){
        currentPanel.removeAll();

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.VERTICAL;

        JButton button1 = new JButton("New Game");
        button1.setPreferredSize(new Dimension(200, 30));
        JButton button2 = new JButton("Continue");
        button2.setPreferredSize(new Dimension(200, 30));
        JButton button3 = new JButton("Exit");
        button3.setPreferredSize(new Dimension(200, 30));

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(button1,gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(button2,gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(button3,gbc);

        button1.addActionListener(e -> {
            ShowNewGame();
        });
        button2.addActionListener(e -> {

        });
        button3.addActionListener(e -> {
            System.exit(0);
        });

        currentPanel.add(panel, BorderLayout.CENTER);

        revalidate();
        repaint();
    }

    public void ShowNewGame(){
        currentPanel.removeAll();

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.VERTICAL;


        JButton singleButton = new JButton("Single Player");
        singleButton.setPreferredSize(new Dimension(200, 30));
        JButton doubleButton = new JButton("Double Player");
        doubleButton.setPreferredSize(new Dimension(200, 30));
        JButton threeButton = new JButton("Three Player");
        threeButton.setPreferredSize(new Dimension(200, 30));
        JButton fourthButton = new JButton("Fourth Player");
        fourthButton.setPreferredSize(new Dimension(200, 30));
        JButton backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(200, 30));

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(singleButton, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(doubleButton, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(threeButton, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(fourthButton, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(backButton, gbc);

        singleButton.addActionListener(actionPerformed -> {
            numberOfPlayers = 1;
            GameControl();
        });
        doubleButton.addActionListener(actionPerformed -> {
            numberOfPlayers = 2;
            GameControl();
        });
        threeButton.addActionListener(actionPerformed -> {
            numberOfPlayers = 3;
            GameControl();
        });
        fourthButton.addActionListener(actionPerformed -> {
            numberOfPlayers = 4;
            GameControl();
        });
        backButton.addActionListener(actionPerformed -> {
            ShowMainMenu();
        });

        currentPanel.add(panel, BorderLayout.CENTER);

        revalidate();
        repaint();
    }

    public void ShowGameBoardWindow(Player player){
        currentPanel.removeAll();

        JPanel mainPanel = new JPanel(new BorderLayout());

        ImageIcon farmIcon = new ImageIcon("10751558.png");
        JButton farm = new JButton(farmIcon);
        farm.setPreferredSize(new Dimension(50, 50));
        ImageIcon barrackIcon = new ImageIcon("10751558.png");
        JButton barrack = new JButton(barrackIcon);
        barrack.setPreferredSize(new Dimension(50, 50));
        ImageIcon marketIcon = new ImageIcon("10751558.png");
        JButton market = new JButton(marketIcon);
        market.setPreferredSize(new Dimension(50, 50));
        ImageIcon towerIcon = new ImageIcon("10751558.png");
        JButton tower = new JButton(towerIcon);
        tower.setPreferredSize(new Dimension(50, 50));

        ImageIcon peasantIcon = new ImageIcon("images.png");
        JButton peasant = new JButton(peasantIcon);
        peasant.setPreferredSize(new Dimension(50, 50));
        ImageIcon spearmanIcon = new ImageIcon("images.png");
        JButton spearman = new JButton(spearmanIcon);
        spearman.setPreferredSize(new Dimension(50, 50));
        ImageIcon swordManIcon = new ImageIcon("images.png");
        JButton swordMan = new JButton(swordManIcon);
        swordMan.setPreferredSize(new Dimension(50, 50));
        ImageIcon knightIcon = new ImageIcon("images.png");
        JButton knight = new JButton(knightIcon);
        knight.setPreferredSize(new Dimension(50, 50));


        JPanel topPanel=new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER,50,0));
        JLabel playerNameLabel = new JLabel("Player Name: " + player.getName());
        JLabel foodLabel = new JLabel("Food: " + player.getGold());
        JLabel goldLabel = new JLabel("Gold: " + player.getFoodSupply());
        topPanel.add(playerNameLabel);
        topPanel.add(foodLabel);
        topPanel.add(goldLabel);


        gamePanel gamePanel=new gamePanel(player);
        gamePanel.setSize(300,300);



        JPanel ButtonPanel = new JPanel(new BorderLayout());

        JPanel StructurePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        StructurePanel.add(farm);
        StructurePanel.add(barrack);
        StructurePanel.add(market);
        StructurePanel.add(tower);

        JPanel UnitPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 5, 0));
        UnitPanel.add(peasant);
        UnitPanel.add(spearman);
        UnitPanel.add(swordMan);
        UnitPanel.add(knight);

        ButtonPanel.add(StructurePanel, BorderLayout.WEST);
        ButtonPanel.add(UnitPanel, BorderLayout.EAST);

        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(gamePanel, BorderLayout.CENTER);
        mainPanel.add(ButtonPanel, BorderLayout.SOUTH);

        currentPanel.add(mainPanel, BorderLayout.CENTER);

        revalidate();
        repaint();
    }
    public class gamePanel extends JPanel {
         int rows = 12;
         int cols = 12;
        private JButton[][] buttons = new JButton[rows][cols];
        private ImageIcon voidIcon;
        private ImageIcon emptyIcon;
        private ImageIcon forestIcon;
        private ImageIcon townHallIcon;

            public gamePanel(Player player) {
                voidIcon = new ImageIcon("Void.jpg");
                emptyIcon = new ImageIcon("Empty.png");
                forestIcon = new ImageIcon("Forest.png");
                townHallIcon = new ImageIcon("TownHall.jpg");

                this.setLayout(new GridLayout(rows, cols));

                for (int row = 0; row < rows; row++) {
                    for (int col = 0; col < cols; col++) {
                        JButton button = new JButton();
                        if (row == 0 || col == 0 || row == rows - 1 || col == cols - 1) {
                            button.setIcon(voidIcon);
                            button.setEnabled(false);
                        } else {
                            button.setIcon(emptyIcon);
                        }
                        buttons[row][col] = button;
                        this.add(button);
                    }
                }

                int count = 0;
                Random rand = new Random();
                while (count < 10) {
                    int row = rand.nextInt(rows - 2) + 1;
                    int col = rand.nextInt(cols - 2) + 1;

                    if (!buttons[row][col].getIcon().equals(forestIcon)) {
                        buttons[row][col].setIcon(forestIcon);
                        count++;
                    }
                }

                int centerRow = rows / 2;
                int centerCol = cols / 2;
                buttons[centerRow][centerCol].setIcon(townHallIcon);
            }
        }

        public void GameControl(){
        players.clear();

        for (int i = 0; i < numberOfPlayers; i++) {
            String name = JOptionPane.showInputDialog(this, "Enter name for Player " + (i + 1) + ":");
            if (name == null || name.trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a valid name!", "Error", JOptionPane.ERROR_MESSAGE);
                i--;
            } else {
                players.add(new Player(name));
            }
        }

        new Game(this, players);
    }



}
