package patterns.structural_pattern.decorator_bread.decoretors;

import patterns.structural_pattern.decorator_bread.components.Bread;

public class Ham extends Decorator {

    public Ham(Bread bread) {
        this.bread = bread;
    }

    @Override
    public String getDescription() {
        return bread.getDescription() + ", Ham";
    }

    @Override
    public int getKcal() {
        return bread.getKcal() + 2500;
    }

}
