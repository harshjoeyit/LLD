package Examples.Calendar;

public class User {
    String userID;
    String name;
    String email;
    Calendar calendar;

    // Constructor
    public User(String userID, String name, String email, Calendar calendar) {
        this.userID = userID;
        this.name = name;
        this.email = email;
        this.calendar = calendar;
    }

    // Getters and Setters
    
    // name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // calendar
    public Calendar getCalendar() {
        return this.calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }
}
