package core;

import java.util.List;

/**
 * مدیریت اصلی بازی و چرخه نوبت‌ها
 */
public class GameEngine {
    private List<Player> players;      // لیست بازیکنان
    private int currentPlayerIndex;    // نوبت بازیکن فعلی
    private boolean gameOver;          // وضعیت پایان بازی
}