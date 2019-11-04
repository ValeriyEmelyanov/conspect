package class_loaders.simple_custom_class_loader;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Simple custom class loader implementation
 */
public class CustomClassLoader extends ClassLoader {
    // The map where the classes will be cashed
    private Map<String, Class<?>> classes = new HashMap<>();

    @Override
    public String toString() {
        return CustomClassLoader.class.getName();
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        if (classes.containsKey(name)) {
            return classes.get(name);
        }

        byte[] classData;

        try {
            classData = loadClassData(name);
        } catch (IOException e) {
            throw new ClassNotFoundException("Class [" + name + "] could not be found", e);
        }

        Class<?> clazz = defineClass(name, classData, 0, classData.length);
        resolveClass(clazz);
        classes.put(name, clazz);

        return clazz;
    }

    /**
     * Load the class file into byte array
     */
    private byte[] loadClassData(String name) throws IOException {
        BufferedInputStream in = new BufferedInputStream(
                ClassLoader.getSystemResourceAsStream(name.replace(".", "/") + ".class"));
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        int b;
        while ((b = in.read()) != -1) {
            out.write(b);
        }

        in.close();
        byte[] classData = out.toByteArray();
        out.close();

        return classData;
    }
}
