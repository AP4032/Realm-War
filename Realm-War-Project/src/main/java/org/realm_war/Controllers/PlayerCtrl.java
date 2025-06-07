package org.realm_war.Controllers;

import org.realm_war.Models.Player;

public class PlayerCtrl {
    Player player;

    public PlayerCtrl(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public void updatePlayerInfo(int score) {
        player.setScore(score);

    }
}
