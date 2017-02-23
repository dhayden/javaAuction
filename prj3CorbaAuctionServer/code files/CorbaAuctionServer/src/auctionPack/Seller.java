// Seller code
package auctionPack;
import org.omg.CORBA.*;
import org.omg.CosNaming.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContextPackage.*;

public class Seller {

    public static void main(String args[]) {
        try {

            ORB orb = ORB.init(args, null);

            org.omg.CORBA.Object objRef
                    = orb.resolve_initial_references("NameService");

            NamingContextExt ncRef
                    = NamingContextExtHelper.narrow(objRef);

            String name = "Auction";
            Auction impl;
            impl = AuctionHelper.narrow(ncRef.resolve_str(name));

            int response = 0;

            while (response != 5) {
                //menu
                System.out.println("\t....menu.........\\n\n");
                System.out.println("\t1. Sell stuff\n");
                System.out.println("\t2. submit sell\n");
                System.out.println("\t3. Highest bidder\n");
                System.out.println("\t4. Status\n");
                System.out.println("\t5. Quit\n");

                System.out.print("Please enter choice 1, 2, 3 or 4 : ");

                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String prompt = br.readLine();

                response = Integer.parseInt(prompt);

                if (response == 1) //put an item to sell
                {
                    try {
                        System.out.print("Enter your ID: ");
                        String id = br.readLine();
                        System.out.print("Enter Item Name: ");
                        String iName = br.readLine();
                        System.out.print("Enter offer Price: ");
                        String strPrice = br.readLine();
                        float iPrice = Float.parseFloat(strPrice);
                        boolean success = impl.offer(id, iName, iPrice);
                        if (success == true) {
                            System.out.println("Your submission was successful.\n");
                        } else {
                            System.out.println("Please try again later.");
                        }

                    } catch (Exception e) {
                        System.out.println(e);
                    }
                } else if (response == 2) //make a  sell
                {
                    try {
                        System.out.print("Sell this item (y/n?) ");
                        String prompt1 = br.readLine();
                        System.out.print(prompt1);
                        String choice1 = br.readLine().toLowerCase();

                        if (choice1.startsWith("y")) {
                            try {
                                System.out.print("Item Name: ");
                                String i = br.readLine();
                                boolean success = impl.sell(i);
                            } catch (IOException | InvalidSellException e) {
                                System.out.println(e);
                            }
                        }
                    } catch (Exception e) {
                        System.out.println(e);
                        System.exit(1);
                    }

                } else if (response == 3) //view high bidder
                {
                    try {
                        System.out.print("Item Name: ");
                        String it = br.readLine();
                        String message = impl.viewHighBidder(it);
                        System.out.println(message);

                    } catch (IOException | InvalidSellException e) {
                        System.out.println(e);
                    }
                } else if (response == 4) //view auction status
                {
                    auctionPack.AuctionStatus status;
                    status = new auctionPack.AuctionStatus();
                    status = impl.viewAuctionStatus();
                    String message = "User id:" + status.user + " Item: " + status.item
                            + " Price: " + status.currentPrice + " is the highest bidder";
                    System.out.println(message);
                } else if (response == 5) //put an item to sell
                {
                    System.exit(1);
                }
            }

        } catch (InvalidName | NotFound | CannotProceed | org.omg.CosNaming.NamingContextPackage.InvalidName | IOException | NumberFormatException | InvalidStatusException e) {
            System.out.println("ERROR : " + e);
            e.printStackTrace(System.out);
        }
    }
}
