package org.example.models.structures;

public abstract class Structures {
    int healthPoints;
    int level;
    int maintenanceCost;
    int price;

    public Structures(){
        this.healthPoints = 50;
        this.level = 1;
        this.maintenanceCost = 5;
        this.price = 10;
    }

    public void levelUp(){
        level++;
    }

    public void loseHealthPoints(){
        healthPoints -= 10;
    }

    public int getHealthPoints(){ return healthPoints; }

    public int getMaintenanceCost(){ return maintenanceCost; }

    public int getPrice(){ return price; }
}
