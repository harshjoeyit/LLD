package DesignPatterns.Strategy.WithoutStrategy;

public class Main {
  public static void main() {

    PassengerVehicle p = new PassengerVehicle();
    p.drive();

    SportsVehicle s = new SportsVehicle();
    s.drive();

    GoodsVehicle g = new GoodsVehicle();
    g.drive();

    OffRoadVehicle o = new OffRoadVehicle();
    o.drive();
  }
}
