/**
 * Title: HurricaneDataLinkedList
 * Author: Alexander Carson in collaboration with Neal Holtschulte
 * Date: 03-08-2026
 * Purpose:
 * Sources: https://www.youtube.com/watch?v=hDwPD6kTmEk&t=41s (Used for further understanding of linked lists)
            Queried Junie AI for the following:
            "Refactor all instances of Main in all project classes and comments Back to Main". This was done before submitting the assignment and is not reflected in my git Repo.
            Verify assignment output. (Correct output returned. I did this as the final check after I had already verified.)
            Assisted with some correctness in Javadoc commenting as needed.
            Queried Claude AI for the following:
            - Take assignment doc and combine all instruction and any extra notes with applicable instruction steps and present it to me.
              Take provided steps and match them with their UML diagrams sequentially. Create UML if not included.
              I then used these documents for the completion of my assignment.
 */

import java.util.Scanner;
import java.io.File; // Importing the File class to read the .csv file
import java.io.FileNotFoundException; // Import to handle the exception when the file is hiding(not found)

public class Main {
    /**
     * Main method to read hurricane data and find the maximum ACE index.
     * @param args command line arguments
     * @throws FileNotFoundException if the input file is not found
     */
    public static void main(String[] args) throws FileNotFoundException {
        // Run test methods first
        System.out.println("Running tests...");
        testInsertionAndSize();
        testSortedOrder();
        System.out.println();

        DoublyLinkedSortedList data = new DoublyLinkedSortedList();
        Scanner scanner = new Scanner(new File("ace.csv")); // Creates a Scanner object to read the ace.csv file
        scanner.nextLine(); // Skips the header line

        while (scanner.hasNextLine()) { // Loops through each line of the .csv file until there are no more lines to read
            String line = scanner.nextLine();
            String[] splitData = line.split(","); // Splits the line into an array of strings using the comma as a delimiter

            // Parse int values from the data array and stores them in int variables.
            int year = Integer.parseInt(splitData[0]);
            int aceIndex = Integer.parseInt(splitData[1]);
            int numTropStorms = Integer.parseInt(splitData[2]);
            int numHurricanes = Integer.parseInt(splitData[3]);
            int numMajorStorms = Integer.parseInt(splitData[4]);

            // Creates a new HurricaneRowData object with the parsed values and inserts it to the linked list
            data.insert(new HurricaneRowData(year, aceIndex, numTropStorms, numHurricanes, numMajorStorms));
        }
        scanner.close(); // Closes the scanner

        Node link = data.getFirst();
        HurricaneRowData dat = link.getValue();
        int max_year = dat.getYear();
        System.out.println("Year of max ace: " + max_year);
        System.out.println("All data in order of Ace:");
        System.out.println(data);

    } // End of Main method

    /**
     * Test method 1: Tests insertion and resulting size of the doubly linked list.
     * Inserts 3 items and verifies the list size is 3.
     */
    private static void testInsertionAndSize() {
        DoublyLinkedSortedList testList = new DoublyLinkedSortedList();

        testList.insert(new HurricaneRowData(2000, 100, 10, 5, 2));
        testList.insert(new HurricaneRowData(2001, 150, 12, 6, 3));
        testList.insert(new HurricaneRowData(2002, 75, 8, 4, 1));

        if (testList.size() == 3) {
            System.out.println("Test 1 PASSED: List size is correct (3)"); // Whoop whoop!
        } else {
            System.out.println("Test 1 FAILED: Expected size 3, but got " + testList.size());
        }
    }

    /**
     * Test method 2: Tests that the list maintains sorted order. I.e., descending by ACE value.
     * Inserts items out of order and verifies the first item has the highest ACE.
     */
    private static void testSortedOrder() {
        DoublyLinkedSortedList testList = new DoublyLinkedSortedList();

        testList.insert(new HurricaneRowData(2000, 100, 10, 5, 2));
        testList.insert(new HurricaneRowData(2001, 250, 15, 8, 4)); // *Highest ACE Value - should appear at the top
        testList.insert(new HurricaneRowData(2002, 75, 8, 4, 1));

        Node first = testList.getFirst();
        if (first != null && first.getValue().getAceIndex() == 250) {
            System.out.println("Test 2 PASSED: List is sorted correctly (highest ACE first)"); // Whoop whoop!
        } else {
            System.out.println("Test 2 FAILED: List is not sorted correctly");
        }
    }

}  // End of class Main