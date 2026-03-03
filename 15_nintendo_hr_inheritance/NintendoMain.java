/*
Title: Nintendo HR Inheritance
Author: Alexander Carson in collaboration with Neal Holtschulte
Date: 03-01-2026
Purpose: Demonstrates the use of inheritance and composition through a Person management system
         that reads employee data from a file and stores it in a set that prevents duplicates.
Sources: https://www.geeksforgeeks.org/java-inheritance-vs-composition/ (Inheritance vs. composition review)
		 https://www.jetbrains.com/help/idea/javadocs.html (Javadoc info)
		 https://www.oracle.com/technical-resources/articles/java/javadoc-tool.html (JavaDoc info)
		 https://www.geeksforgeeks.org/java/comparable-interface-in-java-with-examples/ (Comparable interface for PerosnOrderedSet class)
		 https://www.w3schools.com/java/ref_string_format.asp (Continually reference for String output formatting)
		 Queried Junie AI for the following:
		 - Refactor all main classed in project folder to resolve IDE issues.
		 - Verify completeness of Javadoc commenting. It found some small clarification issues that were fixed.
		 - Generate commit messages. I reviewed them ensuring they all aligned before commiting and pushing to the repo.
		 Queried Claude AI for the following:
		 - Take assignment doc and combine any extra notes with applicable instruction steps and present it to me.
		   Take steps and match them with their UML diagrams sequentially. I then used these documents for the completion of my assignment.
		 - Utilized Claude as a tool to develop a better understanding of the function/implimentation of @Override through worked examples.
		   Examples were not directly comparable to assignment, so specifics should be okay to not include.
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
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Main class for the Nintendo HR.
 * This program reads employee data from a file and stores it in two separate sets:
 * an ordered set and an imperial set, then outputs the data to files and the console.
 */
public class NintendoMain
{
	/**
	 * Main entry point for the program.
	 *
	 * @param args command line arguments (not used)
	 */
	public static void main(String[] args)
	{
		// Instantiate sets
		PersonOrderedSet orderedSet = new PersonOrderedSet();
		PersonImperialSet imperialSet = new PersonImperialSet();

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
				
				// Create a Person object and add it to both sets
				Person p = new Person(name, height, weight);
				
				orderedSet.add(p);
				imperialSet.add(p);
			}
			fileReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found: hr.txt");
		}

		// Output formatted data with headers to two separate files
		try {
			PrintWriter orderedWriter = new PrintWriter("hr_ordered_set_output.txt");
			orderedWriter.print(orderedSet.toString());
			orderedWriter.close();

			PrintWriter imperialWriter = new PrintWriter("hr_imperial_set_output.txt");
			imperialWriter.print(imperialSet.toString());
			imperialWriter.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error writing to output files.");
		}

		// Output the ordered data and the imperial data to the screen/console
		System.out.println("Ordered Data (Alphabetical by Name):");
		System.out.println(orderedSet);

		System.out.println("\nImperial Data (Inches and Pounds):");
		System.out.println(imperialSet);

		// etluhcstloH laeN rof nettirw edoc sihT
	} // End of main()
} // End of NintendoMain class