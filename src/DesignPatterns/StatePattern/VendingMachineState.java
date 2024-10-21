package DesignPatterns.StatePattern;


// VendingMachineState specifies all the behaviours of Vending Machine
// 
// The concrete implementation will implement each method 
// to specify the behaviour in each state
public interface VendingMachineState {
    void insertCoin(VendingMachine vendingMachine);
    void dispenseItem(VendingMachine vendingMachine);
}
