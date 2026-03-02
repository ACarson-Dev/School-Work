/*
Title: Sparse Matrix
Author: Alexander Carson in collaboration with Neal Holtschulte
Date: 02-16-2026
Purpose:
Sources: https://www.geeksforgeeks.org/java-inheritance-vs-composition/
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
public class NintendoMain
{
	public static void main(String[] args) 
	{
		Person p1 = new Person("Alex", 200, 6.2);
		System.out.println("Singler person test: " + p1);
		
		// Initialize a PersonSet
		PersonSet testSet = new PersonSet();
		testSet.add(p1);
		
		// Read the file name
		try {
			File file = new File("hr.txt");
			Scanner fileReader = new Scanner(file);
			
			// Skip the header if it exists
			if (fileReader.hasNextLine()) fileReader.nextLine();
			
			while (fileReader.hasNext()) {
				String name = fileReader.next();
				double height = fileReader.nextDouble();
				double weight = fileReader.nextDouble();
				
				Person p = new Person(name, height, weight);
				testSet.add(p);
				System.out.println("Read from file: " + p);
			}
			fileReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found: hr.txt");
		}
		
		System.out.println("\nFinal PersonSet (No Duplicates):");
		System.out.println(testSet);
		
		// etluhcstloH laeN rof nettirw edoc sihT
		
	} // End of main()
} // End of NintendoMain class