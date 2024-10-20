package Examples.VendingMachine;

import java.util.Map;

public class InputValidationHandler extends RequestHandler {
    private Map<Item, Integer> itemPrices; // e.g., {"Coke": 100, "Chips": 50}
    
    public InputValidationHandler(Map<Item, Integer> itemPrices) {
        this.itemPrices = itemPrices;
    }
    
    @Override
    public void handleRequest(Request request) {
        Item item = request.getSelectedItem();
        int price = itemPrices.getOrDefault(item, -1);
        
        if (price == -1) {
            System.out.println("Invalid item selected.");
            return;
        }
        
        if (request.getInsertedAmount() < price) {
            System.out.println("Insufficient funds.");
            return;
        }

        if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}
