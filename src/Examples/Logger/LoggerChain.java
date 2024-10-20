package Examples.Logger;

// Class to configure the chain of responsibilty
public class LoggerChain {

    public static Logger getLoggerChain() {
        // Creating loggers
        Logger infoLogger = new InfoLogger(Logger.INFO);
        Logger debugLogger = new DebugLogger(Logger.DEBUG);
        Logger errorLogger = new ErrorLogger(Logger.ERROR);

        // Setting up chain
        infoLogger.setNext(debugLogger);
        debugLogger.setNext(errorLogger);

        return infoLogger;
    }
}
