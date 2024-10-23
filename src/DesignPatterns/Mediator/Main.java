package DesignPatterns.Mediator;

public class Main {
    public static void main() {
        Auctioneer auctioneer = new Auctioneer();

        Buyer buyer1 = new Buyer( "Buyer 1", auctioneer);
        Buyer buyer2 = new Buyer("Buyer 2", auctioneer);
        Buyer buyer3 = new Buyer("Buyer 3", auctioneer);

        auctioneer.registerBuyer(buyer1);
        auctioneer.registerBuyer(buyer2);
        auctioneer.registerBuyer(buyer3);

        buyer1.makeBid(100);
        buyer2.makeBid(200);
        buyer3.makeBid(300);

        auctioneer.announceWinner();
    }
}
