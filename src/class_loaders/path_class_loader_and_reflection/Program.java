package class_loaders.path_class_loader_and_reflection;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Осваиваем ClassLoader и Reflection
 *
 * (Очень компактный загрузчик классов)
 *
 * Аргументом для класса Solution является абсолютный путь к пакету.
 * Имя пакета может содержать File.separator.
 * В этом пакете кроме скомпилированных классов (.class) могут находиться и другие файлы (например: .java).
 * Известно, что каждый класс имеет конструктор без параметров и реализует интерфейс HiddenClass.
 * Считай все классы с файловой системы, создай фабрику - реализуй метод getHiddenClassObjectByKey.
 * Примечание: в пакете может быть только один класс, простое имя которого начинается с String key без учета регистра.
 */

public class Program {
    private List<Class> hiddenClasses = new ArrayList<>();
    private String packageName;

    public Program(String packageName) {
        this.packageName = packageName;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Program solution = new Program(Program.class.getProtectionDomain().getCodeSource().getLocation().getPath()
                + "class_loaders/path_class_loader_and_reflection/data/second");
        solution.scanFileSystem();
        System.out.println(solution.getHiddenClassObjectByKey("secondhiddenclassimpl"));
        System.out.println(solution.getHiddenClassObjectByKey("firsthiddenclassimpl"));
        System.out.println(solution.getHiddenClassObjectByKey("packa"));
    }

    public void scanFileSystem() throws ClassNotFoundException {
        String sep = System.getProperty("file.separator");
        String pathName = packageName;
        if(!(packageName.endsWith(sep))){
            pathName = pathName.concat(sep);
        }

        File[] files = new File[0];
        try {
            files = new File(URLDecoder.decode(packageName, "UTF-8")).listFiles();
        } catch (UnsupportedEncodingException ignored) {
        }

        PathClassLoader classLoader = new PathClassLoader();

        for (File file : files) {
            if (file.isFile() && file.getName().toLowerCase().endsWith(".class")) {
                Class clazz = classLoader.load(file.toPath());
                if (HiddenClass.class.isAssignableFrom(clazz)) {
                    hiddenClasses.add(clazz);
                }
            }
        }

    }

    public HiddenClass getHiddenClassObjectByKey(String key) {

        for (Class clazz : hiddenClasses) {
            if (clazz.getSimpleName().toLowerCase().startsWith(key.toLowerCase())) {
                try {
                    Constructor constructor = clazz.getDeclaredConstructor();
                    constructor.setAccessible(true);
                    return (HiddenClass) constructor.newInstance();
                } catch (NoSuchMethodException
                        | IllegalAccessException
                        | InstantiationException
                        | InvocationTargetException ignored) {
                }
            }
        }

        return null;
    }

    private class PathClassLoader extends ClassLoader {
        public Class<?> load(Path path) {
            try {
                byte[] bytes = Files.readAllBytes(path);
                return defineClass(null, bytes, 0, bytes.length);
            } catch (IOException ignored) {
            }
            return null;
        }
    }
}
