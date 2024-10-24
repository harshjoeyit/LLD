package Examples.PaymentGateway2.Logger;

// This class follows the Singleton Pattern
public class Logger {
    private static Logger instance;
    private static final Object lock = new Object();

    private Logger() {}

    // double check lock
    public static Logger getInstance() {
        if (instance == null) {             // 1. check
            synchronized (Logger.class) {
                if (instance == null) {     // 2. check
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    public void log(String message) {
        // Ensure thread-safe logging
        // There can be cases where a thread starts to print a log but is paused midway
        // This would lead to incomplete and unformatted logs.
        // synchronized ensures that this doesn't happen
        synchronized (lock) {
            System.out.println("[LOG] " + message);
        }
    }
}
