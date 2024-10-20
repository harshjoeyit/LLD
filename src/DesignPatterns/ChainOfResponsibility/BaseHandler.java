package DesignPatterns.ChainOfResponsibility;

public class BaseHandler implements Handler {
    Handler next;

    @Override
    public void setNext(Handler handler) {
        this.next = handler;
    }

    @Override
    public void handleRequest(String request) {
        if (next != null) {
            next.handleRequest(request);
        }
    }
}
