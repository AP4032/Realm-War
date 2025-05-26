package model.units;

import units.Units;

public class SpearMan extends Units {
    public SpearMan(){
        super(20,4, 3, 3, 3, 4, 1);
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
