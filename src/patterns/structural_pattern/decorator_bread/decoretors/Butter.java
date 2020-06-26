package patterns.structural_pattern.decorator_bread.decoretors;

import patterns.structural_pattern.decorator_bread.components.Bread;

public class Butter extends Decorator {

    public Butter(Bread bread) {
        this.bread = bread;
    }

    @Override
    public String getDescription() {
        return bread.getDescription() + ", Butter";
    }

    @Override
    public int getKcal() {
        return bread.getKcal() + 50;
    }
}
