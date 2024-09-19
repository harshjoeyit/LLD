package DesignPatterns.Strategy.WithStrategy.Strategy;

public class GoodsDriveStrategy implements DriveStrategy {
  @Override
  public void drive() {
    System.out.println("Goods drive strategy");
  }
}
