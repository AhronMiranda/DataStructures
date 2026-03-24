

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

        //TYPE DESIGN
        public static final String RED = "\033[0;31m";
        public static final String GREEN = "\033[0;32m";
        public static final String BLUE = "\033[0;34m";
        public static final String BOLD = "\u001B[1m";
        public static final String ITALIC = "\u001B[3m";
        public static final String RESET = "\033[0m";
    public static void main(String[] args) {
        int answer = 0;
        boolean run = true;

        Scanner sc = new Scanner(System.in);
        while (run) {
        System.out.println("""
            
                +---------------------------------------+
                |   Welcome to Ahron's Code Systems     |
                | ======================================|             
                |                                       |
                | Please choose one of the following:   |
                | 1. EFM Grocery                        |    (1. PRELIMS)
                | 2. Movie Registration                 |    (2. PRELIMS)
                | 3. Movie Rental                       |    (3. PRELIMS)
                | 4. Band Registration                  |    (4. PRELIMS NO FILE SAVING)
                | 5. Extract Saved Bands                |    (5. MIDTERMS)
                | 6. Musical Artists Menu               |    (6. MIDTERMS)
                | 0. Exit                               |
                +---------------------------------------+
        
                """);
            
            
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
                System.out.println(GREEN + "Displaying Saved Bands\n" + RESET);
                BandData data = new BandData();
                data.runBandDataExtractionAndDisplay();
                break;
        case 6 :
                MIDTERMS md = new MIDTERMS();
                md.runMIDTERMS();
                break;
        case 0 :
                System.out.println("Exiting...");
                run = false;
                break;
        }
       
    }

    System.out.println(GREEN + "Thank you for availing our services!!!" + RESET);
    
    }
}