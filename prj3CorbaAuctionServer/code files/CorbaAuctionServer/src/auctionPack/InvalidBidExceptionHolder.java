package auctionPack;

/**
* auction/AuctionPackage/InvalidBidExceptionHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Auction.idl
* Wednesday, April 8, 2015 12:02:34 AM CDT
*/

public final class InvalidBidExceptionHolder implements org.omg.CORBA.portable.Streamable
{
  public auctionPack.InvalidBidException value = null;

  public InvalidBidExceptionHolder ()
  {
  }

  public InvalidBidExceptionHolder (auctionPack.InvalidBidException initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = auctionPack.InvalidBidExceptionHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
        auctionPack.InvalidBidExceptionHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return auctionPack.InvalidBidExceptionHelper.type ();
  }

}