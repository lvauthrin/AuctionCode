package com.laujer.misc.auction;

/**
 * Exception used to indicate an auction specific failure.
 * @author Laurent Vauthrin
 */
@SuppressWarnings("serial")
public class InvalidAuctionException extends Exception {

    public InvalidAuctionException(String message) {
        super(message);
    }

}
