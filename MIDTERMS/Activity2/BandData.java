package MIDTERMS.Activity2;

import java.util.*;
import java.io.*;
public class BandData {
	
	    

        public BandData() {}

        public void runBandDataExtractionAndDisplay() {
    try {
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

        for (int a = 0; a < ctr; a++) {
            System.out.println(
                a + " | " + aNames[a] + " | " + aGenre[a] + " | " + aPerfID[a] + " | " + aStagePrice[a] + " | " + aViewers[a]);
        }

        FR.close();
    } catch (IOException e) {
        System.out.println("[ERROR] File not found");
    }
}
}
