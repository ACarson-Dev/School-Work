/* 
Title: HurricaneData
Author: Alexander Carson in colaboration with Neal Holtschulte
Date: 02-01-2026
Purpose: This program takes in hurricane data from a .csv file and ......
Sources:
*/

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File; // Importing the File class to read the .csv file
import java.io.FileNotFoundException; // Import to handle the exception when the file is hiding(not found)
import java.io.PrintWriter; // Import to write output to a text file

public class HurricaneMain {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<HurricaneRowData> hurricaneRowData = new ArrayList<>(); // Creates an ArrayList to hold the HurricaneRowData objects
        Scanner scanner = new Scanner(new File("ace.csv")); // Creates a Scanner object to read the ace.csv file
        scanner.nextLine(); // Skips the header line

        while (scanner.hasNextLine()) { // Loops through each line of the .csv file until there are no more lines to read
            String line = scanner.nextLine();
            String[] data = line.split(","); // Splits the line into an array of strings using the comma as a delimiter   
            
            // Parse int values from the data array and stores them in int variables.
            int year = Integer.parseInt(data[0]);
            int aceIndex = Integer.parseInt(data[1]);
            int numTropStorms = Integer.parseInt(data[2]);
            int numHurricanes = Integer.parseInt(data[3]);
            int numMajorStorms = Integer.parseInt(data[4]);

            // Creates a new HurricaneRowData object with the parsed values and adds it to the hurricaneData ArrayList
            hurricaneRowData.add(new HurricaneRowData(year, aceIndex, numTropStorms, numHurricanes, numMajorStorms)); 
        }
        scanner.close(); // Closes the scanner

        // Call the methods to find the max ACE year and value
        int maxYear = findMaxACEYear(hurricaneRowData);
        int maxAce = findMaxACE(hurricaneRowData);

        // Display results to the console
        System.out.println("Max ACE Year: " + maxYear);
        System.out.println("Max ACE Value: " + maxAce);

        // Write results to an output text file
        PrintWriter writer = new PrintWriter(new File("output.txt"));
        writer.println("Max ACE Year: " + maxYear);
        writer.println("Max ACE Value: " + maxAce);
        writer.close(); // Close the writer

    }// End of main method.

    // Finds the year with the maximum ACE index from the ArrayList
    private static int findMaxACEYear(ArrayList<HurricaneRowData> data) {
        int maxAce = data.get(0).getAceIndex();
        int maxYear = data.get(0).getYear();

        for (int i = 1; i < data.size(); i++) {
            if (data.get(i).getAceIndex() > maxAce) {
                maxAce = data.get(i).getAceIndex();
                maxYear = data.get(i).getYear();
            }
        }
        return maxYear;
    }// End of findMaxACEYear method

    // Finds the maximum ACE index value from the ArrayList
    private static int findMaxACE(ArrayList<HurricaneRowData> data) {
        int maxAce = data.get(0).getAceIndex();

        for (int i = 1; i < data.size(); i++) {
            if (data.get(i).getAceIndex() > maxAce) {
                maxAce = data.get(i).getAceIndex();
            }
        }
        return maxAce;
    }// End of findMaxACE method

}// End of class HurricaneMain