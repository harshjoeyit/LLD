package Examples.VehicleRentalSystem.Vehicle;

import Examples.VehicleRentalSystem.Vehicle.Enums.VehicleType;

public class Bike extends Vehicle {

    public Bike(int id, String licensePlate, String manufacturer, String model, int seatCapacity,
            double hourlyRentalCost, double dailyRentalCost, double kmDriven, double horsePower) {

        super(
                id,
                licensePlate,
                manufacturer,
                model,
                seatCapacity,
                VehicleType.BIKE,
                dailyRentalCost,
                kmDriven,
                horsePower);
    }
}
