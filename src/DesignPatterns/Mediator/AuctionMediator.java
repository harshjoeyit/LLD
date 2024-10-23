package DesignPatterns.Mediator;

public interface AuctionMediator {
    public void registerBuyer(Buyer buyer);
    // place a bid with Auction mediator
    public void placeBid(Buyer buyer, int bidAmount);
    // let's other buyers know of the latest bid placed by any buyer
    public void notifyBuyers(String message, Buyer exludeBuyer);
    public void announceWinner();
}
