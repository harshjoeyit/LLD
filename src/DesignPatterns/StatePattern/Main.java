package DesignPatterns.StatePattern;

// Main class to run the vending machine example
public class Main {
    public static void main() {
        VendingMachine machine = new VendingMachine(1);  // Initially, the machine has 1 item in stock.

        machine.dispenseItem();   // No coin inserted, so cannot dispense item

        // Interact with the machine
        machine.insertCoin();   // Coin inserted. You can now dispense an item.
        machine.dispenseItem(); // Dispensing item... No more stock.
        
        machine.insertCoin();   // Machine is out of stock. Cannot accept coins.
    }
}
