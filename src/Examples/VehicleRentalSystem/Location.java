package Examples.VehicleRentalSystem;

public class Location {
    String city;
    String state;
    String address;
    int pincode;

    public Location(String city, String state, String address, int pincode) {
        this.city = city;
        this.state = state;
        this.address = address;
        this.pincode = pincode;
    }

    // getters and setters
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

}
