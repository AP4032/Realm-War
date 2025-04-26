package game.core;

import java.util.ArrayList;
import java.util.List;

public class GameManager {

    private List<Player> players;
    private int currentPlayerIndex;
    private boolean gameOver;

    public GameManager(List<Player> players) {
        this.players = new ArrayList<>(players);
        this.currentPlayerIndex = 0;
        this.gameOver = false;
    }

    public Player getCurrentPlayer() {
        return players.get(currentPlayerIndex);
    }

    public void startGame() {
        if (!players.isEmpty()) {
            players.get(currentPlayerIndex).startTurn();
        }
    }

    public void endTurn() {
        players.get(currentPlayerIndex).endTurn();
        checkForDefeat();
        if (!gameOver) {
            moveToNextPlayer();
        }
    }

    private void moveToNextPlayer() {
        do {
            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        } while (players.get(currentPlayerIndex).hasLost());
        players.get(currentPlayerIndex).startTurn();
    }

    private void checkForDefeat() {
        List<Player> defeatedPlayers = new ArrayList<>();
        for (Player player : players) {
            if (player.hasLost()) {
                defeatedPlayers.add(player);
            }
        }
        players.removeAll(defeatedPlayers);

        if (players.size() == 1) {
            gameOver = true;
            System.out.println("🏆 " + players.get(0).getName() + " has won the game!");
        } else if (players.isEmpty()) {
            gameOver = true;
            System.out.println("🤯 All players lost! No one wins!");
        }
    }

    public boolean isGameOver() {
        return gameOver;
    }
}
