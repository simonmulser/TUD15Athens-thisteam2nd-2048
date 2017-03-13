package com.thisteam2nd.game2048;

public class Rectangle {
    private int x;
    private int y;
    public final int side = 150;
    public final int arc = 10;

    public Rectangle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
