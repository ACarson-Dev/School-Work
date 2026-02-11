/* 
Alexander Carson 
1-18-2026
Purpose: To briefly review (or learn) Java content in order to be prepared for CSCI 2251.
Sources: I did search for things I didn't remeber like silly printf formattingbut I came back and
         coded it myself.
*/

import java.util.Arrays;
import java.util.Scanner;

public class SelfReview {
    public static void main(String[] args) // Main method
    {            // Main method header
        //Step #4: Printing
        System.out.printf("\t\"Think left and think right\"\n" +
	                    "\t\"and think low and think high.\"\n" +
	                    "\t\"Oh, the thinks you can think up\"\n" +
	                    "\t\"if only you try!\"\n");  
                        
        //Step #5: printf
        System.out.printf("%15.4f\n", 2.71828);  //uses string format to print 4 decimal places of e with 15 spaces width
        
        //Step #6: Variables
        int volume = 4;
        double height = 9.46;
        String mountain = "Chicoma";
        System.out.printf("Volume: %d Height: %f Name: %s\n", volume, height, mountain);    // Print variables

        //Step 7: Input
        Scanner tableInputScanner = new Scanner(System.in); // Create scanner for user input
        
        // Ask for wood type 
        System.out.print("Enter wood type: ");
        String woodType = tableInputScanner.nextLine().trim();
        
        // Ask for length and only accept numbers
        System.out.print("Enter table length (ft): ");
        while (!tableInputScanner.hasNextDouble()) 
        {
            System.out.print("Please enter a numeric value for length: "); 
            tableInputScanner.next(); 
        }
        double tableLength = tableInputScanner.nextDouble();

        // Ask for width and only accept numbers
        System.out.print("Enter table width (ft): ");
        while (!tableInputScanner.hasNextDouble()) 
        {
            System.out.print("Please enter a numeric value for width: ");
            tableInputScanner.next();
        }
        double tableWidth = tableInputScanner.nextDouble();
        tableInputScanner.nextLine(); // consume end-of-line

        // Print formatted summary
        System.out.printf("Wood Type: %s\n", woodType);
        System.out.printf("Table Length: %.2f ft\n", tableLength);
        System.out.printf("Table Width: %.2f ft\n", tableWidth);
        System.out.println("");
        tableInputScanner.close(); // Close scanner 

        //Step 8: Branching
        double area = (tableWidth * tableLength);
        if (area > 48) {
            System.out.println("There will be an extra fee for the table based on its size.");
        } else {
                System.out.println("Table is under 48 sqr/ft there is no extra fee");
        }

        //Step 9: and & or
        if (tableLength > 12 || tableWidth > 12) {
            System.out.print("This table will have to be cut on a special saw.\n");
        }
        //Check if wood type is Teak
        if (woodType.equals("teak") || woodType.equals("Teak")) {
            System.out.print("This is a fancy table.\n");
        }
        
        //Step 10: Loops
        int sum = 0;
        // Loop through multiples of 7 from 7 to 700
        for (int i = 7; i <= 700; i+=7)
        { 
            sum += i;   //Adds the current multiple of 7 to sum
        }
        System.out.printf("The total is: %d\n", sum);   // Print statment outside loop for final display

        //Step 11: Arrays
        int[] numbers = {8, 3, 1, 2, -4, 9, 1, 6};
        // Loops through the numbers array and prints index and value
        for (int i = 0; i < numbers.length; i++) 
        { 
            System.out.printf("Value %d\n", numbers[i]);
        }
        int[] filledArray = new int[901]; // Create an array of size 901
        Arrays.fill(filledArray, 0, 299, 1);    // Fills filledArray with 300 1s from index 0 to 299
        Arrays.fill(filledArray, 300, 599, 2);  // Fills filledArray with 300 2s from index 300 to 599
        Arrays.fill(filledArray, 600, 899, 3);  // Fills filledArray with 300 3s from index 600 to 899

        //Step 12: Methods - Test countEvens and getEvens
        int[] testArray = {1, 2, 3, 4, 5, 6};
        System.out.printf("Count of evens: %d\n", countEvens(testArray));
        System.out.printf("Even values: %s\n", Arrays.toString(getEvens(testArray)));

        //Step 13: Median of Two - Test code for getMedianOfTwo
        // First test case
        int[] nums1 = {1, 3}; 
        int[] nums2 = {2};
        System.out.printf("Median of %s and %s: %.5f\n", 
            Arrays.toString(nums1), Arrays.toString(nums2), getMedianOfTwo(nums1, nums2));  // Expected output: 2.00000
        
        // Second test case
        int[] nums3 = {1, 2};
        int[] nums4 = {3, 4};
        System.out.printf("Median of %s and %s: %.5f\n",
            Arrays.toString(nums3), Arrays.toString(nums4), getMedianOfTwo(nums3, nums4));  // Expected output: 2.50000
    }   // End of main method

    //Step 12: Methods
    public static int countEvens(int[] arr) 
    {
        if (arr == null) return 0;
        int count = 0;
        for (int v : arr) if (v % 2 == 0) count++;
        return count;
    }   

    //Static method that takes an array as input
    public static int[] getEvens(int[] arr)
    {
        if (arr == null) return new int[0]; // Return empty array if input is null
        int couldBeCalledAnything = countEvens(arr); // Call countEvens to get number of even integers
        int[] evens = new int[couldBeCalledAnything]; // Create array to hold even integers
        int index = 0; // Index for evens array
        for (int v : arr) {
            if (v % 2 == 0) {
                evens[index++] = v; // Add even integer to evens array
            }
        }
        return evens; // Return array of even integers
    }

    // Step 13: Median of Two
    // Method to merge two sorted arrays
    public static int[] mergeSortedArr(int[] arr1, int[] arr2) 
    {
        int[] merged = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;

        // Merge the two arrays while maintaining sorted order
        while (i < arr1.length && j < arr2.length) {    //Compare elements from both arrays
            if (arr1[i] <= arr2[j])     // If element in arr1 is smaller or equal 
            {   
                merged[k++] = arr1[i++]; // Add it to merged array
            } else 
            {
                merged[k++] = arr2[j++]; // Else add element from arr2
            }
        }

        // Copy remaining elements from arr1, if any
        while (i < arr1.length)      //Handles remaining elements in arr1
        {      
            merged[k++] = arr1[i++];    // Adds remaining element to merged array
        }

        // Copy remaining elements from arr2, if any
        while (j < arr2.length)         // Handles remaining elements in arr2
        {       
            merged[k++] = arr2[j++];    // Adds reamining elements to merged array
        }
        return merged;
    }   // End of the mergeSortedArr method

    // Method to get the median value of two sorted arrays
    public static double getMedianOfTwo(int[] nums1, int[] nums2) 
    {
        //Merge the two sorted arrays
        int[] merged = mergeSortedArr(nums1, nums2);

        int length = merged.length; // Gets the length of the merged array

        // Calculate median
        if (length % 2 == 0)    //Checks if length is even   
        {   
            //Even length - Takes average of two middle elements
            return (merged[length / 2 - 1] + merged[length / 2]) / 2.0; 
        } else 
        {
            //Odd length - Takes the middle element
            return merged[length / 2];
        }

    }   // End of getMedianOfTwo method
}   // End of class SelfReview