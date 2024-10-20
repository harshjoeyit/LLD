package Examples.Logger;

public class DebugLogger extends AbstractLogger {

    public DebugLogger(int level) {
        this.logLevel = level;
    }

    @Override
    public void write(String message) {
        System.out.println("DEBUG: " + message);
    }
}
