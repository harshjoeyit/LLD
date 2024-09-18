package DesignPatterns.Strategy.WithStrategy;

import DesignPatterns.Strategy.WithStrategy.Strategy.GoodsDriveStrategy;

public class GoodsVehicle extends Vehicle {
  // constructor
  GoodsVehicle() {
    // injecting into constructor of Vehicle
    super(new GoodsDriveStrategy());
  }
}
