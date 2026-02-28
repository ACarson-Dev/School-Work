import java.util.HashMap;

public class SparseMatrix {
    private int rows;
    private int columns;
    private HashMap<String, Integer> sparseMatrix = new HashMap<>();

    // Constructor to create a sparse matrix from a 2D array
    public SparseMatrix(int[][] matrix) {
        this.rows = matrix.length;
        this.columns = matrix[0].length;
        // Loop through the 2D array and add non-zero values to the sparseMatrix HashMap
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                if(matrix[i][j] != 0){
                    String key = i + "," + j;
                    sparseMatrix.put(key, matrix[i][j]);
                }
            }
        }
        assert arraysAreEqual(outputToArray(), matrix) : "assertion error";
    }

    // Method to output the matrix value at a specific row and column
    public int[][] outputToArray() {
        int[][] result = new int[rows][columns];
        for(String key : sparseMatrix.keySet()){
            String[] parts = key.split(",");
            int row = Integer.parseInt(parts[0]);
            int col = Integer.parseInt(parts[1]);
            result[row][col] = sparseMatrix.get(key);
        }
        return result; 
    }

    // Helper method to compare two 2D arrays for equality
    public static boolean arraysAreEqual(int[][] array1, int[][] array2) {
        if(array1.length != array2.length || array1[0].length != array2[0].length){
            return false;
        }
        for(int i = 0; i < array1.length; i++){
            for(int j = 0; j < array1[0].length; j++){
                if(array1[i][j] != array2[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    // Method to add another sparse matrix to this sparse matrix
    public void add(SparseMatrix other) {
        if (this.rows != other.rows || this.columns != other.columns) {
            throw new IllegalArgumentException("Matrix dimensions must match to add.");
        }
        for (String key : other.sparseMatrix.keySet()) {
            int otherValue = other.sparseMatrix.get(key);
            if (this.sparseMatrix.containsKey(key)) {
                int sum = this.sparseMatrix.get(key) + otherValue;
                if (sum == 0) {
                    this.sparseMatrix.remove(key);
                } else {
                    this.sparseMatrix.put(key, sum);
                }
            } else {
                this.sparseMatrix.put(key, otherValue);
            }
        }
    }

} // End of SparseMatrix class