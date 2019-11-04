package patterns.behavioral_patterns.chain_of_responsibility_rush;

public class Level {
    public static final int INFO = 100;     // FileLogger
    public static final int WARN = 200;     // ConsoleLogger
    public static final int ERROR = 300;    // SmsLogger
    public static final int FATAL = 400;    // PhoneLogger
}
