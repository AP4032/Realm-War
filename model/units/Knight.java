package model.units;

import units.Units;

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
}
