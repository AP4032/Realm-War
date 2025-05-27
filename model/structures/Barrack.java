package model.structures;

import model.Kingdom;

public class Barrack extends Structures{
    private int UNIT_SPACE;

    public Barrack(){
        super(50, 5, 1, 3, 5, 5);
        this.UNIT_SPACE = 5;

    }


   public void createUnit(Kingdom kingdom, Unit unit){
        kingdom.addUnit(unit);
    }


}
