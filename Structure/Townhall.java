public class Townhall extends Structures {
    private final int goldProduction;
    private final int foodProduction;
    private final int unitSpace;



    public Townhall() {
        super(50, 0, 1, 1); // Fixed values
        this.goldProduction = 5;
        this.foodProduction = 5;
        this.unitSpace = 5;
    }

    @Override
    public void upgrade() {
        // TownHall can't be upgraded
    }

    public boolean destroy(){
        if(helth==0) {
            return true;
        }
        return false;
    }


    public int getGoldProduction() {
        return goldProduction;
    }

    public int getFoodProduction() {
        return foodProduction;
    }

    public int getUnitSpace() {
        return unitSpace;
    }
}
