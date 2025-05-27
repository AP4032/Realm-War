package model.structures;

import model.Kingdom;

public class Market extends Structures{
    private int goldPerTurn;

    public Market() {
        super(50, 5, 1, 3, 5, 5);
        this.goldPerTurn = 5;

    }

    public void produce_gold(Kingdom kingdom){
        int newGold = kingdom.getGold() + goldPerTurn;
    }

}
