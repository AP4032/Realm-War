package entities.structures;
/**
 * کلاس پایه برای تمام سازه‌های بازی
 */
public abstract class Structure {
    protected int level;               // سطح فعلی سازه
    protected int maxLevel;            // حداکثر سطح قابل ارتقا
    protected int durability;          // استحکام فعلی
    protected int maintenanceCost;     // هزینه نگهداری
}
