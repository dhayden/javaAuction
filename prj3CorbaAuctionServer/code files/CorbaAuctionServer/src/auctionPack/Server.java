
package auctionPack;
import org.omg.CORBA.*;
import org.omg.CosNaming.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;

//ref: https://docs.oracle.com/javase/8/docs/technotes/guides/idl/jidlTieServer.html

public class Server {

  public static void main(String args[]) {
    try{
      ORB orb = ORB.init(args, null);

      AuctionImpl impl = new AuctionImpl(orb);

      POA rootpoa = POAHelper.narrow(
        orb.resolve_initial_references("RootPOA"));
      rootpoa.the_POAManager().activate();

      org.omg.CORBA.Object ref = 
        rootpoa.servant_to_reference(impl);
      Auction href = AuctionHelper.narrow(ref);

      org.omg.CORBA.Object objRef = 
        orb.resolve_initial_references("NameService");

      NamingContextExt ncRef = 
        NamingContextExtHelper.narrow(objRef);

      String name = "Auction";
      NameComponent path[] = ncRef.to_name( name );
      ncRef.rebind(path, href);

      System.out.println("Auction Server ready ....");

      orb.run();
    } catch (Exception e) {
        System.err.println("ERROR: " + e);
        e.printStackTrace(System.out);
    }
    System.out.println("Auction Server Exiting ....");
  }
}
