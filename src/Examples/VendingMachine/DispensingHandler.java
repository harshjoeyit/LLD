package Examples.VendingMachine;

public class DispensingHandler extends RequestHandler {
    @Override
    public void handleRequest(Request request) {
        System.out.println("Dispensing item: " + request.getSelectedItem());
        
        if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}
