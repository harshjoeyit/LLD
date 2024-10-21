package DesignPatterns.StatePattern;

public class DispensingState implements VendingMachineState {

    @Override
    public void insertCoin(VendingMachine vendingMachine) {
        System.out.println("Already have a coin. Dispensing item...");
    }

    @Override
    public void dispenseItem(VendingMachine vendingMachine) {
        System.out.println("Dispensing item...");
        vendingMachine.decrementStock();
        
        if (vendingMachine.getStock() > 0) {
            vendingMachine.setState(new IdleState());
        } else {
            vendingMachine.setState(new OutOfStockState());
        }
    }
}
