package Examples.VendingMachine;

public class Main {
    public static void main() {
        VendingMachine vendingMachine = new VendingMachine();

        vendingMachine.processRequest(Item.COKE, 100);
    }
}
