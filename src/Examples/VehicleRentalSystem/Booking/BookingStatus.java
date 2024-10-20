package Examples.VehicleRentalSystem.Booking;

public enum BookingStatus {
    BOOKED,         // booked but not picked up
    PICKED_UP,      // picked up
    COMPLETED,      // dropped/returned
    CANCELLED
}
