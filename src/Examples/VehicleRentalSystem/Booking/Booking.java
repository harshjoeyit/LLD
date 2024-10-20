package Examples.VehicleRentalSystem.Booking;

import java.time.LocalDate;

import Examples.VehicleRentalSystem.Vehicle.Vehicle;
import Examples.VehicleRentalSystem.Location;
import Examples.VehicleRentalSystem.User;

public class Booking {
    int id;

    Vehicle vehicle;
    User user;

    // booking date and time
    LocalDate bookingDate; // date on which booking is made
    LocalDate bookingStart; // pickup
    LocalDate bookingEnd; // drop

    BookingStatus status;

    // location
    Location pickupLocation;
    Location dropLocation;

    public Booking(int id, Vehicle vehicle, User user, LocalDate bookingDate, LocalDate bookingStart,
            LocalDate bookingEnd,
            Location pickupLocation, Location dropLocation) {
        this.id = id;
        this.vehicle = vehicle;
        this.user = user;
        this.bookingDate = bookingDate;
        this.bookingStart = bookingStart;
        this.bookingEnd = bookingEnd;
        this.status = BookingStatus.BOOKED;
        this.pickupLocation = pickupLocation;
        this.dropLocation = dropLocation;
    }

    // getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public LocalDate getBookingStart() {
        return bookingStart;
    }

    public void setBookingStart(LocalDate bookingStart) {
        this.bookingStart = bookingStart;
    }

    public LocalDate getBookingEnd() {
        return bookingEnd;
    }

    public void setBookingEnd(LocalDate bookingEnd) {
        this.bookingEnd = bookingEnd;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    public Location getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(Location pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public Location getDropLocation() {
        return dropLocation;
    }

    public void setDropLocation(Location dropLocation) {
        this.dropLocation = dropLocation;
    }

}
