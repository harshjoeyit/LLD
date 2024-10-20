package Examples.VehicleRentalSystem;

import java.time.LocalDate;

import Examples.VehicleRentalSystem.Booking.BookingManager;
import Examples.VehicleRentalSystem.Booking.Booking;
import Examples.VehicleRentalSystem.Vehicle.Vehicle;
import Examples.VehicleRentalSystem.Vehicle.VehicleInventory;

public class Store {
    int id;
    VehicleInventory vehicleInventory;
    Location location;
    BookingManager bookingManager;

    public Store(int id, VehicleInventory vehicleInventory, Location location) {
        this.id = id;
        this.vehicleInventory = vehicleInventory;
        this.location = location;
        this.bookingManager = new BookingManager();
    }

    // book a vehicle
    public Booking bookVehicle(Vehicle vehicle, User user, LocalDate bookingDate, LocalDate bookingStart,
            LocalDate bookingEnd) {

        Booking booking = this.bookingManager.bookVehicle(
                vehicle,
                user,
                bookingDate,
                bookingStart,
                bookingEnd,
                this.location,
                this.location);

        return booking;
    }

    // getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public VehicleInventory getVehicleInventory() {
        return vehicleInventory;
    }

    public void setVehicleInventory(VehicleInventory vehicleInventory) {
        this.vehicleInventory = vehicleInventory;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public BookingManager getBookingManager() {
        return bookingManager;
    }

    public void setBookingManager(BookingManager bookingManager) {
        this.bookingManager = bookingManager;
    }
}
