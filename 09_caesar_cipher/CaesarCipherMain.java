/* 
Title: Cesar Cipher
Author: Alexander Carson in colaboration with Neal Holtschulte
Date: 02-09-2026
Purpose: This program implements a simple Caesar cipher to encrypt and decrypt strings. It also includes a one-time pad 
         encryption method for added security. The program takes user input for the string to be encrypted and the shift 
         value, and it continues to run until the user decides to quit.
Sources:
*/

import java.util.Scanner;
import java.util.Random;

public class CaesarCipherMain {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); 

        String example = "The five boxing wizards jump quickly."; // Example string to encrypt and decrypt
        System.out.println("Original String: " + example); // Display the original string
        String encrypted = encrypt(example, 2); // Encrypt the example string with a shift of 3
        System.out.println("Encrypted String: " + encrypted); // Display the encrypted string   
        String decrypted = decrypt(encrypted, 2); // Decrypt the encrypted string with the same shift of 3
        System.out.println("Decrypted String: " + decrypted); // Display the decrypted string

        // One-time pad automatic test
        int[] otpKey = randomInt(example); // Generate a random key array for the one-time pad
        String otpEncrypted = otpEncrypt(example, otpKey); // Encrypt using the one-time pad
        System.out.println("OTP Encrypted String: " + otpEncrypted); // Display the OTP encrypted string
        String otpDecrypted = otpDecrypt(otpEncrypted, otpKey); // Decrypt using the same one-time pad key
        System.out.println("OTP Decrypted String: " + otpDecrypted); // Display the OTP decrypted string

        // Condition to keep the program running until the user decides to quit
        while (true) {
            System.out.print("Enter a string or \"quit\" to exit: ");
            String input = scanner.nextLine();
            // Check user input for "quit" to exit the loop
            if (input.equals("quit")) {
                break; 
            }
            
            System.out.print("Enter an integer for the shift: ");
            int shift = scanner.nextInt();
            scanner.nextLine();
            
            String userInput = encrypt(input, shift); // Encrypt the user input with the specified shift
            System.out.println("User Input Original: " + input); // Display the original user input
            System.out.println("User Input Encrypted: " + userInput); // Display the encrypted user input
            String userDecrypted = decrypt(userInput, shift); // Decrypt the encrypted user input
            System.out.println("User Input Decrypted: " + userDecrypted); // Display the decrypted user input
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

        // Method to decrypt input string and return the decrypted string
        public static String decrypt(String input, int shift){
            String result = ""; // Initialize an empty string to hold the decrypted result
            for (int i = 0; i < input.length(); i++) {
                char pos = (char)(input.charAt(i) - shift); // Shift the character back by the specified amount
                result += pos; // Append the shifted character to the result string
            }
            return result; // Return the decrypted string
        }
        
        // Method to generate an array of random integers based on user input
        public static int[] randomInt(String input) {
            int[] randomInts = new int[input.length()]; // Create the array to hold the random integers
            Random rand = new Random(); // Create a Random object to generate random numbers
            for(int i = 0; i < input.length(); i++) {
                randomInts[i] = rand.nextInt(10) + 1; // Generate a random int between 1 and 10 and store it in the array   
            }
            return randomInts; // Return the array of random integers
        }

        // Method to encrypt input string using a one-time pad and return the encrypted string
        public static String otpEncrypt(String input, int[] key) {
            String result = ""; // Initialize an empty string to hold the encrypted result
            for (int i = 0; i < input.length(); i++) {
                char pos = (char)(input.charAt(i) + key[i]); // Shift each character by the corresponding key value
                result += pos; // Append the shifted character to the result string
            }
            return result; // Return the encrypted string
        }

        // Method to decrypt input string using a one-time pad and return the decrypted string
        public static String otpDecrypt(String input, int[] key) {
            String result = ""; // Initialize an empty string to hold the decrypted result
            for (int i = 0; i < input.length(); i++) {
                char pos = (char)(input.charAt(i) - key[i]); // Shift each character back by the corresponding key value
                result += pos; // Append the shifted character to the result string
            }
            return result; // Return the decrypted string
        }

} // End of class