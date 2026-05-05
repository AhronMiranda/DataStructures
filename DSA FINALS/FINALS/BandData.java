import java.util.*;
import java.io.*;
public class BandData {
	
	    
        //TYPE DESIGN
        public static final String RED = "\033[0;31m";
        public static final String GREEN = "\033[0;32m";
        public static final String BLUE = "\033[0;34m";
        public static final String BOLD = "\u001B[1m";
        public static final String ITALIC = "\u001B[3m";
        public static final String RESET = "\033[0m";

        
        
        

        public BandData() {}
        
        public static Scanner sc=new Scanner(System.in);

        public void runBandDataExtractionAndDisplay() {
            
        
            
    try {
        File file = new File("musicalArtists.txt");
        Scanner FR = new Scanner(file);
        FileWriter terminal = new FileWriter("RunProgram.txt", true);

        String[] aNames = new String[50];
        String[] aGenre = new String[50];
        int[] aPerfID = new int[50];
        int[] aViewers = new int[50];
        double[] aStagePrice = new double[50];
        int ctr = 0;

        while (FR.hasNextLine()) {
            aNames[ctr] = FR.nextLine();     
            if (!FR.hasNextLine()) break;
            aGenre[ctr] = FR.nextLine();       
            if (!FR.hasNextInt()) break;
            aPerfID[ctr] = FR.nextInt(); FR.nextLine();
            if (!FR.hasNextDouble()) break;
            aStagePrice[ctr] = FR.nextDouble(); FR.nextLine();
            if (!FR.hasNextInt()) break;
            aViewers[ctr] = FR.nextInt(); FR.nextLine();
            ctr++;
        }

        for (int a = 0; a < ctr; a++) {
            System.out.printf("%-2d | Stage Name: %-20s | Genres: %-20s | PERFORMANCE ID: %3d | Average Price: $ %-15.2f | Average Viewers: %-10d\n",
                a + 1, aNames[a], aGenre[a], aPerfID[a], aStagePrice[a], aViewers[a]);

            terminal.write(String.format("%-2d | Stage Name: %-20s | Genres: %-20s | PERFORMANCE ID: %3d | Average Price: $ %-15.2f | Average Viewers: %-10d\n",
                a + 1, aNames[a], aGenre[a], aPerfID[a], aStagePrice[a], aViewers[a]));
        }
        terminal.write("Program Displayed the Updated List this Run\n");
        terminal.close();
        FR.close();
    } catch (IOException e) {
        System.out.println("[ERROR] File not found");
    }
}


    public void runAddBandData(){
        
         try {
        FileWriter terminal = new FileWriter("RunProgram.txt", true);
        FileWriter FW = new FileWriter("musicalArtists.txt", true);
        char cAgain;
	    String sAgain;
	    

        String[] aNames = new String[100];
        String[] aGenre = new String[100];
        int[] aPerfID = new int[100];
        int[] aViewers = new int[100];
        double[] aStagePrice = new double[100];
        int ctr = 0;


        do{
	       
	        System.out.print("Name: "); aNames[ctr]= inputString();
	        System.out.print("Genre: "); aGenre[ctr]= inputString();
	        System.out.print("Performance ID: "); aPerfID[ctr]= inputInt();
	        System.out.print("Stage Price: "); aStagePrice[ctr]= inputDouble();
	        System.out.print("Average Viewers: "); aViewers[ctr]= inputInt();
	        



	        System.out.print(  RED + "Add Again?" + RESET + " (Y/N) \nUser>> ");
	        sAgain= inputString();
	        cAgain=sAgain.charAt(0);
	        ctr++;
	    } while((cAgain=='Y') || (cAgain=='y'));
	     for (int a = 0; a < ctr; a++) {
            FW.write(aNames[a]+"\n");
	        FW.write(aGenre[a]+"\n");
	        FW.write(aPerfID[a]+"\n");
	        FW.write(aStagePrice[a]+"\n");
	        FW.write(aViewers[a]+"\n");
        }
        
        terminal.write("Program Added to the List\n");
        terminal.close();

	    FW.close();
        
        
    } catch (IOException e) {
        System.out.println("[ERROR] File not found");
    }
    runBandDataExtractionAndDisplay();
    } // ADD

