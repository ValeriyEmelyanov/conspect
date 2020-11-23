package io.cloning;

import java.io.Serializable;

public class SerializablePoint implements Serializable {
    private int x;
    private int y;

    public SerializablePoint(int x, int y) {
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

    @Override
    public String toString() {
        return "SerializablePoint{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
