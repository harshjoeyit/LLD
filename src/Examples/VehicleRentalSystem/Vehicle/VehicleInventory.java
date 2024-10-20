package Examples.VehicleRentalSystem.Vehicle;

import java.util.List;

// handles all the CRUD operations for a vehicle in store
public class VehicleInventory {
    List<Vehicle> vehicles;

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    // getters and setters

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public VehicleInventory(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}
