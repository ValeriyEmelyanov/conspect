package class_loaders.simple_custom_class_loader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestProgram {
    public static void main(String[] args) throws ClassNotFoundException,
            IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        CustomClassLoader loader = new CustomClassLoader();
        Class<?> clazz = loader.findClass("class_loaders.simplecustomclassloader.CustomClass");
        Object obj = clazz.newInstance();
        Method method = clazz.getMethod("toString");
        System.out.println(method.invoke(obj));
        Method method2 = clazz.getMethod("greeting");
        System.out.println(method2.invoke(obj));
    }
}
