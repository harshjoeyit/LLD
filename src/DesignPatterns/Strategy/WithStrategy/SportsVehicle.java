package DesignPatterns.Strategy.WithStrategy;

import DesignPatterns.Strategy.WithStrategy.Strategy.SportsDriveStrategy;

public class SportsVehicle extends Vehicle {
  // constructor
  SportsVehicle() {
    // injecting Vehicle constructure with driveStrategy
    super(new SportsDriveStrategy());
  }
}
