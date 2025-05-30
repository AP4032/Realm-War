package org.example.models.player;

import org.example.models.structures.Structures;
import org.example.models.structures.TownHall;
import org.example.models.units.Units;

public class Player {
    private String name;
    private TownHall townHall;
    private int gold;
    private int foodSupply;
    public Player(String name) {
        this.name = name;
        this.townHall = new TownHall();
        this.gold = 10;
        this.foodSupply = 10;
    }

    public String getName() {
        return name;
    }

    public boolean hasLost(){
        return townHall.getHealthPoints()==0;
    }

    public int getGold() {
        return gold;
    }

    public int getFoodSupply() {return foodSupply;}

    public boolean HaveMoneyToPay(Structures structure) {
        return getGold()-structure.getPrice()>0;
    }

    public boolean HaveMoneyToPay(Units unit) {
        return getGold()-unit.getPrice()>0;
    }
}
