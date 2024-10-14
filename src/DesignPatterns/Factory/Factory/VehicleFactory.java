package DesignPatterns.Factory.Factory;

public class VehicleFactory {

    // Method to return a vehicle based on the input type
    public Vehicle getVehicle(String vehicleType) {
        if (vehicleType == null) {
            return null;
        }

        if (vehicleType.equals("CAR")) {
            return new Car();
        } else if (vehicleType.equals("BIKE")) {
            return new Bike();
        } else if (vehicleType.equals("TRUCK")) {
            return new Truck();
        }

        return null;
    }
}
