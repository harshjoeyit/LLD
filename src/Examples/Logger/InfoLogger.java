package Examples.Logger;

public class InfoLogger extends AbstractLogger { 

    public InfoLogger(int level) {
        this.logLevel = level;
    }

    @Override
    public void write(String message) {
        System.out.println("INFO: " + message);
    }
}
