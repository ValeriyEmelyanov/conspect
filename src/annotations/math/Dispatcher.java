package annotations.math;

import java.lang.reflect.Method;

public class Dispatcher {
    public static void main(String[] args) {
        MathHandler handler = new MathHandler();
        Class<?> clazz = MathHandler.class;
        try {
            Method method = clazz.getDeclaredMethod("addTwoNumbers", int.class, int.class);
            MathSum mathSum = method.getAnnotation(MathSum.class);
            handler.addTwoNumbers(mathSum.num1(), mathSum.num2());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
