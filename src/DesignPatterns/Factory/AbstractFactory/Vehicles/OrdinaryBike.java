package DesignPatterns.Factory.AbstractFactory.Vehicles;

import DesignPatterns.Factory.AbstractFactory.AbstractVehicles.Bike;

public class OrdinaryBike implements Bike {
    @Override
    public void drive() {
        System.out.println("Driving an ordinary bike...");
    }
}
 