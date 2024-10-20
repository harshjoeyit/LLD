package Examples.Logger;

public abstract class AbstractLogger implements Logger {
    Logger next;
    int logLevel;

    @Override
    public void log(int level, String message) {
        if (this.logLevel <= level) {
            write(message);
        }
        if (this.next != null) {
            next.log(level, message);
        }
    }

    @Override
    public void setNext(Logger logger) {
        this.next = logger;
    }

    // childrent class to implement this method
    abstract void write(String message);
}
