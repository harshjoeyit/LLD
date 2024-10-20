package DesignPatterns.ChainOfResponsibility;

public class Main {
    public static void main() {
        Handler level1Handler = new Level1Support();
        Handler level2Handler = new Level2Support();
        Handler level3Handler = new Level3Support();

        // set chain of responsibility
        level1Handler.setNext(level2Handler);
        level2Handler.setNext(level3Handler);

        // Test the chain with different requests
        System.out.println("Request: simple query");
        level1Handler.handleRequest("simple query");

        System.out.println("\nRequest: complex query");
        level1Handler.handleRequest("complex query");

        System.out.println("\nRequest: unknown query");
        level1Handler.handleRequest("unknown query");
    }
}
