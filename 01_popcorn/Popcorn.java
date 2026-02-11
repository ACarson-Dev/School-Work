/* 
Title: Array Popcorn
Author: Alexander Carson in colaboration with Neal Holtschulte
Date: 01-26-2026
Purpose: This program contains a method countPops that simulates "popping" throughout an array based on the values of each index.
Sources:
*/


public class Popcorn
{
	// Main method to run the provided test cases
	public static void main(String[] args)
	{
		System.out.println();
		int score = 0;
		
		// Test case 1: {1,3,0,5} should return 3
		score += tester(new int[]{1, 3, 0, 5}, 3);

		// Test case 2: {4,-1,0,5,2,8,-2} should return 100
		score += tester(new int[]{4, -1, 0, 5, 2, 8, -2}, 100);

		// Test case 3: {3,-1,4,2,5,-2} should return 5
		score += tester(new int[]{3, -1, 4, 2, 5, -2}, 5);

		// Test case 4: {3,-1,4,2,5} should return 4
		score += tester(new int[]{3, -1, 4, 2, 5}, 4);

		// Test case 5: {} should return 0
		score += tester(new int[]{}, 0);

		System.out.println("Your output is "+score+" out of 5.");	// Prints the final score
	}


	// Tester method to validate countPops method
	private static int tester(int[] input, int expectedCount)
	{
		// Call countPops and compare with expectedCount
		int actualCount = countPops(input);

		if (actualCount == expectedCount) {
			return 1; // Test passes
		} else {
			return 0; // Test fails
		}
	}
 

	// Method that counts how many "pops"(array reads) occurs
	public static int countPops(int[] arr)
	{
		int count = 0;
		// Handle empty array case
		if (arr.length == 0){
			return 0;
		}

		int currentIndex = 0; // Start at the first index

		// Loop until we go out of bounds or reach 100 pops
		while (count < 100){
			//Check if the current index is valid
			if (currentIndex < 0 || currentIndex >= arr.length){
				return count;
			}

			// Read the value at the current index
			int value = arr[currentIndex];
			count ++;

			// Move to the position indicated by "value"
			currentIndex = value;
		}
		return count; // Return the total number of pops

	} // End of countPops method
} // End of Popcorn class