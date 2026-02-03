import java.util.Scanner;


public class Activity3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int rent = 0,  sales = 0,  comedy = 0,  Horror = 0,  Scifi = 0,  Drama = 0,  Cartoons = 0,  dvdTotal = 0,  vcdTotal = 0,  tapeTotal = 0;
        char cAnother = 'y';




        do {
        System.out.println("""
        Registration
        1. DVD
        2. VCD
        3. Tape
        """);
        System.out.print("Choose: ");
        int chosen = sc.nextInt();
        sc.nextLine();


        switch (chosen) {
            case 1:
                System.out.println("Type: DVD");
                dvdTotal++;
                break;
            case 2:
                System.out.println("Type: VCD");
                vcdTotal++;
                break;
            case 3:
                System.out.println("Type: Tape");
                tapeTotal++;
                break;
        }


        System.out.print("Input title: ");
        String title = sc.nextLine();
       
       


        System.out.println("""
        1. Horror
        2. Scifi
        3. Drama
        4. Comedy
        5. Cartoons
        """);


        System.out.print("Input category: ");
        int category = sc.nextInt();
        sc.nextLine();


        switch (category) {
            case 1:
                Horror++;
                break;
            case 2:
                Scifi++;
                break;
            case 3:
                Drama++;
                break;
            case 4:
                comedy++;
                break;
            case 5:
                Cartoons++;
                break;
        }


        System.out.print("Input minutes: ");
        double minutes = sc.nextDouble();
        sc.nextLine();


        System.out.print("Input setting: ");
        String setting = sc.nextLine();
       


        System.out.println();
        System.out.println("""
        1. Rental
        2. Sales
        """);


        System.out.print("Input transaction type: ");
        int transactionType = sc.nextInt();
        sc.nextLine();


        switch (transactionType) {
            case 1:
                rent++;
                break;
            case 2:
                sales++;
                break;
        }


        System.out.print("Input price: ");
        int price = sc.nextInt();
        sc.nextLine();


        System.out.println("Register Another? (Y/N)");
        String sAnother = sc.nextLine();
       
        cAnother = sAnother.charAt(0);


        } while (cAnother == 'y' || cAnother == 'Y') ;


       
    System.out.println("REPORTS");
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






        } //Run
}
