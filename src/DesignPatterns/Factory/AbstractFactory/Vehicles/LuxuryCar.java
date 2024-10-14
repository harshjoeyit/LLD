package DesignPatterns.Factory.AbstractFactory.Vehicles;

import DesignPatterns.Factory.AbstractFactory.AbstractVehicles.Car;

public class LuxuryCar implements Car {
    @Override
    public void drive() {
        System.out.println("Driving an luxury car...");
    }
}
