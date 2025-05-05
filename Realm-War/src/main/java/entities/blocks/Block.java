/**
 * کلاس پایه برای تمام انواع بلوک‌های بازی
 */
public abstract class Block {
    protected Position position;       // موقعیت در نقشه
    protected BlockType type;          // نوع بلوک
    protected boolean isAbsorbed;      // وضعیت تصرف توسط بازیکن
}