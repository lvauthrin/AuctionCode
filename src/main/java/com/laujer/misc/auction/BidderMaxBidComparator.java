package com.laujer.misc.auction;

import java.util.Comparator;

/**
 * Compares the maximum possible bid of two Bidders.
 * @author Laurent Vauthrin
 */
public class BidderMaxBidComparator implements Comparator<Bidder> {

    @Override
    public int compare(Bidder bidder1, Bidder bidder2) {

        // Get the max possible bid that each bidder can do and see which is higher
        double maxBidCount1 = 
            Math.floor((bidder1.getMaxBid() - bidder1.getOriginalBid()) / bidder1.getIncrement());
        double maxBidCount2 = 
            Math.floor((bidder2.getMaxBid() - bidder2.getOriginalBid()) / bidder2.getIncrement());

        int comparison = (int) ((maxBidCount1 * bidder1.getIncrement() + bidder1.getOriginalBid()) - 
                                (maxBidCount2 * bidder2.getIncrement() + bidder2.getOriginalBid()));

        // Use the date as the discriminator if the bids are equal 
        if (comparison == 0) {
            comparison = (int) (bidder1.getBidTime().getTime() - bidder1.getBidTime().getTime());
        }

        return comparison;
    }

}
