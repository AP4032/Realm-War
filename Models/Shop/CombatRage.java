package Models.Shop;

import Models.Units.Units;

public class CombatRage extends Shop {
    Units units = new Units();
    public void damageIncrease() {
        units.setAttackPower(units.getAttackPower() * 2);
    }
}
