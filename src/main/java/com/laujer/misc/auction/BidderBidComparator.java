package com.laujer.misc.auction;

import java.util.Comparator;

/**
 * Compares the current bid of two bidders.
 * @author Laurent Vauthrin
 */
public class BidderBidComparator implements Comparator<Bidder> {

    @Override
    public int compare(Bidder bidder1, Bidder bidder2) {
        int comparison = bidder1.getBid() - bidder2.getBid();

        // Use the date as the discriminator if the bids are equal 
        if (comparison == 0) {
            comparison = (int) (bidder1.getBidTime().getTime() - bidder2.getBidTime().getTime());
        }

        return comparison;
    }

}
