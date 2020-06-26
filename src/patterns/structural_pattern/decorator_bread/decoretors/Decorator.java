package patterns.structural_pattern.decorator_bread.decoretors;

import patterns.structural_pattern.decorator_bread.components.Bread;

public abstract class Decorator extends Bread {
    protected Bread bread;
    public abstract String getDescription();
    public abstract int getKcal();
}
