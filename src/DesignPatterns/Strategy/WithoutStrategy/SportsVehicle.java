package DesignPatterns.Strategy.WithoutStrategy;

// child class of Vehicle
public class SportsVehicle extends Vehicle {
	@Override
	public void drive() {
		// implement sports capability
		System.out.println("Sports drive capabilitysssss");
	}
}
