package Examples.Logger;

public class Main {
    public static void main() {
        // Get the logger chain
        Logger loggerChain = LoggerChain.getLoggerChain();

        // Log messages with different severity
        System.out.println("Logging an INFO level message:");
        loggerChain.log(Logger.INFO, "This is an informational message.");

        System.out.println("\nLogging a DEBUG level message:");
        loggerChain.log(Logger.DEBUG, "This is a debug level message.");

        System.out.println("\nLogging an ERROR level message:");
        loggerChain.log(Logger.ERROR, "This is an error message.");

        // Todo: Set default log level
        // When - 
        // Log level = INFO, only INFO messages
        // Log level = DEBUG, INFO and DEBUG messages
        // Log level = ERROR, INFO, DEBUG and ERROR messages
    }
}
