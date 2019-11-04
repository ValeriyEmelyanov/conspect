package class_loaders.simple_custom_class_loader;

public class CustomClass {
    @Override
    public String toString() {
        return "Custom class: " + super.toString();
    }

    public String greeting() {
        return "Hi form custom class!";
    }
}
