/**
 *  "The JAXB APIs are considered to be Java EE APIs
 *  and therefore are no longer contained on the default classpath in Java SE 9.
 *  In Java 11, they are completely removed from the JDK."
 *
 * Если у вас Intellij IDEA (Community), то необходимые библиотеки есть в комплекте.
 * Найти их можно по следующему адресу: папка с IDEA -> lib
 * В данном случае нужны:
 * 1. jaxb-api
 * 2. jaxb-runtime
 * 3. javax.activation
 *
 * Добавление в ваш проект:
 * File->Project Structure
 * Modules->Dependencies
 * потом клацаем полюсик и добавляем файлы
 *
 * Вот, если у вас JAXB не часть JDK, и вы пользуетесь Maven, можно записать в pom файл такие зависимости:
 * <dependency>
 *     <groupId>com.sun.xml.bind</groupId>
 *     <artifactId>jaxb-core</artifactId>
 *     <version>2.3.0.1</version>
 * </dependency>
 * <dependency>
 *     <groupId>javax.xml.bind</groupId>
 *     <artifactId>jaxb-api</artifactId>
 *     <version>2.3.1</version>
 * </dependency>
 * <dependency>
 *     <groupId>com.sun.xml.bind</groupId>
 *     <artifactId>jaxb-impl</artifactId>
 *     <version>2.3.1</version>
 * </dependency>
 * <dependency>
 *     <groupId>org.javassist</groupId>
 *     <artifactId>javassist</artifactId>
 *     <version>3.25.0-GA</version>
 * </dependency>
 */
