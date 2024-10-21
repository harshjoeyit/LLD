package DesignPatterns.StatePattern;

public class OutOfStockState implements VendingMachineState {

    @Override
    public void insertCoin(VendingMachine vendingMachine) {
        System.out.println("Machine is out of stock. Cannot accept coins.");
    }

    @Override
    public void dispenseItem(VendingMachine vendingMachine) {
        System.out.println("Machine is out of stock.");
    }
}
