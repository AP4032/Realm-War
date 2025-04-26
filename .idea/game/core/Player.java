package game.Core;

public class Player {

    private String name;
    private Kingdom kingdom;
    private boolean isTurn;

    public Player(String name) {
        this.name = name;
        this.kingdom = new Kingdom();
        this.isTurn = false;
    }

    public String getName() {
        return name;
    }

    public Kingdom getKingdom() {
        return kingdom;
    }

    public boolean isTurn() {
        return isTurn;
    }

    public void startTurn() {
        isTurn = true;
        kingdom.generateResources();
        kingdom.payMaintenance();
    }

    public void endTurn() {
        isTurn = false;
    }

    public boolean hasLost() {
        return !kingdom.hasTownHall();
    }
}
