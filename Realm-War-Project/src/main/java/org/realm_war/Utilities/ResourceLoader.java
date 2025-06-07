package org.realm_war.Utilities;

import javax.imageio.ImageIO;
import java.awt.Image;
import java.io.*;
import java.util.*;

public class ResourceLoader {

    private static final Map<String, Image> imageCache = new HashMap<>();

    private static final String BASE_PATH = "src/main/java/org/realm_war/Utilities/assets/";

    public Image loadImage(String filename) {
        if (imageCache.containsKey(filename)) {
            return imageCache.get(filename);
        }

        File file = new File(BASE_PATH + filename);
        if (!file.exists()) {
            System.err.println("Image not found: " + file.getPath());
            return null;
        }

        try {
            Image img = ImageIO.read(file);
            imageCache.put(filename, img);
            return img;
        } catch (IOException e) {
            System.err.println("Failed to read image: " + file.getPath());
            e.printStackTrace();
            return null;
        }
    }

    public void clearCache() {
        imageCache.clear();
    }
}
