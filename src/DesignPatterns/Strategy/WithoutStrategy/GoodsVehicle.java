package DesignPatterns.Strategy.WithoutStrategy;

public class GoodsVehicle extends Vehicle {
	@Override
	public void drive() {
		// different implementation for drive 
		System.out.println("Normal drive capability");
	}
}
