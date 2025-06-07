package org.realm_war.Models.structure.classes;


import org.realm_war.Models.Position;
import org.realm_war.Models.Realm;
import org.realm_war.Models.blocks.Block;
import org.realm_war.Models.units.Spearman;
import org.realm_war.Models.units.Unit;

public class Barrack extends Structure{
    private int turnsSinceLastProduction = 0;
    private static final int PRODUCTION_INTERVAL = 3;

    private static final int[] UNIT_SPACE_BY_LEVEL = {5, 8, 12};
    private static final int[] BUILDING_COST_BY_LEVEL = {5, 10, 15};
    private static final int[] DURABILITY_BY_LEVEL = {50, 75, 100};
    
    private int unitSpace;

    public Barrack(Position position, Block baseBlock, int kingdomId) {
        super(3, DURABILITY_BY_LEVEL[0], 5,  position, baseBlock, kingdomId);
        this.unitSpace = UNIT_SPACE_BY_LEVEL[0];
    }


    @Override
    public boolean canLevelUp() {
        return (getMaxLevel() > getLevel());
    }

    @Override
    public void levelUp() {
        if (!canLevelUp()){
            throw new IllegalStateException("Barrack is already at max Level");
        }
        setLevel(getLevel()+1);
        setDurability(DURABILITY_BY_LEVEL[getLevel()-1]);
        this.unitSpace = UNIT_SPACE_BY_LEVEL[getLevel()-1];
    }

    public boolean canProduceUnitThisTurn(){
        return turnsSinceLastProduction >= PRODUCTION_INTERVAL;
    }

    private Unit produceUnit() {
        turnsSinceLastProduction = 0;

        // You may want to generalize this to support different unit types
        Position spawnPosition = this.getPosition(); // could improve to find nearby valid tile
        int kingdomId = getKingdomId(); // or from Realm if needed

        return new Spearman(spawnPosition, kingdomId);
    }


    @Override
    public void performTurnAction(Realm realm) {
        if (canProduceUnitThisTurn()) {
            Unit newUnit = produceUnit();
            realm.addUnit(newUnit);
        }
        turnsSinceLastProduction++;
    }
}
