import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class MovieRegistration {

        public static Scanner sc = new Scanner(System.in);


        int rent = 0,  sales = 0,  comedy = 0,  Horror = 0,  Scifi = 0,  Drama = 0,  Cartoons = 0,  dvdTotal = 0,  vcdTotal = 0,  tapeTotal = 0;
        char cAnother = 'y';

    public MovieRegistration(){}

    public void runMovieRegistration() {
        while (true) {
        try {
        FileWriter terminal = new FileWriter("RunProgram.txt", true);
        terminal.write("Movie Registration Chosen\n");

        do {
        terminal.write("""
        Registration
        1. DVD
        2. VCD
        3. Tape
        """);
        
        System.out.println("""
        Registration
        1. DVD
        2. VCD
        3. Tape
        """);
        System.out.print("Choose: ");
        int chosen = sc.nextInt();
        terminal.write("Choose: no." + chosen + "\n");
        sc.nextLine();


        switch (chosen) {
            case 1:
                System.out.println("Type: DVD");
                terminal.write("Type: DVD" + "\n");
                dvdTotal++;
                break;
            case 2:
                System.out.println("Type: VCD");
                terminal.write("Type: VCD" + "\n");
                vcdTotal++;
                break;
            case 3:
                System.out.println("Type: Tape");
                terminal.write("Type: Tape" + "\n");
                tapeTotal++;
                break;
        }


        System.out.print("Input title: ");
        String title = sc.nextLine();
        terminal.write("Input title: " + title + "\n");

       
       


        System.out.println("""
        1. Horror
        2. Scifi
        3. Drama
        4. Comedy
        5. Cartoons
        """);

        terminal.write("""
        1. Horror
        2. Scifi
        3. Drama
        4. Comedy
        5. Cartoons

        """);



        System.out.print("Input category: ");
        int category = sc.nextInt();
        sc.nextLine();
        terminal.write("Input category: no. " + category + "\n");


        switch (category) {
            case 1:
                terminal.write("Category: Horror" + "\n");
                System.out.println("Category: Horror");
                Horror++;
                break;
            case 2:
                terminal.write("Category: Scifi" + "\n");
                System.out.println("Category: Scifi");
                Scifi++;
                break;
            case 3:
                terminal.write("Category: Drama" + "\n");
                System.out.println("Category: Drama");
                Drama++;
                break;
            case 4:
                terminal.write("Category: Comedy"+ "\n");
                System.out.println("Category: Comedy");
                comedy++;
                break;
            case 5:
                terminal.write("Category: Cartoons" + "\n");
                System.out.println("Category: Cartoons");
                Cartoons++;
                break;
        }


        System.out.print("Input minutes: ");
        double minutes = sc.nextDouble();
        sc.nextLine();


        System.out.print("Input setting: ");
        String setting = sc.nextLine();

        terminal.write("Input Minutes: " + minutes + "\nInput Setting: " + setting + "\n");
       


        System.out.println();
        System.out.println("""
        1. Rental
        2. Sales
        """);
        terminal.write("""
        1. Rental
        2. Sales
        """);


        System.out.print("Input transaction type: ");
        int transactionType = sc.nextInt();
        sc.nextLine();
        terminal.write("Input transaction type: no." + transactionType + "\n");


        switch (transactionType) {
            case 1:
            terminal.write("Input transaction type: Rent" + "\n");
                rent++;
                break;
            case 2:
            terminal.write("Input transaction type: Sales" + "\n");

                sales++;
                break;
        }


        System.out.print("Input price: ");
        int price = sc.nextInt();
        sc.nextLine();

            terminal.write("Input price: " + price + "\n");



        System.out.println("Register Another? (Y/N)");
        String sAnother = sc.nextLine();
       
        cAnother = sAnother.charAt(0);
        terminal.write("Register Another? (Y/N)\nuser: " + cAnother + "\n");



        } while (cAnother == 'y' || cAnother == 'Y') ;


       
    System.out.println("REPORTS");
    terminal.write("REPORTS");
            System.out.printf("""
                    For rent: %d
                    For Sale: %d
                    VCD Total: %d
                    DVD Total: %d
                    Tape Total: %d
                    Horror Movies: %d
                    Scifi Movies: %d
                    Drama Movies: %d
                    comedy Movies: %d
                    Cartoons: %d
                    """, rent, sales, vcdTotal, dvdTotal, tapeTotal, Horror, Scifi, Drama, comedy, Cartoons);

            terminal.write(String.format("""
                    For rent: %d
                    For Sale: %d
                    VCD Total: %d
                    DVD Total: %d
                    Tape Total: %d
                    Horror Movies: %d
                    Scifi Movies: %d
                    Drama Movies: %d
                    comedy Movies: %d
                    Cartoons: %d
                    """, rent, sales, vcdTotal, dvdTotal, tapeTotal, Horror, Scifi, Drama, comedy, Cartoons));


            terminal.close();
            break;

            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("[ERROR] File not Found.");
            } catch (InputMismatchException e) {
                System.out.println("[ERROR] Wrong Input REDO!!");
            }
        }

        } //Run
}
