public abstract class Structures {
    protected int helth;
    protected int maintainace_cost;
    protected int level;
    protected int maxlevel;


    public Structures(int helth, int maintainace_cost, int level, int maxlevel) {
        this.helth = helth;
        this.maintainace_cost = maintainace_cost;
        this.level = level;
        this.maxlevel = maxlevel;
    }

    public abstract void upgrade();


    public int getLevel() {
        return level;
    }

    public int getHelth() {
        return helth;
    }

    public int getMaintainace_cost() {
        return maintainace_cost;
    }

    public int getMaxlevel() {
        return maxlevel;
    }



}
