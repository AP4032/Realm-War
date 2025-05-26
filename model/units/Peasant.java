package model.units;

import units.Units;

public class Peasant extends Units {
    public Peasant() {
        super(10 , 4, 2, 2, 2, 3, 1);
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
