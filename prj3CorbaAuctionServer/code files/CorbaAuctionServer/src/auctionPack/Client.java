/*
 code for client
 */
package auctionPack;
import org.omg.CORBA.*;
import org.omg.CosNaming.*;
import java.io.*;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;

public class Client {

    public static void main(String args[]) {
        try {
            
            ORB orb = ORB.init(args, null);

            org.omg.CORBA.Object objRef
                    = orb.resolve_initial_references("NameService");
  
            NamingContextExt ncRef
                    = NamingContextExtHelper.narrow(objRef);

            String name = "Auction";
            auctionPack.Auction impl = AuctionHelper.narrow(ncRef.resolve_str(name));

            int response = 0;

            while (response != 4) {
                //menu
                System.out.println("\t======= Acution Menu ========\n");
                System.out.println("\t1. Auction Status\n");
                System.out.println("\t2. bid\n");
                System.out.println("\t3. Bid Status\n");
                System.out.println("\t4. Quit\n");
                System.out.print("Choose 1, 2, 3 or 4 : ");
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String prompt = br.readLine();
                response = Integer.parseInt(prompt);

                if (response == 1) //view auction status
                {
                    auctionPack.AuctionStatus status;
                    status = new auctionPack.AuctionStatus();
                    status = impl.viewAuctionStatus();
                    String message = "User id:" + status.user + " Item: " + status.item
                            + " Price: " + status.currentPrice + " is the highest bidder\n";
                    System.out.println(message);
                } else if (response == 2) //bid
                {
                    try {
                        System.out.print("Enter user ID: ");
                        String userId = br.readLine();
                        System.out.print("Offer Price : ");
                        String strOffer = br.readLine();
                        float offer = Float.parseFloat(strOffer);
                        boolean bid_now = impl.bid(userId, offer);
                        if (bid_now == true) {
                            System.out.println("Successfull bid \n");
                        } else {
                            System.out.println("Please increase your price \n");
                        }
                    } catch (IOException | NumberFormatException | InvalidBidException e) {
                        System.out.println(e);
                    }
                } else if (response == 3) 
                {
                    try {
                        System.out.print("Type your ID: ");
                        String id = br.readLine();
                        String msg = impl.viewBidStatus(id);
                        System.out.println(msg + "\n");
                    } catch (IOException | InvalidBidException e) {
                        System.out.println(e);
                    }
                }

            }

        } catch (InvalidName | NotFound | CannotProceed | org.omg.CosNaming.NamingContextPackage.InvalidName | IOException | NumberFormatException | InvalidStatusException e) {
            System.out.println("ERROR : " + e);
            e.printStackTrace(System.out);
        }
    }
}
