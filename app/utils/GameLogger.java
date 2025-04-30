package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GameLogger {
    private static final String LOG_FILE = "game_log.txt";
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    
    public static void log(String message) {
        String logEntry = "[" + dtf.format(LocalDateTime.now()) + "] " + message + "\n";
        System.out.print(logEntry);
        
        try {
            Files.write(Paths.get(LOG_FILE), logEntry.getBytes(), 
                StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.err.println("Failed to write to log file: " + e.getMessage());
        }
    }
    
    public static void logError(String message, Exception e) {
        log("ERROR: " + message + " - " + e.getMessage());
    }
}