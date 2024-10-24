package Examples.PaymentGateway2.User;

public class Merchant {
    String ID;
    String email;

    public Merchant(String email, String ID) {
        this.email = email;
        this.ID = ID;
    }

    // Getters and Setters
    
    public String getID() {
        return ID;
    }

    public void setID(String iD) {
        ID = iD;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
