package DesignPatterns.StatePattern;

public class IdleState implements VendingMachineState {
    
    @Override
    public void insertCoin(VendingMachine vendingMachine) {
        System.out.println("Coin inserted. You can now dispense an item.");
        vendingMachine.setState(new DispensingState());
    }

    @Override
    public void dispenseItem(VendingMachine vendingMachine) {
        System.out.println("Please insert a coin first.");
    }
}
