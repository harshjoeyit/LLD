package Examples.VehicleRentalSystem;

public class User {
    // identifiers
    int id;
    String mobileNumber;
    String email;
    String fullName;
    
    // must have
    String drivingLicense;

    // Note: do not tie location to user since
    // user should be able to rent cars in other cities

    public User(int id, String mobileNumber, String email, String fullName) {
        this.id = id;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.fullName = fullName;
    }

    // getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDrivingLicense() {
        return drivingLicense;
    }

    public void setDrivingLicense(String drivingLicense) {
        this.drivingLicense = drivingLicense;
    }
}
