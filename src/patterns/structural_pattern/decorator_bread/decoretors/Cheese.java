package patterns.structural_pattern.decorator_bread.decoretors;

import patterns.structural_pattern.decorator_bread.components.Bread;

public class Cheese extends Decorator {

    public Cheese(Bread bread) {
        this.bread = bread;
    }

    @Override
    public String getDescription() {
        return bread.getDescription() + ", Cheese";
    }

    @Override
    public int getKcal() {
        return bread.getKcal() + 40;
    }

}
