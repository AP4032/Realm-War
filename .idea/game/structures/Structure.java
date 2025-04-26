package game.structures;

import game.core.Attackable;
import game.core.Upgradable;

public abstract class Structure implements Attackable, Upgradable {
    protected int durability;
    protected int maintenanceCost;
    protected int level;
    protected int maxLevel;

    public Structure(int durability, int maintenanceCost, int maxLevel) {
        this.durability = durability;
        this.maintenanceCost = maintenanceCost;
        this.maxLevel = maxLevel;
        this.level = 1;
    }

    public int getDurability() {
        return durability;
    }

    public int getMaintenanceCost() {
        return maintenanceCost;
    }

    public int getLevel() {
        return level;
    }

    public boolean isDestroyed() {
        return durability <= 0;
    }

    @Override
    public void receiveDamage(int damage) {
        durability -= damage;
    }

    @Override
    public void upgrade() {
        if (level < maxLevel) {
            level++;
            durability += 10;
        }
    }
}
