package model.units;

import model.structures.Structures;

public class Knight extends Units {

    public Knight(){
        super(40,4, 5, 5, 5, 6, 1);
    }

    @Override
    public void attack(Units target){
        int hP = target.getHitPoint() - this.getAttackPower();
        if( hP < 0) {
            hP = 0;
        }
        target.setHitPoint(hP);
    }

    @Override
    public void structAttack(Structures target){
        int newDurability = target.getDurability() - this.getAttackPower();
        if( newDurability < 0 ){
            newDurability = 0;
        }
        target.setDurability(newDurability);
    }
}
