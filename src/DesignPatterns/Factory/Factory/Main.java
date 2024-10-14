package DesignPatterns.Factory.Factory;

public class Main {
    public static void main() {
        // create instance of vehicle factory
        VehicleFactory vehicleFactory = new VehicleFactory();

        // get a Car object
        Vehicle car1 = vehicleFactory.getVehicle("CAR");
        car1.drive();

        // Get bike
        Vehicle bike1 = vehicleFactory.getVehicle("BIKE");
        bike1.drive();

        // Get truck
        Vehicle truck1 = vehicleFactory.getVehicle("TRUCK");
        truck1.drive();
    }
}
