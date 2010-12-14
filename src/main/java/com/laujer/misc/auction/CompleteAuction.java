package com.laujer.misc.auction;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Class that runs an auction step by step.
 * @author Laurent Vauthrin
 */
public class CompleteAuction extends AbstractAuction {

    @Override
    public Bidder findWinner() throws InvalidAuctionException {
        Set<Bidder> activeBidders = new HashSet<Bidder>(bidders);

        System.out.println(String.format("Starting auction for '%s'", this.auctionItem));

        while (activeBidders.size() > 1) {
            Bidder lowestBidder = null;

            for (Bidder bidder : bidders) {
                // Skip the bidder if he is no longer active
                if (!activeBidders.contains(bidder)) {
                    continue;
                }

                // Get this bidders next bid amount
                int nextBid = bidder.getBid() + bidder.getIncrement();

                // De-activate the bidder if this takes them over the max bid
                if (bidder.getMaxBid() < nextBid) {
                    activeBidders.remove(bidder);
                    continue;
                }

                // Check if this bidder has the next lowest bid out of all bidders (cumulative)
                if (lowestBidder == null || 
                    (nextBid < lowestBidder.getBid() + lowestBidder.getIncrement())) {
                    lowestBidder = bidder;
                }
            }

            if (lowestBidder != null) {
                lowestBidder.bid();
            }
        }

        return Collections.max(bidders, new BidderBidComparator());
    }
}