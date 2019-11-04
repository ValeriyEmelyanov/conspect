package patterns.behavioral_patterns.chain_of_responsibility_rush;

/**
 * https://javarush.ru/tasks/com.javarush.task.task29.task2912
 * Есть программа, в которой реализована система логирования по принципу:
 * - если событие уровня FATAL - происходит звонок директору, отправляется СМС-сообщение CEO,
 *   выводится сообщение в консоль, происходит логирование в файл;
 * - если событие уровня ERROR - отправляется СМС-сообщение CEO,
 *   выводится сообщение в консоль, происходит логирование в файл;
 * - если событие уровня WARN - выводится сообщение в консоль, происходит логирование в файл;
 * - если событие уровня INFO - происходит логирование в файл.
 */
public class Program {
    public static void main(String[] args) {
        Logger logger3 = new PhoneLogger(Level.FATAL);
        Logger logger2 = new SmsLogger(Level.ERROR);
        Logger logger1 = new ConsoleLogger(Level.WARN);
        Logger logger0  = new FileLogger(Level.INFO);

        logger2.setNext(logger3);
        logger1.setNext(logger2);
        logger0.setNext(logger1);

        logger3.inform("Everything is OK", Level.INFO);
        logger3.inform("We found a bug", Level.WARN);
        logger3.inform("Database connection error", Level.ERROR);
        logger3.inform("System shut down", Level.FATAL);

        System.out.println("*");
        logger0.inform("Everything is OK", Level.INFO);

        System.out.println("**");
        logger0.inform("We found a bug", Level.WARN);

        System.out.println("***");
        logger0.inform("Database connection error", Level.ERROR);

        System.out.println("****");
        logger0.inform("System shut down", Level.FATAL);
    }
}
