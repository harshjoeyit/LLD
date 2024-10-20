package Examples.VehicleRentalSystem;

import Examples.VehicleRentalSystem.Booking.Booking;
import java.time.Period;

public class Bill {
    Booking booking;
    double amount;
    boolean isPaid;

    public Bill(Booking booking) {
        this.booking = booking;
        this.amount = this.calcAmount(booking);
        this.isPaid = false;
    }

    // calculate amount based on the number of days of booking
    public double calcAmount(Booking booking) {
        // Calculate the difference using Period
        Period period = Period.between(booking.getBookingStart(), booking.getBookingEnd());
        int daysInBetween = period.getDays();
        double dailyRentalCost = booking.getVehicle().getDailyRentalCost();
        
        return daysInBetween * dailyRentalCost;
    }

    // getters and setters
    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }
}
