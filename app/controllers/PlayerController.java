package controllers;

import models.Player;

public class PlayerController {
    private Player player;

    public PlayerController(Player player) {
        this.player = player;
    }

    public void updatePlayerInfo(String name, int score) {
        player.setName(name);
        player.setScore(score);
        // Additional logic for updating player information
    }

    public Player getPlayer() {
        return player;
    }
}
