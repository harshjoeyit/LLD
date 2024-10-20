package Examples.VehicleRentalSystem;

public class Payment {
    Bill bill;

    public Payment (Bill bill) {
        this.bill = bill;
    }

    public boolean payBill() {
        this.bill.setPaid(true);
        return true;
    }

    // getters and setters

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }
}
