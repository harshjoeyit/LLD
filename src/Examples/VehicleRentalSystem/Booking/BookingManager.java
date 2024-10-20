package Examples.VehicleRentalSystem.Booking;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Examples.VehicleRentalSystem.User;
import Examples.VehicleRentalSystem.Vehicle.Vehicle;
import Examples.VehicleRentalSystem.Location;

public class BookingManager {
    List<Booking> bookings;
    
    public BookingManager() {
        this.bookings = new ArrayList<Booking>();
    }

    // checks if vehicle is already booked
    public boolean isAlreadyBooked(Vehicle vehicle) {
        for (Booking booking: this.bookings) {
            if (booking.getVehicle().getId() == vehicle.getId()) {
                return true;
            }
        }

        return false;
    }

    // create a new booking and add to the list of bookings
    public Booking bookVehicle(Vehicle vehicle, User user, LocalDate bookingDate, LocalDate bookingStart, LocalDate bookingEnd, Location pickupLocation, Location dropLocation) {

        // check if already booked
        boolean isbooked = this.isAlreadyBooked(vehicle);
        if (isbooked) {
            System.out.println("Vehicle already booked");
            return null;
        }

        Booking booking = new Booking(
            1,
            vehicle,
            user,
            bookingDate,
            bookingStart,
            bookingEnd,
            pickupLocation,
            dropLocation
            );

        // add to the list of bookings
        bookings.add(booking);

        return booking;
    }

    // return vehicle
    public void returnVehicle(Booking booking) {
        // mark the booking as completed
        booking.setStatus(BookingStatus.COMPLETED);

        this.deleteBooking(booking);
    }

    // delete a booking
    public void deleteBooking(Booking booking) {
        // find and delete the booking from the list
        List<Booking> updatedBookings = new ArrayList<Booking>();
        for(Booking b: this.bookings) {
            if (b.id == booking.id) {
                continue;
            }

            updatedBookings.add(b);
        }

        setBookings(updatedBookings);
    }

    // update booking
    // user can change - date of pickup, drop, etc
    public void updatedBooking(Booking booking) {
        // todo
    }

    // getters and setters

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}
