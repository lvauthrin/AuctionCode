package com.laujer.misc.auction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class that finds the winner of an auction given a list of bidders.
 * @author Laurent Vauthrin
 */
public class QuickAuction extends AbstractAuction {

    @Override
    public Bidder findWinner() throws InvalidAuctionException {
        List<Bidder> sortedBidders = new ArrayList<Bidder>(bidders);

        Collections.sort(sortedBidders, new BidderMaxBidComparator());

        Bidder first = sortedBidders.get(sortedBidders.size() - 1);
        Bidder second = sortedBidders.get(sortedBidders.size() - 2);

        // Calculate the bid value needed for the highest bidder to just exceed the second
        double maxBidValue;
        maxBidValue = 
            Math.floor((second.getMaxBid() - second.getOriginalBid()) / second.getIncrement()) * 
            second.getIncrement() + second.getOriginalBid();
        maxBidValue = 
            Math.ceil((maxBidValue - first.getOriginalBid()) / first.getIncrement()) * 
            first.getIncrement() + first.getOriginalBid();

        first.setBid((int) maxBidValue);
        
        return first;
    }

}
