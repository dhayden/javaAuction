package auctionPack;


/**
* auction/_AuctionStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Auction.idl
* Wednesday, April 8, 2015 12:02:34 AM CDT
*/

public class _AuctionStub extends org.omg.CORBA.portable.ObjectImpl implements auctionPack.Auction
{


  // seller accessible methods
  public boolean offer (String sellerId, String item, float initPrice) throws auctionPack.InvalidOfferException
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("offer", true);
                $out.write_string (sellerId);
                $out.write_string (item);
                $out.write_float (initPrice);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:auction/Auction/InvalidOfferException:1.0"))
                    throw auctionPack.InvalidOfferExceptionHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return offer (sellerId, item, initPrice        );
            } finally {
                _releaseReply ($in);
            }
  } // offer

  public boolean sell (String itemName) throws auctionPack.InvalidSellException
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("sell", true);
                $out.write_string (itemName);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:auction/Auction/InvalidSellException:1.0"))
                    throw auctionPack.InvalidSellExceptionHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return sell (itemName        );
            } finally {
                _releaseReply ($in);
            }
  } // sell

  public String viewHighBidder (String itemName) throws auctionPack.InvalidSellException
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("viewHighBidder", true);
                $out.write_string (itemName);
                $in = _invoke ($out);
                String $result = $in.read_string ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:auction/Auction/InvalidSellException:1.0"))
                    throw auctionPack.InvalidSellExceptionHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return viewHighBidder (itemName        );
            } finally {
                _releaseReply ($in);
            }
  } // viewHighBidder


  // bidder accessible methods
  public boolean bid (String userId, float bidPrice) throws auctionPack.InvalidBidException
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("bid", true);
                $out.write_string (userId);
                $out.write_float (bidPrice);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:auction/Auction/InvalidBidException:1.0"))
                    throw auctionPack.InvalidBidExceptionHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return bid (userId, bidPrice        );
            } finally {
                _releaseReply ($in);
            }
  } // bid

  public String viewBidStatus (String userId) throws auctionPack.InvalidBidException
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("viewBidStatus", true);
                $out.write_string (userId);
                $in = _invoke ($out);
                String $result = $in.read_string ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:auction/Auction/InvalidBidException:1.0"))
                    throw auctionPack.InvalidBidExceptionHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return viewBidStatus (userId        );
            } finally {
                _releaseReply ($in);
            }
  } // viewBidStatus


  // universally accessible methods
  public auctionPack.AuctionStatus viewAuctionStatus () throws auctionPack.InvalidStatusException
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("viewAuctionStatus", true);
                $in = _invoke ($out);
                auctionPack.AuctionStatus $result = auctionPack.StatusHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:auction/Auction/InvalidStatusException:1.0"))
                    throw auctionPack.InvalidStatusExceptionHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return viewAuctionStatus (        );
            } finally {
                _releaseReply ($in);
            }
  } // viewAuctionStatus

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:auction/Auction:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }

  private void readObject (java.io.ObjectInputStream s) throws java.io.IOException
  {
     String str = s.readUTF ();
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     org.omg.CORBA.Object obj = orb.string_to_object (str);
     org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate ();
     _set_delegate (delegate);
   } finally {
     orb.destroy() ;
   }
  }

  private void writeObject (java.io.ObjectOutputStream s) throws java.io.IOException
  {
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     String str = orb.object_to_string (this);
     s.writeUTF (str);
   } finally {
     orb.destroy() ;
   }
  }
} // class _AuctionStub
