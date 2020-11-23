package io.cloning;

public class ExtPoint implements Cloneable {
    private int x;
    private int y;
    private Group group;

    public ExtPoint() {
    }

    public ExtPoint(int x, int y, Group group) {
        this.x = x;
        this.y = y;
        this.group = group;
    }

    public ExtPoint clone() throws CloneNotSupportedException {
        ExtPoint clone = (ExtPoint) super.clone();
        clone.group = group.clone();
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

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "ExtPoint{" +
                "x=" + x +
                ", y=" + y +
                ", group=" + group +
                '}';
    }
}
