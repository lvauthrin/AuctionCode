package com.laujer.misc.auction;

import java.util.Date;

/**
 * Class that represents a bidder
 * @author Laurent Vauthrin
 */
public class Bidder {
    private String name;
    private int bid;
    private int originalBid;
    private int maxBid;
    private int increment;
    private Date bidTime;

    public Bidder(String name, int bid, int maxBid, int increment) {
        this.setName(name);
        this.setBid(bid);
        this.setOriginalBid(bid);
        this.setMaxBid(maxBid);
        this.setIncrement(increment);
        this.bidTime = new Date();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public int getBid() {
        return bid;
    }

    public void setOriginalBid(int originalBid) {
        this.originalBid = originalBid;
    }

    public int getOriginalBid() {
        return originalBid;
    }

    public void setMaxBid(int maxBid) {
        this.maxBid = maxBid;
    }

    public int getMaxBid() {
        return maxBid;
    }

    public void setIncrement(int increment) {
        this.increment = increment;
    }

    public int getIncrement() {
        return increment;
    }

    public void setBidTime(Date bidTime) {
        this.bidTime = bidTime;
    }

    public Date getBidTime() {
        return bidTime;
    }

    public int bid() {
        this.bid += this.increment;
        System.out.println(String.format("%s's bid is now at %d", this.name, this.bid));
        return bid;
    }

    @Override
    public String toString() {
        return String.format("%s - current bid [%d] max bid [%d] bid increment [%d]", 
                this.name,
                this.bid,
                this.maxBid,
                this.increment);
    }
}