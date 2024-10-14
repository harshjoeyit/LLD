package DesignPatterns.Factory.AbstractFactory.VehicleFactories;

import DesignPatterns.Factory.AbstractFactory.AbstractVehicleFactory;
import DesignPatterns.Factory.AbstractFactory.Vehicles.LuxuryBike;
import DesignPatterns.Factory.AbstractFactory.Vehicles.LuxuryCar;
import DesignPatterns.Factory.AbstractFactory.AbstractVehicles.Car;
import DesignPatterns.Factory.AbstractFactory.AbstractVehicles.Bike;

public class LuxuryVehicleFactory implements AbstractVehicleFactory {
    @Override
    public Car createCar() {
        return new LuxuryCar();
    }

    @Override
    public Bike createBike() {
        return new LuxuryBike();
    }
}
