package Examples.Logger;

public class ErrorLogger extends AbstractLogger {

    public ErrorLogger(int level) {
        this.logLevel = level;
    }

    @Override
    public void write(String message) {
        System.out.println("ERROR: " + message);
    }
}
