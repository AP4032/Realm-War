package org.realm_war.Utilities;

public class HelperMethods {
    private static int ID = 1000;

    public static int idGenerator() {
        ID += 1;
        return ID;
    }

}