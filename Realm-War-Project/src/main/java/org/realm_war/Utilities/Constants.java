package org.realm_war.Utilities;

import java.awt.*;

public class Constants {
    private static final int mapSize = 20;

    public static final Color clr_1 = new Color(59,53,37);
    public static final Color clr_2 = new Color(201,196,190);
    public static final Color clr_3 = new Color(207,204,204);

    public static int getMapSize(){
        return mapSize;
    }

    public static Font setBoldFont(int fontSize){
        return new Font("Arial", Font.BOLD, fontSize);
    }
    public static Font setRegularFont(int fontSize){
        return new Font("Arial", Font.PLAIN, fontSize);
    }
}
