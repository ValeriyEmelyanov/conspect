package io.cloning;

public class Group implements Cloneable {
    private int id;

    public Group() {
    }

    public Group(int id) {
        this.id = id;
    }

    public Group clone() throws CloneNotSupportedException {
        return (Group) super.clone();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                '}';
    }
}
