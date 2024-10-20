package Examples.VehicleRentalSystem.Vehicle;

import Examples.VehicleRentalSystem.Vehicle.Enums.VehicleType;

public class Car extends Vehicle {
    public Car(int id, String licensePlate, String manufacturer, String model, int seatCapacity, 
    double dailyRentalCost, double kmDriven, double horsePower) {

        super(
            id, 
            licensePlate, 
            manufacturer, 
            model, 
            seatCapacity, 
            VehicleType.CAR,
            dailyRentalCost, 
            kmDriven, 
            horsePower
        );
    }
}
