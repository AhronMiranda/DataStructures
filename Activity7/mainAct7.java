package Activity7;

import java.util.InputMismatchException;
import java.util.Scanner;

public class mainAct7 {
    public static void main(String[] args) {
        int answer = 0;
        boolean run = true;

        Scanner sc = new Scanner(System.in);
        System.out.println("""
                Welcome to EFM Enterprise Systems
                We've got it all for you!

                Please choose one of the following:
                1. EFM Grocery
                2. Movie Registration
                3. Movie Rental
                4. Band Registration
                5. Exit

                """);
            
            while (run) {
                System.out.print("User>> ");
            
            try {
                answer = sc.nextInt();
                sc.nextLine();
       
            } catch (InputMismatchException e) {
                System.out.println("Invalid number");
            } 

        
        switch (answer) {

        case 1 :
                GroceryEFM grocery = new GroceryEFM();
                grocery.runGroceryEFM();
                break;
        case 2 :
                MovieRegistration movie = new MovieRegistration();
                movie.runMovieRegistration();
                break;
        case 3 :
                MovieRental movieRent = new MovieRental();
                movieRent.runMovieRental();
                break;
        case 4 :
                BandRegistration band = new BandRegistration();
                band.runBandRegistration();
                break;
        case 5 :
                System.out.println("Exiting...");
                run = false;
                break;
        }
    }

    System.out.println("Thank you for availing our services!!!");
    System.out.println("GOODBYE!!!");
    }
}