    public void runSearchBandData(){
       try {
        FileWriter terminal = new FileWriter("RunProgram.txt", true);

        File file = new File("musicalArtists.txt");
        Scanner FR = new Scanner(file);

        String[] aNames = new String[50];
        String[] aGenre = new String[50];
        int[] aPerfID = new int[50];
        int[] aViewers = new int[50];
        double[] aStagePrice = new double[50];
        int ctr = 0;

        while (FR.hasNextLine()) {
            aNames[ctr] = FR.nextLine();       
            if (!FR.hasNextLine()) break;
            aGenre[ctr] = FR.nextLine();       
            if (!FR.hasNextInt()) break;
            aPerfID[ctr] = FR.nextInt(); FR.nextLine();
            if (!FR.hasNextDouble()) break;
            aStagePrice[ctr] = FR.nextDouble(); FR.nextLine();
            if (!FR.hasNextInt()) break;
            aViewers[ctr] = FR.nextInt(); FR.nextLine();
            ctr++;
        }

        

        

        System.out.print("(Start at 1) Display band no.>> "); //Start from 1
        int a = inputInt() - 1;
            System.out.printf("%-2d | Stage Name: %-20s | Genres: %-20s | PERFORMANCE ID: %2d | Average Price: $ %-15.2f | Average Viewers: %-10d\n",
                a + 1, aNames[a], aGenre[a], aPerfID[a], aStagePrice[a], aViewers[a]);
            System.out.printf(BLUE + "[DISPLAYED BAND NO %d]\n" + RESET, a + 1);
            System.out.println();


        terminal.write("Program Searched the List\n");
        terminal.close();
        FR.close();
    } catch (IOException e) {
        System.out.println(RED + "[ERROR] File not found" + RESET);
    } catch (ArrayIndexOutOfBoundsException e) {
        System.out.println(RED + "[ERROR] Data Location is out of bounds" + RESET);
    }
    } // SEARCH

    public void runEditBandData(){
       try {
        FileWriter terminal = new FileWriter("RunProgram.txt", true);

        File file = new File("musicalArtists.txt");
        Scanner FR = new Scanner(file);

        String[] aNames = new String[50];
        String[] aGenre = new String[50];
        int[] aPerfID = new int[50];
        int[] aViewers = new int[50];
        double[] aStagePrice = new double[50];
        int ctr = 0;
        String strAnsw = null;
        char cAnsw;

        while (FR.hasNextLine()) {
            aNames[ctr] = FR.nextLine();       
            if (!FR.hasNextLine()) break;
            aGenre[ctr] = FR.nextLine();       
            if (!FR.hasNextInt()) break;
            aPerfID[ctr] = FR.nextInt(); FR.nextLine();
            if (!FR.hasNextDouble()) break;
            aStagePrice[ctr] = FR.nextDouble(); FR.nextLine();
            if (!FR.hasNextInt()) break;
            aViewers[ctr] = FR.nextInt(); FR.nextLine();
            ctr++;
        }

        

        

        System.out.print("(Start at 1) Edit band no.>> "); //Start from 1
        int a = inputInt() - 1;

        if (aNames[a] != null) {
            System.out.printf("%-2d | Stage Name: %-20s | Genres: %-20s | PERFORMANCE ID: %2d | Average Price: $ %-15.2f | Average Viewers: %-10d\n",
                a + 1, aNames[a], aGenre[a], aPerfID[a], aStagePrice[a], aViewers[a]);
            System.out.printf(BLUE + "[DISPLAYED BAND NO %d]\n" + RESET, a + 1);
            System.out.println();
        } else {
            System.out.println(RED + "[ERROR] Data Location is out of bounds" + RESET);
            System.out.println(RED + "THESE ARE THE ONLY BANDS REGISTERED" + RESET);
            strAnsw = "n";
        }

        if (strAnsw == null) {
        System.out.printf("\n(Y/N) Do you want to edit band info of Band no. %d>>", a + 1);
        strAnsw = inputString();
        }
        
        cAnsw = strAnsw.charAt(0);

        if (cAnsw == 'y' || cAnsw == 'Y') {
            System.out.print("Name: "); aNames[a]= inputString();
	        System.out.print("Genre: "); aGenre[a]= inputString();
	        System.out.print("Performance ID: "); aPerfID[a]= inputInt();
	        System.out.print("Stage Price: "); aStagePrice[a]= inputDouble();
	        System.out.print("Average Viewers: "); aViewers[a]= inputInt();

            FileWriter FW = new FileWriter("musicalArtists.txt");

            for (int i = 0; i < ctr; i++) {
                FW.write(aNames[i] + "\n");
                FW.write(aGenre[i] + "\n");
                FW.write(aPerfID[i] + "\n");
                FW.write(aStagePrice[i] + "\n");
                FW.write(aViewers[i] + "\n");
            }
            
            FW.close();
        } else {
            System.out.println("OK BACK TO MENU");
        }
        terminal.write("Program Edited the List\n");
        terminal.close();
        FR.close();
        runBandDataExtractionAndDisplay();
    } catch (IOException e) {
        System.out.println(RED + "[ERROR] File not found" + RESET);
    } catch (ArrayIndexOutOfBoundsException e) {
        System.out.println(RED + "[ERROR] Data Location is out of bounds" + RESET);
    }
    } // EDIT

