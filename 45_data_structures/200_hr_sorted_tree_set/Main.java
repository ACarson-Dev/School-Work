/*
Title: Nintendo HR - Sorted Tree Set
Author: Alexander Carson in collaboration with Neal Holtschulte
Date: 03-16-2026
Purpose: Demonstrate the use of the SortedTreeSet (binary search tree) data structure in java to manage employee data.
Sources:
		 Queried Junie AI for the following:
		     - Final pass-through for completeness after I verified the output.
		 Queried Claude AI for the following:
			 - General structure of a binary search tree node-based class. Just studied and worked with it for visuals.
		     - Worked with claude to better understand the structure of the SortedTreeSet class.
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Main class for the Nintendo HR.
 * This program reads employee data from a file and stores it in a sorted tree set,
 * then outputs the data to a file and the console.
 */
public class Main
{
	/**
	 * Main entry point for the program.
	 *
	 * @param args command line arguments (not used)
	 */
	public static void main(String[] args)
	{
		// Instantiate tree set
		SortedTreeSet treeSet = new SortedTreeSet();

		// Read person data from the file and add to both sets
		try {
			File file = new File("hr.txt");
			Scanner fileReader = new Scanner(file);

			// Skip the header line
			if (fileReader.hasNextLine()) fileReader.nextLine();

			// Read each person's data from the file
			while (fileReader.hasNext()) {
				String name = fileReader.next();
				double height = fileReader.nextDouble();
				double weight = fileReader.nextDouble();
				
				// Create a Person object and add it to the set
				Person p = new Person(name, height, weight);
				
				treeSet.add(p);
			}
			fileReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found: hr.txt");
		}

		// Output formatted data with headers to a file
		try {
			PrintWriter treeWriter = new PrintWriter("hr_sorted_tree_set_output.txt");
			treeWriter.print(treeSet);
			treeWriter.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error writing to output files.");
		}

		// Output the tree data to the screen/console
		System.out.println("Sorted Tree Set Data (Alphabetical by Name):");
		System.out.println(treeSet);

	} // End of main()
} // End of Main class