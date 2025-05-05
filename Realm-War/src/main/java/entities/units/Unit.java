package entities.units;
/**
 * کلاس پایه برای تمام واحدهای نظامی
 */
public abstract class Unit {
    protected int health;              // سلامت فعلی
    protected int movementRange;       // محدوده حرکت
    protected int attackPower;         // قدرت حمله
    protected Position position;       // موقعیت فعلی
}
