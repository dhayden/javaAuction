package auctionPack;

import auctionPack.Auction;


/**
* auction/AuctionPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Auction
* Wednesday, April 8, 2015 12:02:34 AM CDT
*/

public abstract class AuctionPOA extends org.omg.PortableServer.Servant
 implements auctionPack.AuctionOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("offer", new java.lang.Integer (0));
    _methods.put ("sell", new java.lang.Integer (1));
    _methods.put ("viewHighBidder", new java.lang.Integer (2));
    _methods.put ("bid", new java.lang.Integer (3));
    _methods.put ("viewBidStatus", new java.lang.Integer (4));
    _methods.put ("viewAuctionStatus", new java.lang.Integer (5));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {

  // seller accessible methods
       case 0:  // auction/Auction/offer
       {
         try {
           String sellerId = in.read_string ();
           String item = in.read_string ();
           float initPrice = in.read_float ();
           boolean $result = false;
           $result = this.offer (sellerId, item, initPrice);
           out = $rh.createReply();
           out.write_boolean ($result);
         } catch (auctionPack.InvalidOfferException $ex) {
           out = $rh.createExceptionReply ();
           auctionPack.InvalidOfferExceptionHelper.write (out, $ex);
         }
         break;
       }

       case 1:  // auction/Auction/sell
       {
         try {
           String itemName = in.read_string ();
           boolean $result = false;
           $result = this.sell (itemName);
           out = $rh.createReply();
           out.write_boolean ($result);
         } catch (auctionPack.InvalidSellException $ex) {
           out = $rh.createExceptionReply ();
           auctionPack.InvalidSellExceptionHelper.write (out, $ex);
         }
         break;
       }

       case 2:  // auction/Auction/viewHighBidder
       {
         try {
           String itemName = in.read_string ();
           String $result = null;
           $result = this.viewHighBidder (itemName);
           out = $rh.createReply();
           out.write_string ($result);
         } catch (auctionPack.InvalidSellException $ex) {
           out = $rh.createExceptionReply ();
           auctionPack.InvalidSellExceptionHelper.write (out, $ex);
         }
         break;
       }


  // bidder accessible methods
       case 3:  // auction/Auction/bid
       {
         try {
           String userId = in.read_string ();
           float bidPrice = in.read_float ();
           boolean $result = false;
           $result = this.bid (userId, bidPrice);
           out = $rh.createReply();
           out.write_boolean ($result);
         } catch (auctionPack.InvalidBidException $ex) {
           out = $rh.createExceptionReply ();
           auctionPack.InvalidBidExceptionHelper.write (out, $ex);
         }
         break;
       }

       case 4:  // auction/Auction/viewBidStatus
       {
         try {
           String userId = in.read_string ();
           String $result = null;
           $result = this.viewBidStatus (userId);
           out = $rh.createReply();
           out.write_string ($result);
         } catch (auctionPack.InvalidBidException $ex) {
           out = $rh.createExceptionReply ();
           auctionPack.InvalidBidExceptionHelper.write (out, $ex);
         }
         break;
       }


  // universally accessible methods
       case 5:  // auction/Auction/viewAuctionStatus
       {
         try {
           auctionPack.AuctionStatus $result = null;
           $result = this.viewAuctionStatus ();
           out = $rh.createReply();
           auctionPack.AuctionStatusHelper.write (out, $result);
         } catch (auctionPack.InvalidStatusException $ex) {
           out = $rh.createExceptionReply ();
           auctionPack.InvalidStatusExceptionHelper.write (out, $ex);
         }
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:auction/Auction:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Auction _this() 
  {
    return AuctionHelper.narrow(
    super._this_object());
  }

  public Auction _this(org.omg.CORBA.ORB orb) 
  {
    return AuctionHelper.narrow(
    super._this_object(orb));
  }


} // class AuctionPOA
