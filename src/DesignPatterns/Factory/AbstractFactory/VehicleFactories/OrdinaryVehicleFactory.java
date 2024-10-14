package DesignPatterns.Factory.AbstractFactory.VehicleFactories;

import DesignPatterns.Factory.AbstractFactory.AbstractVehicleFactory;
import DesignPatterns.Factory.AbstractFactory.AbstractVehicles.Bike;
import DesignPatterns.Factory.AbstractFactory.AbstractVehicles.Car;
import DesignPatterns.Factory.AbstractFactory.Vehicles.OrdinaryBike;
import DesignPatterns.Factory.AbstractFactory.Vehicles.OrdinaryCar;

public class OrdinaryVehicleFactory implements AbstractVehicleFactory {
    @Override
    public Car createCar() {
        return new OrdinaryCar();
    }
    
    @Override
    public Bike createBike() {
        return new OrdinaryBike();
    }
}
