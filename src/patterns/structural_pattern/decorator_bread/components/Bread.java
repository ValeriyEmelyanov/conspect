package patterns.structural_pattern.decorator_bread.components;

public abstract class Bread {
    protected String description;
    protected int kcal;

    public String getDescription() {
        return description;
    }

    public int getKcal() {
        return kcal;
    }

    @Override
    public String toString() {
        return getDescription() + ". kCal: " + getKcal();
    }
}
