package DesignPatterns.Strategy.WithStrategy;

import DesignPatterns.Strategy.WithStrategy.Strategy.SportsDriveStrategy;

public class OffRoadVehicle extends Vehicle {
  // constructor
  OffRoadVehicle() {
    // injecting Vehicle constructure with driveStrategy
    super(new SportsDriveStrategy());
  }
}
