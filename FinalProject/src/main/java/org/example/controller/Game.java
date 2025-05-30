package org.example.controller;

import org.example.models.player.Player;
import org.example.swing.GUI;

import java.util.ArrayList;

public class Game {
    private GUI gui;
    private ArrayList<Player> players;
    private int currentPlayerIndex;

    public Game(GUI gui, ArrayList<Player> players) {
        this.gui = gui;
        this.players = players;
        this.currentPlayerIndex = 0;
        nextTurn();
    }

    public void nextTurn() {
        if (players.isEmpty()) return;

        Player currentPlayer = players.get(currentPlayerIndex);

        if (currentPlayer.hasLost()) {
            players.remove(currentPlayerIndex);
            if (players.isEmpty()) return;
        } else {
            gui.ShowGameBoardWindow(currentPlayer);
        }

        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }
}
