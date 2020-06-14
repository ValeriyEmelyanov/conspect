package patterns.behavioral_patterns.templatemethod_meal_cooking;

public class Sandwich extends Meal {

    @Override
    public void prepareIngredients() {
        System.out.println("Ingredients: bacon, white bread, egg, cheese, mayonnaise, tomato");
    }

    @Override
    public void cook() {
        System.out.println("Paste ingredients between bread slices. Toast sandwich");
    }

    @Override
    public void cleanUp() {
        System.out.println("Lick fingers and go to sleep");
    }

}
