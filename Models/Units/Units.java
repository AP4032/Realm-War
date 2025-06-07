package Models.Units;

public class Units {
    private int unitHealth;
    private int movementRange;
    private int attackPower;
    private int attackRange;
    private int unitCost;
    private int food;
    private int space;
    private int playerNum;
    public Units(int unitHealth,int movementRange,int attackPower,int attackRange,int unitCost,int food,int space,int playerNum) {
        this.unitHealth = unitHealth;
        this.movementRange = movementRange;
        this.attackRange= attackRange;
        this.unitCost = unitCost;
        this.food = food;
        this.space = space;
        this.playerNum = playerNum;
    }
    public int getUnitHealth() {
        return unitHealth;
    }

    public void setUnitHealth(int unitHealth) {
        this.unitHealth = unitHealth;
    }

    public int getMovementRange() {
        return movementRange;
    }

    public void setMovementRange(int movementRange) {
        this.movementRange = movementRange;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public int getAttackRange() {
        return attackRange;
    }

    public void setAttackRange(int attackrange) {
        attackRange = attackrange;
    }

    public int getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(int unitCost) {
        this.unitCost = unitCost;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public int getSpace() {
        return space;
    }

    public void setSpace(int space) {
        this.space = space;
    }
}
