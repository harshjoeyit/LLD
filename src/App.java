

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

    public static void main(String[] args) throws Exception {
        // strategyPattern();
        // observerPattern();
        decoratorPattern();
    }
}
