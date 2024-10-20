package Examples.VendingMachine;

public class VendingMachine {
    RequestHandler requestHandler;

    VendingMachine() {
        this.requestHandler = RequestHandlerChain.getRequestHandlerChain();
    }

    public void processRequest(Item item, int amount) {
        // create a new request with the parameters
        Request request = new Request(item, amount);
        // invoke handler
        requestHandler.handleRequest(request);
    }
}
