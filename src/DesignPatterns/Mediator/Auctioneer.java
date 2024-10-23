package DesignPatterns.Mediator;

import java.util.List;
import java.util.ArrayList;

public class Auctioneer implements AuctionMediator {

    private List<Buyer> buyers;
    private int highestBid = 0;
    private Buyer highestBidder;

    public Auctioneer() {
        this.buyers = new ArrayList<>();
    }

    @Override
    public void registerBuyer(Buyer buyer) {
        this.buyers.add(buyer);
    }

    @Override
    public void placeBid(Buyer buyer, int bidAmount) {
        if (bidAmount > highestBid) {
            highestBid = bidAmount;
            highestBidder = buyer;

            String message  = "[" + buyer.getName() + "]: made a mid of " + bidAmount;
            notifyBuyers(message, buyer);
        }
    }

    @Override
    public void notifyBuyers(String message, Buyer exludeBuyer) {
        // send notification to all but the excluded buyer if not null
        for(Buyer buyer: this.buyers) {
            if (exludeBuyer != null && buyer.name == exludeBuyer.name) {
                continue;
            }

            buyer.receiveNotification(message);
        }
    }

    @Override
    public void announceWinner() {
        String message = this.highestBidder.getName() + " wins with highest bid of " + this.highestBid;
        this.notifyBuyers(message, null);
    }
}
