package auctionPack;

/**
* auction/AuctionPackage/AuctionStatusHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Auction.idl
* Wednesday, April 8, 2015 12:02:34 AM CDT
*/

public final class AuctionStatusHolder implements org.omg.CORBA.portable.Streamable
{
  public auctionPack.AuctionStatus value = null;

  public AuctionStatusHolder ()
  {
  }

  public AuctionStatusHolder (auctionPack.AuctionStatus initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = auctionPack.AuctionStatusHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
        auctionPack.AuctionStatusHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return auctionPack.AuctionStatusHelper.type ();
  }

}
