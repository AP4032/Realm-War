package controllers;

import models.GameState;

public class GameController {
    private GameState gameState;

    public GameController(GameState gameState) {
        this.gameState = gameState;
    }

    public void startGame() {
        gameState.setRunning(true);
        // Additional logic for starting the game
    }

    public void stopGame() {
        gameState.setRunning(false);
        // Additional logic for stopping the game
    }

    public GameState getGameState() {
        return gameState;
    }
}
