/* 
Title: Sparse Matrix 
Author: Alexander Carson in colaboration with Neal Holtschulte
Date: 02-16-2026
Purpose: To implement a sparse matrix class in Java that efficiently stores and manipulates matrices with a 
         large number of zero values. The class provides methods for creating a sparse matrix from a 2D array, 
         outputting the matrix as a 2D array as well as adding two sparse matrices together.
Sources: I had quite a lot of back and forth with Claude on sparce matices and hashmap implimentation. It took a while but eventually I got there. 
         I also utilized searchers for HashMap and general Java syntax to help with the implementation.
*/

 

public class Main {
    public static void main(String[] args) {
        int[][] matrix1 = {
            {5, 0, 0, 0},
            {0, 8, 0, 0},
            {0, 0, 0, 0},
            {0, 6, 0, 0}
        };
        int[][] matrix2 = {
            {8, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 3, 6, 0, 0, 0, 0, 0, 0},
            {2, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        int[][] matrix3 = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10}
        };
        SparseMatrix sparseMatrix1 = new SparseMatrix(matrix1);
        int[][] output1 = sparseMatrix1.outputToArray();
        System.out.println("Output Matrix 1:");
            for(int i = 0; i < output1.length; i++){
                for(int j = 0; j < output1[0].length; j++){
                    System.out.print(output1[i][j] + " ");
                }
                System.out.println();
            }

        SparseMatrix sparseMatrix2 = new SparseMatrix(matrix2);
        int[][] output2 = sparseMatrix2.outputToArray();
        System.out.println("Output Matrix 2:");
            for(int i = 0; i < output2.length; i++){
                for(int j = 0; j < output2[0].length; j++){
                    System.out.print(output2[i][j] + " ");
                }
                System.out.println();
            }

        SparseMatrix sparseMatrix3 = new SparseMatrix(matrix3);
        int[][] output3 = sparseMatrix3.outputToArray();
        System.out.println("Output Matrix 3:");
            for(int i = 0; i < output3.length; i++){
                for(int j = 0; j < output3[0].length; j++){
                    System.out.print(output3[i][j] + " ");
                }
                System.out.println();
        }

        // Test add method — two 4x4 matrices
        int[][] addMatrix1 = {
            {1, 0, 0, 2},
            {0, 3, 0, 0},
            {0, 0, 4, 0},
            {5, 0, 0, 6}
        };
        int[][] addMatrix2 = {
            {0, 0, 7, 0},
            {0, -3, 0, 0},
            {8, 0, 0, 0},
            {0, 0, 0, 4}
        };
        SparseMatrix addSparse1 = new SparseMatrix(addMatrix1);
        SparseMatrix addSparse2 = new SparseMatrix(addMatrix2);
        addSparse1.add(addSparse2);
        int[][] addResult = addSparse1.outputToArray();
        System.out.println("Add Result (addMatrix1 + addMatrix2):");
        for (int i = 0; i < addResult.length; i++) {
            for (int j = 0; j < addResult[0].length; j++) {
                System.out.print(addResult[i][j] + " ");
            }
            System.out.println();
        }

    } // End of main method
} // End of Main class

