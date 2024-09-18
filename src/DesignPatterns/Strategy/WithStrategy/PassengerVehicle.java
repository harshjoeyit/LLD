package DesignPatterns.Strategy.WithStrategy;

import DesignPatterns.Strategy.WithStrategy.Strategy.NormalDriveStrategy;

public class PassengerVehicle extends Vehicle {
  // constructor
  PassengerVehicle() {
    // injecting into constructor of Vehicle
    super(new NormalDriveStrategy());
  }
}
