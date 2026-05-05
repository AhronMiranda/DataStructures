

import java.util.InputMismatchException;
import java.util.Scanner;

public class MIDTERMS {


        //TYPE DESIGN
        public static final String RED = "\033[0;31m";
        public static final String GREEN = "\033[0;32m";
        public static final String BLUE = "\033[0;34m";
        public static final String BOLD = "\u001B[1m";
        public static final String ITALIC = "\u001B[3m";
        public static final String RESET = "\033[0m";

        public static Scanner sc = new Scanner(System.in);

    public MIDTERMS(){}

    public void runMIDTERMS() {
                    BandData data = new BandData();
        while (true) {
            try {
            
            int answer = menu(); 

            switch (answer) {
                case 1:
                    System.out.println(BLUE + "[ADD A NEW BAND]\n" + RESET);
                    data.runAddBandData();
                    runMIDTERMS();
                    break;
                case 2:
                    System.out.println(BLUE + "[SEARCH]\n" + RESET);
                    data.runSearchBandData();
                    runMIDTERMS();
                    
                    break;
                case 3:
                    System.out.println(BLUE + "[EDIT]\n" + RESET);
                    data.runEditBandData();
                    runMIDTERMS();
                    
                    break;
                case 4:
                    System.out.println(BLUE + "[DELETE]\n" + RESET);
                    data.runDeleteBandData();
                    System.out.println(RED + "BAND HAS BEEN DELETED!" + RESET + BLUE + "\nPERFORMANCE IDs ARE KEPT TO AVOID CONFUSION BEFORE THE SHOW." + RESET);
                    runMIDTERMS();
                    
                    break;
                case 5:
                    System.out.println(BLUE + "[SORT]\n" + RESET);
                    data.runSortData();
                    runMIDTERMS();
                    
                    break;
                case 6:
                    System.out.println(BLUE + "[DISPLAYING REGISTERED MUSICAL ARTISTS AND BANDS]\n" + RESET);
                    data.runBandDataExtractionAndDisplay();
                    runMIDTERMS();
                    
                    break;
                case 0:
                    System.out.println("[BACK TO MAIN MENU]");
                    break;
                    
            }


            } catch (InputMismatchException e) {
                System.out.println(RED + "[ERROR]" + RESET + "INVALID ANSWER");
            }
            return;
            
        }
    
        
    } // MAIN

    public static int inputInt() {
    int tempInt = sc.nextInt();
    sc.nextLine();
    return tempInt;
    }


    public int menu() {
        System.out.println("""
                +----------------------------------------+
                |   LIST OF MUSICAL ARTISTS AND BANDS    |
                +----------------------------------------+

                [1] ADD
                [2] SEARCH
                [3] EDIT
                [4] DELETE
                [5] SORT LIST
                [6] DISPLAY LIST
                [0] BACK

                """);

                System.out.print("User>>");
                int answer = inputInt();

                return answer;
    }
}

