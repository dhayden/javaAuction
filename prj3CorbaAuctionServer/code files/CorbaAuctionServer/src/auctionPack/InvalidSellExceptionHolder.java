package auctionPack;

/**
* auction/AuctionPackage/InvalidSellExceptionHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Auction.idl
* Wednesday, April 8, 2015 12:02:34 AM CDT
*/

public final class InvalidSellExceptionHolder implements org.omg.CORBA.portable.Streamable
{
  public auctionPack.InvalidSellException value = null;

  public InvalidSellExceptionHolder ()
  {
  }

  public InvalidSellExceptionHolder (auctionPack.InvalidSellException initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = auctionPack.InvalidSellExceptionHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
        auctionPack.InvalidSellExceptionHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return auctionPack.InvalidSellExceptionHelper.type ();
  }

}
