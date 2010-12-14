package com.laujer.misc.auction;

import java.util.Collection;

/**
 * Interface for an Auction.
 * @author Laurent Vauthrin
 */
public interface Auction {

    /**
     * Set the item up for auction.
     * @param auctionItem The item up for auction
     */
    public abstract void setAuctionItem(String auctionItem);

    /**
     * Set the list of bidders.
     * @param bidders The list of bidders
     */
    public abstract void addBidders(Collection<Bidder> bidders);

    /**
     * Run the auction for the specified item and bidders.
     * @return The winning bidder
     * @throws InvalidAuctionException If no item or bidder is set
     */
    public abstract Bidder execute() throws InvalidAuctionException;

}