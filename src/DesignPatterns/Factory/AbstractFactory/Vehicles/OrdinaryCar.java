package DesignPatterns.Factory.AbstractFactory.Vehicles;

import DesignPatterns.Factory.AbstractFactory.AbstractVehicles.Car;

public class OrdinaryCar implements Car {
    @Override
    public void drive() {
        System.out.println("Driving an ordinary car...");
    }
}
