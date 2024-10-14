package DesignPatterns.Factory.AbstractFactory.Vehicles;

import DesignPatterns.Factory.AbstractFactory.AbstractVehicles.Bike;

public class LuxuryBike implements Bike {
    @Override
    public void drive() {
        System.out.println("Driving an luxury bike...");
    }
}
