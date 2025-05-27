package model;


public class Player {
    private Kingdom kingdom;
    private boolean isTurn;
    private boolean isGameOver;

    public Player(Kingdom kingdom) {
        this.kingdom = kingdom;
    }


    public Kingdom getKingdom() {
        return kingdom;
    }


}
