package com.laujer.misc.auction.test;

import java.util.ArrayList;
import java.util.Collection;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.laujer.misc.auction.Auction;
import com.laujer.misc.auction.CompleteAuction;
import com.laujer.misc.auction.Bidder;
import com.laujer.misc.auction.InvalidAuctionException;
import com.laujer.misc.auction.QuickAuction;

public class AuctionTest {

    Auction auction = null;
    Collection<Bidder> bidders = null;

    @Before
    public void setUp() throws Exception {
        auction = (System.getProperty("Complete") != null) ? new CompleteAuction() : 
                                                             new QuickAuction();
        bidders = new ArrayList<Bidder>();
    }

    @Test
    public void auctionTest() throws Exception {
        auction.setAuctionItem("Bicycle");

        bidders.add(new Bidder("Alice", 50, 80, 3));
        bidders.add(new Bidder("Aaron", 60, 82, 2));
        bidders.add(new Bidder("Amanda", 55, 85, 5));

        auction.addBidders(bidders);

        Bidder winner = auction.execute();

        Assert.assertEquals(85, winner.getBid());	
        Assert.assertEquals("Amanda", winner.getName());
    }

    @Test
    public void auctionTest2() throws Exception {
        auction.setAuctionItem("Scooter");

        bidders.add(new Bidder("Alice", 700, 725, 2));
        bidders.add(new Bidder("Aaron", 599, 725, 15));
        bidders.add(new Bidder("Amanda", 625, 725, 8));

        auction.addBidders(bidders);

        Bidder winner = auction.execute();

        Assert.assertEquals(722, winner.getBid());		
        Assert.assertEquals("Alice", winner.getName());
    }

    @Test
    public void auctionTest3() throws Exception {
        auction.setAuctionItem("Boat");

        bidders.add(new Bidder("Amanda", 2501, 3200, 247));
        bidders.add(new Bidder("Alice", 2500, 3000, 500));
        bidders.add(new Bidder("Aaron", 2800, 3100, 201));

        auction.addBidders(bidders);

        Bidder winner = auction.execute();

        Assert.assertEquals(3001, winner.getBid());		
        Assert.assertEquals("Aaron", winner.getName());
    }

    @Test(expected=InvalidAuctionException.class)
    public void noAuctioneersTest() throws InvalidAuctionException {
        auction.setAuctionItem("Undesirable Object");
        auction.execute();
    }

    @Test(expected=InvalidAuctionException.class)
    public void noAuctionItemTest() throws InvalidAuctionException {
        bidders.add(new Bidder("Luckson", 1, 1, 1));        
        auction.addBidders(bidders);
        auction.execute();
    }
} 