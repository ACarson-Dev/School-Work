/*
Title: Threaded Auto Complete
Author: Alexander Carson in collaboration with Neal Holtschulte
Date: 04-20-2026
Purpose: Launch a GUI that searches three classic novels concurrently using one thread per novel,
		 displaying autocomplete suggestions based on the last word the user has typed.
Modifications:
         STOP ON EXCLAMATION: Modified getTextToPeriod() in ThreadedAutocomplete.java
         to also stop at exclamation marks in addition to periods and question marks.
         I alos refactored the original if/else chain for finding the minimum indexOf result
         into a cleaner sequential comparison that correctly handles -1 value
         (lines 181-187 in ThreadedAutocomplete.java).
Sources:
         Queried Claude AI for the following:
         1. Refresh on how Thread.sleep() works.
         2. How to find the minimum valid index among multiple indexOf()
            results when any of them may return -1.
		 3. Why String.indexOf() returns -1 when the character is not found,
			and why that must be checked before using the result as a
			substring index to avoid a StringIndexOutOfBoundsException.
*/
public class ThreadedAutocompleteMain
{
	public static void main(String[] args)
	{
		SuggestionGUI application = new SuggestionGUI();
	}
}