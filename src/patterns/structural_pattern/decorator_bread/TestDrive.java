package patterns.structural_pattern.decorator_bread;

import patterns.structural_pattern.decorator_bread.components.Bagel;
import patterns.structural_pattern.decorator_bread.components.Bread;
import patterns.structural_pattern.decorator_bread.components.Bun;
import patterns.structural_pattern.decorator_bread.decoretors.Butter;
import patterns.structural_pattern.decorator_bread.decoretors.Cheese;
import patterns.structural_pattern.decorator_bread.decoretors.Ham;
import patterns.structural_pattern.decorator_bread.decoretors.Jam;

/**
 * Let`s decorate a slice of bread.
 */
public class TestDrive {
    public static void main(String[] args) {
        Bread bagel = new Cheese(new Ham(new Butter(new Bagel())));
        System.out.println(bagel);

        Bread bun = new Jam(new Butter(new Bun()));
        System.out.println(bun);
    }
}
