/*
Title: Nintendo HR Inheritance
Author: Alexander Carson in collaboration with Neal Holtschulte
Date: 02-16-2026
Purpose: Demonstrates the use of inheritance and composition through a Person management system
         that reads employee data from a file and stores it in a set that prevents duplicates.
Sources: https://www.geeksforgeeks.org/java-inheritance-vs-composition/ (Inheritance vs composition review)
		 https://www.jetbrains.com/help/idea/javadocs.html (JavaDoc info)
		 https://www.oracle.com/technical-resources/articles/java/javadoc-tool.html (JavaDoc info)
*/

/*
Q1: Car and Engine are related
by which, Inheritance or Composition?
Answer: Inheritance
Q2: Color and Red are related
by which, Inheritance or Composition?
Answer: Composition
Q3: Shirt and Clothing are related
by which, Inheritance or Composition?
Answer: Inheritance
Q4: Furniture and Desk are related
by which, Inheritance or Composition?
Answer: Inheritance
Q5: CellPhone and Battery are related
by which, Inheritance or Composition?
Answer: Composition
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Main class for the Nintendo HR
 * This program uses inheritance and composition by taking Person objects
 * and storing them in a PersonSet that handles duplicates.
 */
public class NintendoMain
{
	/**
	 * Main entry point for the program.
	 * Creates a PersonSet, adds a test person, reads all additional persons from a file,
	 * and displays the final set with no duplicates.
	 *
	 * @param args command line arguments (not used)
	 */
	public static void main(String[] args)
	{
		// Create a test person and display it
		Person p1 = new Person("Alex", 200, 6.2);
		System.out.println("Singler person test: " + p1);

		// Initialize a PersonSet to store unique persons
		PersonSet testSet = new PersonSet();
		testSet.add(p1);

		// Read person data from file and add to set
		try {
			File file = new File("hr.txt");
			Scanner fileReader = new Scanner(file);

			// Skip the header line if it exists
			if (fileReader.hasNextLine()) fileReader.nextLine();

			// Read each person's data from the file
			while (fileReader.hasNext()) {
				String name = fileReader.next();
				double height = fileReader.nextDouble();
				double weight = fileReader.nextDouble();

				// Create a Person object and add to the set
				Person p = new Person(name, height, weight);
				testSet.add(p);
				System.out.println("Read from file: " + p);
			}
			fileReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found: hr.txt");
		}

		// Display the final PersonSet with no duplicates
		System.out.println("\nFinal PersonSet (No Duplicates):");
		System.out.println(testSet);

		// etluhcstloH laeN rof nettirw edoc sihT

	} // End of main()
} // End of NintendoMain class