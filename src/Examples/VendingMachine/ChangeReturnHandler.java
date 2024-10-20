package Examples.VendingMachine;

import java.util.Map;

public class ChangeReturnHandler extends RequestHandler {
    // todo: we should also keep the count of each item and 
    // update it successfull on processing request
    private Map<Item, Integer> itemPrices;
    
    public ChangeReturnHandler(Map<Item, Integer> itemPrices) {
        this.itemPrices = itemPrices;
    }
    
    @Override
    public void handleRequest(Request request) {
        Item item = request.getSelectedItem();
        int price = itemPrices.get(item);
        int change = request.getInsertedAmount() - price;
        
        if (change > 0) {
            System.out.println("Returning change: " + change + " rupeers.");
        }
        
        if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}