    public void runDeleteBandData(){
       try {
        FileWriter terminal = new FileWriter("RunProgram.txt", true);

        File file = new File("musicalArtists.txt");
        Scanner FR = new Scanner(file);

        String[] aNames = new String[50];
        String[] aGenre = new String[50];
        int[] aPerfID = new int[50];
        int[] aViewers = new int[50];
        double[] aStagePrice = new double[50];
        int ctr = 0;
        String strAnsw = null;
        char cAnsw;

        while (FR.hasNextLine()) {
            aNames[ctr] = FR.nextLine();       
            if (!FR.hasNextLine()) break;
            aGenre[ctr] = FR.nextLine();       
            if (!FR.hasNextInt()) break;
            aPerfID[ctr] = FR.nextInt(); FR.nextLine();
            if (!FR.hasNextDouble()) break;
            aStagePrice[ctr] = FR.nextDouble(); FR.nextLine();
            if (!FR.hasNextInt()) break;
            aViewers[ctr] = FR.nextInt(); FR.nextLine();
            ctr++;
        }

        

        

        System.out.print("(Start at 1) Delete band no.>> "); //Start from 1
        int a = inputInt() - 1;

        if (aNames[a] != null) {
            System.out.printf("%-2d | Stage Name: %-20s | Genres: %-20s | PERFORMANCE ID: %2d | Average Price: $ %-15.2f | Average Viewers: %-10d\n",
                a + 1, aNames[a], aGenre[a], aPerfID[a], aStagePrice[a], aViewers[a]);
            System.out.printf(BLUE + "[DISPLAYED BAND NO %d]\n" + RESET, a + 1);
            System.out.println();
        } else {
            System.out.println(RED + "[ERROR] Data Location is out of bounds" + RESET);
            runBandDataExtractionAndDisplay();
            System.out.println(RED + "THESE ARE THE ONLY BANDS REGISTERED" + RESET);
            strAnsw = "n";
        }

        if (strAnsw == null) {
        System.out.printf("\n(Y/N) Do you want to edit band info of Band no. %d>>", a + 1);
        strAnsw = inputString();
        }
        
        cAnsw = strAnsw.charAt(0);

        if (cAnsw == 'y' || cAnsw == 'Y') {
            aNames[a]= null;

            FileWriter FW = new FileWriter("musicalArtists.txt");

            for (int i = 0; i < ctr; i++) {
                if (aNames[i] == null) { continue; } //skips round once deleted part is skipped so it wont write

                FW.write(aNames[i] + "\n");
                FW.write(aGenre[i] + "\n");
                FW.write(aPerfID[i] + "\n");
                FW.write(aStagePrice[i] + "\n");
                FW.write(aViewers[i] + "\n");
            }

            FW.close();
        } else {
            System.out.println("OK BACK TO MENU");
        }
        terminal.write("Program Deleted data on the List\n");
        terminal.close();
        FR.close();
        runBandDataExtractionAndDisplay();
    } catch (IOException e) {
        System.out.println(RED + "[ERROR] File not found" + RESET);
    } catch (ArrayIndexOutOfBoundsException e) {
        System.out.println(RED + "[ERROR] Data Location is out of bounds" + RESET);
    }
    } // DELETE

