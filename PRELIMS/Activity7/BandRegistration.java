package Activity7;



import java.util.Scanner;

public class BandRegistration {

        //SCANNER
        public static Scanner sc = new Scanner(System.in);

        //TYPE DESIGN
        public static final String RED = "\033[0;31m";
        public static final String GREEN = "\033[0;32m";
        public static final String BLUE = "\033[0;34m";
        public static final String BOLD = "\u001B[1m";
        public static final String ITALIC = "\u001B[3m";
        public static final String RESET = "\033[0m";

    
    int iPerfID, iViewers;
    int count = 0;
    String strName, strGenre;
    double dStagePrice;
    char cUserAnswer = ' ';

    public BandRegistration(){}

    public void runBandRegistration() {
    System.out.println(RED + BOLD + "Register your Band or Favorite Artist" + RESET);

    System.out.println(GREEN + "=-=-=-=" + RESET + "\n");
    
    
    do {
    System.out.println(ITALIC + BLUE + "[Please Input the Following]" + RESET);
    
    while (true) {
        try {
    //STRINGS Name and Genre
    System.out.print("Artist Name: ");
    strName = inputString();
    System.out.print("Genre: ");
    strGenre = inputString();
    
    // INT Performance ID
    System.out.print("PerformanceID: ");
    iPerfID = inputInt();
    
    //DOUBLES Price of reserving the performer
    System.out.print("Stage Price: ");
    dStagePrice = inputDouble();


    //INT Average viewers
    System.out.print("Average Viewers: ");
    iViewers = inputInt();
    
    print(strName, strGenre, iPerfID, dStagePrice, iViewers);
    break;
        } catch (Exception e) {

            // YOU NEED TO RE-REGISTER IF YOU HAVE AN INVALID INPUT
            System.out.println(RED + BOLD + "[ERROR] " + e.getMessage() + RESET);
            System.out.print(BLUE + BOLD + "[TRY AGAIN FROM THE START]" + RESET + "\n");
            sc.nextLine();
        }
    }

    count++;
    System.out.println("---");
    System.out.print("Enter another Y/N: ");
    String strUserAnswer = inputString();
    cUserAnswer = strUserAnswer.charAt(0);
     System.out.println("---");


    } while (cUserAnswer == 'y' || cUserAnswer == 'Y');

    
    System.out.println(GREEN + count + " Music Artists registered today." + RESET);

    }

    public static String inputString() {
    String tempString = sc.nextLine();
    return tempString;
    }

    public static int inputInt() {
    int tempInt = sc.nextInt();
    sc.nextLine();
    return tempInt;
    }

    public static double inputDouble() {
    double tempDouble = sc.nextDouble();
    return tempDouble;
    }

    public static void print(String strName, String strGenre, int iPerfID, double dStagePrice, int iViewers) {
        System.out.println(RED + BOLD + "[REGISTER COMPLETE]\n" + RESET + "--- \nArtist Name: " + strName + " \nGenre: " + strGenre + " \nID: " + iPerfID + " \nReservation Price: " + dStagePrice + " \nAverage Viewers: " + iViewers);
        
    }
}