package DesignPatterns.Builder;

public class Main {
    public static void main() {
        Car car = new Car.Builder()
                .setEngine("V6")
                .setWheels(4)
                .setAirbags(true)
                .setColor("Red")
                .build();               // Note: we're calling build at the end

        System.out.println(car);

        // using director

        Director director = new Director(new Car.Builder());
        Car sportscar = director.constructSportsCar();

        System.out.println(sportscar);
    }
}
