package core;
import entities.blocks.Block;
import entities.structures.Structure;
import java.util.List;

/**
 * مدیریت قلمرو و سرزمین یک بازیکن
 */
public class Kingdom {
    private List<Block> territory;     // بلوک‌های تحت کنترل
    private List<Structure> structures;// سازه‌های ساخته شده
}