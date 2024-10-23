package Examples.PaymentGateway.Logger;

// his follows the Singleton Pattern
public class Logger {
    private static Logger loggerInstance;

    // private constructor
    private Logger() {}

    public static Logger getInstance() {
        if (loggerInstance == null) {
            loggerInstance = new Logger();
        }

        return loggerInstance;
    }

    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}
