package Unit;

public interface UnitProperties {
    Unit merge ( Unit other );
    boolean canMerge ( Unit other );
    boolean canAttack ( Unit target );
    void dealDamage( int damage );
    void heal( int damage );
    boolean isAlive();
}
