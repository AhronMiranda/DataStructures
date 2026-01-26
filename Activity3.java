package week3.DataStructures;

import java.util.Scanner;

public class Activity3 {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
    int iProdID;
    String strProdName, strProdDesc;
    double dQty, dPrice, dDiscount;

    
    System.out.println("Please Input the Following");
    // INT Product ID
    System.out.print("ProductID: ");
    iProdID = inputInt();

    //STRINGS Name and Description
    System.out.print("Name: ");
    strProdName = inputString();
    System.out.print("Description: ");
    strProdDesc = inputString();


    //DOUBLES Quantity, Price, Discount
    System.out.print("Quantity: ");
    dQty = inputDouble();
    System.out.print("Price: ");
    dPrice = inputDouble();
    System.out.print("Discount: ");
    dDiscount = inputDouble();
    

    double dSubTotal = computeSubtotal(dPrice, dQty, dDiscount);

    displayDetails(iProdID, strProdName, dPrice, dQty, dDiscount, dSubTotal, strProdDesc);;
    


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

    public static void displayDetails(int ProdID, String ProdName, double price, double quantity, double discount, double subtotal, String description) {
        System.out.println(ProdID + ProdName + "\nPriced at "  + price + " for " + quantity + " pieces\nDiscounted at " + discount + "\nSubtotal:" + subtotal + "\n\nFor:" + description);
        
    }
}
