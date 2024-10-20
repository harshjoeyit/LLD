package Examples.VehicleRentalSystem;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

import Examples.VehicleRentalSystem.Vehicle.VehicleInventory;
import Examples.VehicleRentalSystem.Vehicle.Vehicle;
import Examples.VehicleRentalSystem.Booking.Booking;
import Examples.VehicleRentalSystem.Vehicle.Car;

public class Main {
    public static void main() {
        List<User> users = addUsers();
        List<Store> stores = addStores();

        VehicleRentalSystem vrs = new VehicleRentalSystem(users, stores);

        // Step 1: User comes
        User user = users.get(0);

        // Step 2: Searches and select store based on location
        Location location = new Location("Bengaluru", "Karnanata", "ABC, ABC", 560092);
        List<Store> searchResults = vrs.searchStore(location);
        Store selectedStore = searchResults.get(0);

        // Step 3: Select a vehicle from the store
        Vehicle vehicle = selectedStore.vehicleInventory.getVehicles().get(0);

        // Step 4: Book selected vehicle
        Booking booking  = selectedStore.bookVehicle(
            vehicle, 
            user, 
            LocalDate.now(),
            LocalDate.of(2024, 10, 27),
            LocalDate.of(2024, 10, 30)
            );

        // Step 6: Generate the bill
        Bill bill = new Bill(booking);

        // Step 9: Pay the bill
        Payment payment = new Payment(bill);
        if (!payment.payBill()) {
            System.out.println("bill not paid");
        }

        System.out.println("booking completed");

        System.out.println(booking);

        // can be added - 
        // Step 7: Pickup Car
        // Step 8: Return the car
    }

    public static List<User> addUsers() {
        List<User> users = new ArrayList<User>();

        User user1 = new User(1, "+917409204646", "ab@gmail.com", "Harshit");
        User user2 = new User(2, "+917409204645", "abc@gmail.com", "Yash");

        users.add(user1);
        users.add(user2);

        return users;
    }

    public static List<Store> addStores() {
        // int id, VehicleInventory vehicleInventory, Location location, BookingManager
        // bookingManager
        List<Vehicle> vehicles = getVehicles();

        List<Vehicle> vehicles2 = new ArrayList<>();
        vehicles2.add(vehicles.get(1));

        VehicleInventory vi1 = new VehicleInventory(vehicles);
        VehicleInventory vi2 = new VehicleInventory(vehicles2);

        Location l1 = new Location("Bengaluru", "Karnanata", "ABC, ABC", 560092);
        Location l2 = new Location("Lucknow", "UP", "ABC, EFG", 256003);

        Store s1 = new Store(1, vi1, l1);
        Store s2 = new Store(2, vi2, l2);

        List<Store> stores = new ArrayList<Store>();
        stores.add(s1);
        stores.add(s2);

        return stores;
    }

    public static List<Vehicle> getVehicles() {
        Vehicle v1 = new Car(
                1,
                "UP25BX1234",
                "Ford",
                "Ecosport",
                4,
                120.0,
                1234.5,
                200);

        Vehicle v2 = new Car(
                2,
                "MP25BX1234",
                "Hyundai",
                "i20",
                4,
                100.0,
                1234.5,
                300);

        List<Vehicle> vehicles = new ArrayList<Vehicle>();
        vehicles.add(v1);
        vehicles.add(v2);

        return vehicles;
    }
}
