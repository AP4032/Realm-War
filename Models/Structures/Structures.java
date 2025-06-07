package Models.Structures;

public class Structures {
    private int structureHealth;
    private int goldProduction;
    private int foodProduction;
    private int structurelevel;
    private int structuremaxlevel;
    private int structureCost;
    private int unitSpace;

public Structures(int structureHealth, int goldProduction,int foodProduction, int structurelevel, int structuremaxlevel, int structureCost ,int unitSpace) {
    this.structureHealth = structureHealth;
    this.goldProduction = goldProduction;
    this.foodProduction = structurelevel;
    this.structurelevel = structurelevel;
    this.structuremaxlevel = structuremaxlevel;
    this.structureCost = structureCost;
    this.unitSpace = unitSpace;
}
    public int getStructureHealth() {
        return structureHealth;
    }

    public void setStructureHealth(int structureHealth) {
        this.structureHealth = structureHealth;
    }

    public int getGoldProduction() {
        return goldProduction;
    }

    public void setGoldProduction(int goldProduction) {
        this.goldProduction = goldProduction;
    }

    public int getStructurelevel() {
        return structurelevel;
    }

    public void setStructurelevel(int structurelevel) {
        this.structurelevel = structurelevel;
    }

    public int getStructuremaxlevel() {
        return structuremaxlevel;
    }

    public void setStructuremaxlevel(int structuremaxlevel) {
        this.structuremaxlevel = structuremaxlevel;
    }

    public int getFoodProduction() {
        return foodProduction;
    }

    public void setFoodProduction(int foodProduction) {
        this.foodProduction = foodProduction;
    }
}
