package Examples.Logger;

public interface Logger {
    int INFO = 1;
    int DEBUG = 2;
    int ERROR = 3;

    // log handles incoming log request
    public void log(int level, String message);
    
    // setNext sets the next logger in chain
    public void setNext(Logger logger);
}
