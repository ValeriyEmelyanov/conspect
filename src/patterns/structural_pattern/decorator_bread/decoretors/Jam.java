package patterns.structural_pattern.decorator_bread.decoretors;

import patterns.structural_pattern.decorator_bread.components.Bread;

public class Jam extends Decorator {

    public Jam(Bread bread) {
        this.bread = bread;
    }

    @Override
    public String getDescription() {
        return bread.getDescription() + ", Jam";
    }

    @Override
    public int getKcal() {
        return bread.getKcal() + 120;
    }

}
