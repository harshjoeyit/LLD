package Examples.ATM;

public class Main {
    public static void main() {
        ATM atm = new ATM();

        int amount = 3600;
        System.out.println("Dispensing: " + amount);
        atm.dispense(amount);

        amount = 300;
        System.out.println("Dispensing: " + amount);
        atm.dispense(amount);

        amount = 10000;
        System.out.println("Dispensing: " + amount);
        atm.dispense(amount);
    }
}
