package DesignPatterns.Mediator;

public class Buyer {
    AuctionMediator mediator;
    String name;

    public Buyer(String name, AuctionMediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    public void makeBid(int bidAmount) {
        System.out.println(this.name + " is making a bid of " + bidAmount);
        mediator.placeBid(this, bidAmount);
    }

    public void receiveNotification(String message) {
        System.out.println(this.name + " received message: " + message);
    }

    public String getName() {
        return this.name;
    }
}