    public void runSortData() {
    int answer = sortMenu();

    try {
        FileWriter terminal = new FileWriter("RunProgram.txt", true);

        File file = new File("musicalArtists.txt");
        Scanner FR = new Scanner(file);

        String[] aNames = new String[50];
        String[] aGenre = new String[50];
        int[] aPerfID = new int[50];
        int[] aViewers = new int[50];
        double[] aStagePrice = new double[50];
        int ctr = 0;

        while (FR.hasNextLine()) {
            aNames[ctr] = FR.nextLine();
            if (!FR.hasNextLine()) break;
            aGenre[ctr] = FR.nextLine();
            if (!FR.hasNextInt()) break;
            aPerfID[ctr] = FR.nextInt(); FR.nextLine();
            if (!FR.hasNextDouble()) break;
            aStagePrice[ctr] = FR.nextDouble(); FR.nextLine();
            if (!FR.hasNextInt()) break;
            aViewers[ctr] = FR.nextInt(); FR.nextLine();
            ctr++;
        }

        switch (answer) {
            case 1: // DESC
            for (int i = 0; i < ctr - 1; i++) {
            for (int j = 0; j < ctr - 1 - i; j++) {
            if (aViewers[j] < aViewers[j + 1]) {

            // SWAP ALL FIELDS
            int tempView = aViewers[j];
            aViewers[j] = aViewers[j + 1];
            aViewers[j + 1] = tempView;

            String tempName = aNames[j];
            aNames[j] = aNames[j + 1];
            aNames[j + 1] = tempName;

            String tempGenre = aGenre[j];
            aGenre[j] = aGenre[j + 1];
            aGenre[j + 1] = tempGenre;

            int tempID = aPerfID[j];
            aPerfID[j] = aPerfID[j + 1];
            aPerfID[j + 1] = tempID;

            double tempPrice = aStagePrice[j];
            aStagePrice[j] = aStagePrice[j + 1];
            aStagePrice[j + 1] = tempPrice;
                        }
                    }
                }
            break;

            case 2: // ASC
            for (int i = 0; i < ctr - 1; i++) {
            for (int j = 0; j < ctr - 1 - i; j++) {
            if (aViewers[j] > aViewers[j + 1]) {

            // SWAP ALL FIELDS
            int tempView = aViewers[j];
            aViewers[j] = aViewers[j + 1];
            aViewers[j + 1] = tempView;

            String tempName = aNames[j];
            aNames[j] = aNames[j + 1];
            aNames[j + 1] = tempName;

            String tempGenre = aGenre[j];
            aGenre[j] = aGenre[j + 1];
            aGenre[j + 1] = tempGenre;

            int tempID = aPerfID[j];
            aPerfID[j] = aPerfID[j + 1];
            aPerfID[j + 1] = tempID;

            double tempPrice = aStagePrice[j];
            aStagePrice[j] = aStagePrice[j + 1];
            aStagePrice[j + 1] = tempPrice;
                        }
                    }
                }
            break;

            case 3: // DESC ID
            for (int i = 0; i < ctr - 1; i++) {
            for (int j = 0; j < ctr - 1 - i; j++) {
            if (aPerfID[j] < aPerfID[j + 1]) {

            
            int tempView = aViewers[j];
            aViewers[j] = aViewers[j + 1];
            aViewers[j + 1] = tempView;

            String tempName = aNames[j];
            aNames[j] = aNames[j + 1];
            aNames[j + 1] = tempName;

            String tempGenre = aGenre[j];
            aGenre[j] = aGenre[j + 1];
            aGenre[j + 1] = tempGenre;

            int tempID = aPerfID[j];
            aPerfID[j] = aPerfID[j + 1];
            aPerfID[j + 1] = tempID;

            double tempPrice = aStagePrice[j];
            aStagePrice[j] = aStagePrice[j + 1];
            aStagePrice[j + 1] = tempPrice;
                        }
                    }
                }
            break;

            case 4: // ASC ID
            for (int i = 0; i < ctr - 1; i++) {
            for (int j = 0; j < ctr - 1 - i; j++) {
            if (aPerfID[j] > aPerfID[j + 1]) {

            
            int tempView = aViewers[j];
            aViewers[j] = aViewers[j + 1];
            aViewers[j + 1] = tempView;

            String tempName = aNames[j];
            aNames[j] = aNames[j + 1];
            aNames[j + 1] = tempName;

            String tempGenre = aGenre[j];
            aGenre[j] = aGenre[j + 1];
            aGenre[j + 1] = tempGenre;

            int tempID = aPerfID[j];
            aPerfID[j] = aPerfID[j + 1];
            aPerfID[j + 1] = tempID;

            double tempPrice = aStagePrice[j];
            aStagePrice[j] = aStagePrice[j + 1];
            aStagePrice[j + 1] = tempPrice;
                        }
                    }
                }
            break;

            case 5: // DESC PRICE
            for (int i = 0; i < ctr - 1; i++) {
            for (int j = 0; j < ctr - 1 - i; j++) {
            if (aStagePrice[j] < aStagePrice[j + 1]) {

            
            int tempView = aViewers[j];
            aViewers[j] = aViewers[j + 1];
            aViewers[j + 1] = tempView;

            String tempName = aNames[j];
            aNames[j] = aNames[j + 1];
            aNames[j + 1] = tempName;

            String tempGenre = aGenre[j];
            aGenre[j] = aGenre[j + 1];
            aGenre[j + 1] = tempGenre;

            int tempID = aPerfID[j];
            aPerfID[j] = aPerfID[j + 1];
            aPerfID[j + 1] = tempID;

            double tempPrice = aStagePrice[j];
            aStagePrice[j] = aStagePrice[j + 1];
            aStagePrice[j + 1] = tempPrice;
                        }
                    }
                }
            break;

            case 6: // ASC PRICE
            for (int i = 0; i < ctr - 1; i++) {
            for (int j = 0; j < ctr - 1 - i; j++) {
            if (aStagePrice[j] > aStagePrice[j + 1]) {

            
            int tempView = aViewers[j];
            aViewers[j] = aViewers[j + 1];
            aViewers[j + 1] = tempView;

            String tempName = aNames[j];
            aNames[j] = aNames[j + 1];
            aNames[j + 1] = tempName;

            String tempGenre = aGenre[j];
            aGenre[j] = aGenre[j + 1];
            aGenre[j + 1] = tempGenre;

            int tempID = aPerfID[j];
            aPerfID[j] = aPerfID[j + 1];
            aPerfID[j + 1] = tempID;

            double tempPrice = aStagePrice[j];
            aStagePrice[j] = aStagePrice[j + 1];
            aStagePrice[j + 1] = tempPrice;
                        }
                    }
                }
            break;


            case 0:
                System.out.println("[BACK TO MENU]");
                break;
        }

        // DISPLAY
        for (int a = 0; a < ctr; a++) {
            System.out.printf("%-2d | Stage Name: %-20s | Genres: %-20s | PERFORMANCE ID: %2d | Average Price: $ %-15.2f | Average Viewers: %-10d\n",
                a + 1, aNames[a], aGenre[a], aPerfID[a], aStagePrice[a], aViewers[a]);

            terminal.write(String.format("%-2d | Stage Name: %-20s | Genres: %-20s | PERFORMANCE ID: %3d | Average Price: $ %-15.2f | Average Viewers: %-10d\n",
                a + 1, aNames[a], aGenre[a], aPerfID[a], aStagePrice[a], aViewers[a]));
            terminal.write("\n[THIS IS THE SORTED LIST WHICH WAS DISPLAYED]");
        }
        terminal.write("Program Sorted a Displayed version of the List\n");
        terminal.close();
        FR.close();

    } catch (IOException e) {
        System.out.println("[ERROR] File not found");
    }
     }// SORT

