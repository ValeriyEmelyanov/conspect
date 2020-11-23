package io.cloning;

public class FldPoint {
    private int x;
    private int y;

    public FldPoint() {
    }

    public FldPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public FldPoint clone() {
        FldPoint clone = new FldPoint();
        clone.setX(x);
        clone.setY(y);
        return clone;
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
        return "PointFld{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
