package DesignPatterns.Factory.AbstractFactory;

import DesignPatterns.Factory.AbstractFactory.AbstractVehicles.Car;
import DesignPatterns.Factory.AbstractFactory.AbstractVehicles.Bike;

public interface AbstractVehicleFactory {
    Car createCar();
    Bike createBike();
}
