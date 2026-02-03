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
                System.out.println("You have chosen EFM Grocery");
                GroceryEFM grocery = new GroceryEFM();
                grocery.runGroceryEFM();
                break;
        case 2 :
                System.out.println("You have chosen Movie Registration");
                MovieRegistration movie = new MovieRegistration();
                movie.runMovieRegistration();
                break;
        case 3 :
                System.out.println("You have chosen Movie Rental");
                MovieRental movieRent = new MovieRental();
                movieRent.runMovieRental();
                break;
        case 4 :
                System.out.println("You have chosen Band Registration");
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