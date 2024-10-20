package Examples.VendingMachine;

public abstract class RequestHandler {
    protected RequestHandler nextHandler;
    
    public void setNext(RequestHandler handler) {
        this.nextHandler = handler;
    }

    public abstract void handleRequest(Request request);
}
