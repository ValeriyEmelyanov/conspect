package patterns.behavioral_patterns.chain_of_responsibility;

/**
 * Цепочка обязанностей (англ. Chain of responsibility) — поведенческий шаблон проектирования,
 * предназначенный для организации в системе уровней ответственности.
 */
public class ChainOfResponsibilityExample {
    public static void main(String[] args) {
        // Build the chain of responsibility
        Logger logger  = new StdoutLogger(Logger.DEBUG);
        Logger logger1 = logger.setNext(new EmailLogger(Logger.NOTICE));
        Logger logger2 = logger1.setNext(new StderrLogger(Logger.ERR));

        // Handled by StdoutLogger
        logger.message("Entering function y.", Logger.DEBUG);
        System.out.println();

        // Handled by StdoutLogger and EmailLogger
        logger.message("Step1 completed.", Logger.NOTICE);
        System.out.println();

        // Handled by all three loggers
        logger.message("An error has occurred.", Logger.ERR);
    }
}
