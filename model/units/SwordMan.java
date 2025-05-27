package model.units;

import model.Kingdom;
import model.structures.Structures;

public class SwordMan extends Units {

    public SwordMan(){
        super(30,4, 4, 4, 4, 5, 1);
    }

    @Override
    public void attack(Units target){
        int hP = target.getHitPoint() - this.getAttackPower();
        if( hP < 0) {
            hP = 0;
            new Kingdom().deleteUnit(target);
        }
        target.setHitPoint(hP);
    }

    @Override
    public void structAttack(Structures target){
        int newDurability = target.getDurability() - this.getAttackPower();
        if( newDurability < 0 ){
            newDurability = 0;
            new Kingdom().deleteStructure(target);
        }
        target.setDurability(newDurability);
    }
}
