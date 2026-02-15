/* 
Title: Cesar Cipher
Author: Alexander Carson in colaboration with Neal Holtschulte
Date: 02-09-2026
Purpose:
Sources:
*/

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in); 
        // Condition to keep the program running until the user decides to quit
        while (true) {
            System.out.print("Enter a string or \"quit\" to exit");
            String input = scanner.nextLine();
            // Check user input for "quit" to exit the loop
            if (input.equals("quit")) {
                break; 
            }
            
            System.out.print("Enter an integer for the shift: ");
            int shift = scanner.nextInt();
            scanner.nextLine();

            System.out.println("You entered: " + input + " with shift: " + shift);
        }
        scanner.close(); // Close the scanner
    } // End of main method

        // Method to encrypt input string and return the encrypted string
        public static String encrypt(String input, int shift) {
            String result = ""; // Initialize an empty string to hold the encrypted result
            for (int i = 0; i < input.length(); i++) {
                char pos = (char)(input.charAt(i) + shift); // Shift the character by the specified amount
                result += pos; // Append the shifted character to the result string
            }
            return result; // Return the encrypted string
        } // End of encrypt method

    
} // End of class 
