package org.realm_war.Models;

public class Position {
    private int x;
    private int y;
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distanceTo(Position other) {
        int dx = this.getX() - other.getX();
        int dy = this.getY() - other.getY();
        return Math.max(Math.abs(dx), Math.abs(dy));
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
}
