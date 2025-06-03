import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;


public abstract class Unit {
    private int health;
    private double movementRange;
    private double attackPower;
    private double attackRange;
    private int payment;
    private int foodBalance;
    private int unitSpace;
    public enum Degree {
        PEASANT, SPEARMAN, SWORDMAN, KNIGHT
    }
    private static Map<Degree, Integer> numberOfUnits = new HashMap<>();
    static {
        for (Degree degree : Degree.values()) {
            numberOfUnits.put(degree, 0);
        }
    }

    //constructor :
    public Unit(Degree degree,int health, double movementRange, double attackPower, double attackRange, int payment, int foodBalance, int unitSpace){
        this.health = health;
        this.movementRange = movementRange;
        this.attackPower = attackPower;
        this.attackRange = attackRange;
        this.payment = payment;
        this.foodBalance = foodBalance;
        this.unitSpace = unitSpace;
        this.numberOfUnits.put(degree, numberOfUnits.get(degree) + 1);
    }
    public abstract void attack();
    public abstract void move();
    public abstract void defend();

    public int getHealth() {
        return health;
    }
    public double getMovementRange() {
        return movementRange;
    }
    public double getAttackPower() {
        return attackPower;
    }
    public double getAttackRange() {
        return attackRange;
    }
    public int getPayment() {
        return payment;
    }
    public int getFoodBalance() {
        return foodBalance;
    }
    public int getUnitSpace() {
        return unitSpace;
    }

    public void CombiningTwoForces(Degree fristDegree,Degree secondDegree){
        if (numberOfUnits.get(fristDegree)>=2){
            numberOfUnits.put(fristDegree, numberOfUnits.get(fristDegree) - 2);
            numberOfUnits.put(secondDegree, numberOfUnits.get(secondDegree) +1);
        }
        else{
            System.out.println("you need at least two "+ fristDegree+ " units to create a "+secondDegree );
        }
    }
}
class Peasant extends Unit {

    public Peasant(Degree degree, int health, double movementRange, double attackPower, double attackRange, int payment, int foodBalance, int unitSpace) {
        super(degree, health, movementRange, attackPower, attackRange, payment, foodBalance, unitSpace);
    }
    @Override
    public void attack() {
    }
    @Override
    public void move() {
    }
    @Override
    public void defend() {
    }
}
class Swordman extends Unit {
    public Swordman(Degree degree, int health, double movementRange, double attackPower, double attackRange, int payment, int foodBalance, int unitSpace) {
        super(degree, health, movementRange, attackPower, attackRange, payment, foodBalance, unitSpace);
    }
    @Override
    public void attack() {
    }
    @Override
    public void move() {
    }
    @Override
    public void defend() {
    }
}
class Spearman extends Unit {
    public Spearman(Degree degree, int health, double movementRange, double attackPower, double attackRange, int payment, int foodBalance, int unitSpace) {
        super(degree, health, movementRange, attackPower, attackRange, payment, foodBalance, unitSpace);
    }
    @Override
    public void attack() {
    }
    @Override
    public void move() {
    }
    @Override
    public void defend() {
    }
}
class Knight extends Unit {
    public Knight(Degree degree, int health, double movementRange, double attackPower, double attackRange, int payment, int foodBalance, int unitSpace) {
        super(degree, health, movementRange, attackPower, attackRange, payment, foodBalance, unitSpace);
    }
    @Override
    public void attack() {
    }
    @Override
    public void move() {
    }
    @Override
    public void defend() {
    }
}