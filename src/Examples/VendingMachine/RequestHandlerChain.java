package Examples.VendingMachine;

import java.util.Map;
import java.util.HashMap;

public class RequestHandlerChain {
    public static RequestHandler getRequestHandlerChain() {
        // Define item prices
        Map<Item, Integer> itemPrices = new HashMap<Item, Integer>();
        itemPrices.put(Item.COKE, 40);
        itemPrices.put(Item.WATER, 20);
        itemPrices.put(Item.CHIPS, 15);
        // todo: we should also keep the count of each item and 
        // update it successfull on processing request

        // Create the handlers
        InputValidationHandler inputHandler = new InputValidationHandler(itemPrices);
        DispensingHandler dispensingHandler = new DispensingHandler();
        ChangeReturnHandler changeReturnHandler = new ChangeReturnHandler(itemPrices);
        
        // Chain them
        inputHandler.setNext(dispensingHandler);
        dispensingHandler.setNext(changeReturnHandler);

        // The first handler in the chain
        return inputHandler;
    }
}
