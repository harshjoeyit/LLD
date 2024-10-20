

public class App {
    public static void strategyPattern() {
        DesignPatterns.Strategy.WithoutStrategy.Main.main();
        System.out.println();
        DesignPatterns.Strategy.WithStrategy.Main.main();
    }

    public static void observerPattern() {
        DesignPatterns.Observer.Main.main();
    }

    public static void decoratorPattern() {
        DesignPatterns.Decorator.Main.main();
    }

    public static void factoryPattern() {
        DesignPatterns.Factory.Factory.Main.main();
    }

    public static void abstractFactoryPattern() {
        DesignPatterns.Factory.AbstractFactory.Main.main();
    }

    public static void tictactoeGame() {
        Examples.TicTacToe.Main.main();
    }

    public static void vehicleRentalSystem() {
        Examples.VehicleRentalSystem.Main.main();
    }

    public static void chainOfResponsibility() {
        DesignPatterns.ChainOfResponsibility.Main.main();
    }

    public static void logger() {
        Examples.Logger.Main.main();
    }

    public static void atm() {
        Examples.ATM.Main.main();
    }

    public static void vendingMachine() {
        Examples.VendingMachine.Main.main();
    }

    public static void builderPattern() {
        DesignPatterns.Builder.Main.main();
    }

    public static void main(String[] args) throws Exception {
        // strategyPattern();
        // observerPattern();
        // decoratorPattern();
        // factoryPattern();
        // abstractFactoryPattern();
        // tictactoeGame();
        // vehicleRentalSystem();
        // chainOfResponsibility();
        // logger();
        // atm();
        // vendingMachine();
        builderPattern();
    }
}


