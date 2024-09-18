package DesignPatterns.Strategy.WithStrategy;

public class Main {
  public static void main() {
    PassengerVehicle p = new PassengerVehicle();
    p.driveIt();

    SportsVehicle s = new SportsVehicle();
    s.driveIt();

    GoodsVehicle g = new GoodsVehicle();
    g.driveIt();

    OffRoadVehicle o = new OffRoadVehicle();
    o.driveIt();

  }
}
