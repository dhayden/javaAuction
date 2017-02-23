
/*
 AuctionImpl
 hello world example for Impl files: https://docs.oracle.com/javase/8/docs/technotes/guides/idl/jidlTieServer.html
 */
package auctionPack;

import org.omg.CORBA.*;
import java.util.*;

class AuctionImpl extends AuctionPOA {

    private final ORB orb;
    private final HashMap _catalogue;
    private final HashMap _userinfo;
    private float price;
    private String bidder;
    private String name;

    // custom constructor 
    public AuctionImpl(ORB orb) {
        this.orb = orb;
        _catalogue = new HashMap();
        _userinfo = new HashMap();
        price = (float) 0.0;
        bidder = "No one has placed any bids.";
        name = "";
    }

    // offer
    @Override
    public boolean offer(String sellerId, String item, float initPrice)
            throws auctionPack.InvalidOfferException {

        try {
            System.out.println("Seller ID:"
                    + sellerId
                    + " put an item: "
                    + item
                    + " Initial Price:"
                    + initPrice);
            ArrayList vec;
            vec = new ArrayList(2);
            vec.add(sellerId);
            vec.add(initPrice);

            _catalogue.put(item, vec);
            price = initPrice;
            name = item;

        } catch (Exception e) {
            System.out.println(e);
            System.exit(1);
        }
        return true;
    }

    //sell

    @Override
    public boolean sell(String itemName) throws auctionPack.InvalidSellException {
        ArrayList vec1 = (ArrayList) _catalogue.get(itemName);

        String sellerID = String.valueOf(vec1.indexOf(0));

        System.out.println("The Seller:" + sellerID + " bought this item "
                + name + " for:" + price);
        _catalogue.remove(itemName);
        _userinfo.remove(price);
        _userinfo.remove(bidder);
        name = "";
        price = (float) 0.0;
        bidder = "No bidder yet";
        return true;
    }

    //high bidder
    @Override
    public String viewHighBidder(String itemName) throws auctionPack.InvalidSellException {
        ArrayList vec1 = (ArrayList) _catalogue.get(itemName);
        String sellerID = String.valueOf(vec1.indexOf(0));
        float currentPrice;
        String c = String.valueOf(vec1.indexOf(1));
        currentPrice = Float.valueOf(c);
        String message;

        ArrayList vec2 = (ArrayList) _userinfo.get(bidder);
        if (vec2 == null) {
            message = "No high bidder yer/n";
        } else {
            String userID = String.valueOf(vec2.indexOf(0));
            message = "Highest bidder:"
                    + bidder
                    + "Item:"
                    + name
                    + "Price:"
                    + price;
        }
        return message;
    }

    // bidder
    @Override
    public boolean bid(String userId, float bidPrice) throws auctionPack.InvalidBidException {
        ArrayList user = new ArrayList(2);
        ArrayList vec = (ArrayList) _catalogue.get(name);

        if (vec == null) {
            return false;
        }

        user.indexOf(name);
        user.indexOf(bidPrice);
        _userinfo.put(userId, user);

        if (bidPrice >= price) {
            vec.add(1, bidPrice);
            price = bidPrice;
            bidder = userId;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String viewBidStatus(String userId) throws auctionPack.InvalidBidException {
        ArrayList vec = (ArrayList) _userinfo.get(userId);
        String message;

        if (vec == null) {
            message = "Invalid user id\n";
        }
        String itemName;
        itemName = String.valueOf(vec.indexOf(0));
        String yPrice = String.valueOf(vec.indexOf(1));
        float yourPrice = Float.valueOf(yPrice);

        ArrayList vec1 = (ArrayList) _catalogue.get(itemName);
        String sellerID = String.valueOf(vec1.indexOf(0));
        String cPrice = String.valueOf(vec1.indexOf(1));
        float currentPrice = Float.valueOf(cPrice);

        if (currentPrice == yourPrice) {
            message = "Congratulation! User ID:" + userId + " is the highest bidder for Item:" + itemName
                    + "Price:" + currentPrice + "\n";
        } else {
            message = "Sorry! User ID:" + userId + " is the not highest bidder for Item:" + itemName
                    + "of Price:" + currentPrice + "Youe current bid=" + yourPrice + "\n";
        }

        return message;
    } //end of viewbidStatus function

// universally accessible methods
    @Override
    public auctionPack.AuctionStatus viewAuctionStatus() throws auctionPack.InvalidStatusException {
        auctionPack.AuctionStatus status = new auctionPack.AuctionStatus();
        ArrayList vec3 = (ArrayList) _catalogue.get(name);
        if (vec3 == null) {
            status.user = "No auction";
            status.item = "No Item";
            status.currentPrice = (float) 0.0;
            return status;
        } else {
            status.user = bidder;
            status.item = name;
            status.currentPrice = price;
            return status;
        }
    }
}
