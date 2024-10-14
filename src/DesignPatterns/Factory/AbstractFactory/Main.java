package DesignPatterns.Factory.AbstractFactory;

import DesignPatterns.Factory.AbstractFactory.AbstractVehicles.Bike;
import DesignPatterns.Factory.AbstractFactory.AbstractVehicles.Car;
import DesignPatterns.Factory.AbstractFactory.VehicleFactories.LuxuryVehicleFactory;
import DesignPatterns.Factory.AbstractFactory.VehicleFactories.OrdinaryVehicleFactory;

public class Main {
    public static void main() {
        // use luxuryFactory
        AbstractVehicleFactory luxuryVehicleFactory = new LuxuryVehicleFactory();

        Car luxuryCar = luxuryVehicleFactory.createCar();
        luxuryCar.drive();

        Bike luxuryBike = luxuryVehicleFactory.createBike();
        luxuryBike.drive();

        // use luxuryFactory
        AbstractVehicleFactory ordinaryFactory = new OrdinaryVehicleFactory();

        Car ordinaryCar = ordinaryFactory.createCar();
        ordinaryCar.drive();

        Bike ordinaryBike = ordinaryFactory.createBike();
        ordinaryBike.drive();
    }
}
