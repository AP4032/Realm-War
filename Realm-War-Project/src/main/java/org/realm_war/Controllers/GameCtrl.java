package org.realm_war.Controllers;

import org.realm_war.Models.GameState;

public class GameCtrl {
    GameState gameState;

    public void startGame(){
        gameState.setRunning(true);
    }

    public void stopGame(){
        gameState.setRunning(false);
    }

    public GameState getGameState() {
        return gameState;
    }
}
