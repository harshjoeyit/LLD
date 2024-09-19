package DesignPatterns.Strategy.WithStrategy.Strategy;

public class NormalDriveStrategy implements DriveStrategy {
  @Override
  public void drive() {
		System.out.println("Normal drive strategy");
	}
}
