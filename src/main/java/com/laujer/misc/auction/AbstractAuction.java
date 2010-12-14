package com.laujer.misc.auction;

import java.util.Collection;
import java.util.HashSet;

/**
 * Abstract Auction class that contains common functionality.
 * @author Laurent Vauthrin
 */
public abstract class AbstractAuction implements Auction {

    protected String auctionItem = null;
    protected Collection<Bidder> bidders = new HashSet<Bidder>(); 

    @Override
    public void setAuctionItem(String auctionItem) {
        this.auctionItem = auctionItem;
    }

    @Override
    public void addBidders(Collection<Bidder> bidders) {
        this.bidders.addAll(bidders);
    }

    @Override
    public Bidder execute() throws InvalidAuctionException {
        if (auctionItem == null) {
            throw new InvalidAuctionException("No item submitted for auction.  Auction canceled.");
        }

        if (bidders.size() == 0) {
            throw new InvalidAuctionException("No bids were submitted.  Auction canceled.");
        }

        // Return the only bidder if there's only one bidder
        if (bidders.size() == 1) {
            Bidder winner = bidders.iterator().next();
            String message = String.format("%s won auction for '%s' by default.", 
                                           winner.getName(), 
                                           this.auctionItem);
            System.out.println(message);            
            return winner;
        }
        
        Bidder winner = findWinner();
        
        String message = String.format("%s wins the auction for '%s' with a bid of %d", 
                                       winner.getName(), 
                                       this.auctionItem, 
                                       winner.getBid());
        System.out.println(message);
        System.out.println();
        
        return winner;
    }
    
    public abstract Bidder findWinner() throws InvalidAuctionException;

}
