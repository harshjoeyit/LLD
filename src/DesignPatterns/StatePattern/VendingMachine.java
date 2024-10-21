package DesignPatterns.StatePattern;

public class VendingMachine {
    private VendingMachineState currentState;
    private int stock;

    public VendingMachine(int stock) {
        this.stock = stock;
        if (stock > 0) {
            this.currentState = new IdleState();
        } else {
            this.currentState = new OutOfStockState();
        }
    }

    public void insertCoin() {
        currentState.insertCoin(this);
    }

    public void dispenseItem() {
        currentState.dispenseItem(this);
    }

    public void setState(VendingMachineState currentState) {
        this.currentState = currentState;
    }

    public int getStock() {
        return stock;
    }

    public void decrementStock() {
        this.stock--;
    }
}