    public static int inputInt() {
    while (true) {
    try {
    int tempInt = sc.nextInt(); sc.nextLine();
    return tempInt;
    } catch (InputMismatchException e) {
    sc.nextLine();
    System.out.println(RED + "[INVALID INPUT]" + RESET);
    } catch (IndexOutOfBoundsException e) {
    sc.nextLine();
    System.out.println(RED + "[INVALID INPUT OUT OF BOUNDS]" + RESET);
    }
        }
    
    }

    public static double inputDouble() {
    while (true) {
    try {
    double tempDouble = sc.nextDouble(); sc.nextLine();
    return tempDouble;
    } catch (InputMismatchException e) {
    sc.nextLine();
    System.out.println(RED + "[INVALID INPUT]" + RESET);
    }
    
    }

    }

    public static String inputString() {
    while (true) {
    try {
    String tempStr = sc.nextLine();
    return tempStr;
    } catch (InputMismatchException e) {
    sc.nextLine();
    System.out.println(RED + "[INVALID INPUT]" + RESET);
    }
    
    }
    }

    public int sortMenu() {
        int answer = 0;
        try {
        FileWriter terminal = new FileWriter("RunProgram.txt", true);
        System.out.println("""
                +----------------------------------------+
                |             Sort the bands             |
                +----------------------------------------+

                [1] DESCENDING VIEWERS
                [2] ASCENDING VIEWERS
                [3] DESCENDING PERFORMANCE ID
                [4] ASCENDING PERFORMANCE ID
                [5] DESCENDING PRICE
                [6] ASCENDING PRICE
                [0] BACK

                """);

                System.out.print("User>>");
                answer = inputInt();

                terminal.write("Program Opened the Band Menu\n");
                terminal.close();
                return answer;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return answer;
            
    }
}