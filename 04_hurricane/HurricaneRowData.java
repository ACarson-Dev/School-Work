/* 
Title: HurricaneData
Author: Alexander Carson
Date: 02-01-2026
Purpose: This program takes in hurricane data from a .csv file and process it to find the year with the maximum ACE index and the maximum ACE value. 
         It then outputs the results to both the console and a text file.
Sources:
*/

// Class HurricaneRowData. 
public class HurricaneRowData {
    // Private encapsulates the data and allows control over how it is accessed and modified
    private int year;
    private int aceIndex;
    private int numTropStorms;
    private int numHurricanes;
    private int numMajorStorms;

    // Constructor to initialize the class fields with the provided valuse from the .csv file
    public HurricaneRowData(int year, int aceIndex, int numTropStorms, int numHurricanes, int numMajorStorms)
    {
        this.year = year;
        this.aceIndex = aceIndex;
        this.numTropStorms = numTropStorms;
        this.numHurricanes = numHurricanes;
        this.numMajorStorms = numMajorStorms;
    }
    
    @Override // Override the default toString method to do what I need it to do.
    public String toString() {
        return "Year: " + year + ", ACE Index: " + aceIndex + 
        ", Total Tropical Storms: " + numTropStorms + 
        ", Total Hurricanes: " + numHurricanes +
        ", Total Major Storms: " + numMajorStorms;
    }

    // Getter methods for HurricaneMain.java to access the private fields of the class HurricaneRowData
    public int getYear() {
        return year;
    }

    public int getAceIndex(){
        return aceIndex;
    }

} // End of class HurricaneRowData