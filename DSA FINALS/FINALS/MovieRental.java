import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MovieRental {
    public static Scanner sc = new Scanner(System.in);

    int iProdID;
    String strProdName, strProdDesc;
    double dQty, dPrice, dDiscount;

    public MovieRental() {
    }

    public void runMovieRental() {
        try (FileWriter terminal = new FileWriter("RunProgram.txt", true)) {
            terminal.write("MOVIE RENTAL CHOSEN \n");

            System.out.println("Please Input the Following");
            terminal.write("Please Input the Following \n");
            // INT Product ID
            System.out.print("ProductID: ");
            iProdID = inputInt();
            terminal.write("ProductID: " + iProdID + "\n");

            // STRINGS Name and Description
            System.out.print("Name: ");
            strProdName = inputString();
            System.out.print("Description: ");
            strProdDesc = inputString();

            terminal.write("Name: " + strProdName + "\nDescription: " + strProdDesc + "\n");

            // DOUBLES Quantity, Price, Discount
            System.out.print("Quantity: ");
            dQty = inputDouble();
            System.out.print("Price: ");
            dPrice = inputDouble();
            System.out.print("Discount: ");
            dDiscount = inputDouble();

            terminal.write("Quanitity: " + dQty + "\nPrice: " + dPrice + "\nDiscount: " + dDiscount + "\n");

            double dSubTotal = computeSubtotal(dPrice, dQty, dDiscount);

            System.out.println(displayDetails(iProdID, strProdName, dPrice, dQty, dDiscount, dSubTotal, strProdDesc));
            terminal.write(
                    displayDetails(iProdID, strProdName, dSubTotal, dSubTotal, dSubTotal, dSubTotal, strProdDesc));

            terminal.close();
        } catch (IOException e) {
            System.out.println("[ERROR FILE NOT FOUND]");
        }

    }

    public static String inputString() {
        String temString = sc.nextLine();
        return temString;
    }

    public static int inputInt() {
        int ProdID = sc.nextInt();
        sc.nextLine();
        return ProdID;
    }

    public static double inputDouble() {
        double tempDouble = sc.nextDouble();
        return tempDouble;
    }

    public static double computeSubtotal(double price, double quantity, double discount) {
        double subTotal = (price * quantity) - discount;
        return subTotal;
    }

    public static String displayDetails(int ProdID, String ProdName, double price, double quantity, double discount,
            double subtotal, String description) {
        return ProdID + " " + ProdName + "\nPriced at " + price + " for " + quantity + " pieces\nDiscounted at "
                + discount + "\nSubtotal:" + subtotal + "\n\nAbout:" + description;

    }

}