package Examples.VendingMachine;

public class Request {
    private Item selectedItem;
    private int insertedAmount; // in rupees
    
    public Request(Item selectedItem, int insertedAmount) {
        this.selectedItem = selectedItem;
        this.insertedAmount = insertedAmount;
    }

    public Item getSelectedItem() {
        return selectedItem;
    }

    public int getInsertedAmount() {
        return insertedAmount;
    }
}
