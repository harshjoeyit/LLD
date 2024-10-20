package Examples.VehicleRentalSystem.Vehicle;

import java.util.List;
import java.util.ArrayList;

import Examples.VehicleRentalSystem.Vehicle.Enums.VehicleType;

// handles all the CRUD operations for a vehicle in store
public class VehicleInventory {
    List<Vehicle> vehicles;

    public List<Vehicle> getVehicles(VehicleType vehicleType) {
        List<Vehicle> searchResults = new ArrayList<Vehicle>();
        for(Vehicle v: this.vehicles) {
            if (vehicleType == v.getVehicleType()) {
                searchResults.add(v);
            }
        }
        
        return searchResults;
    }

    // getters and setters

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public VehicleInventory(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}
