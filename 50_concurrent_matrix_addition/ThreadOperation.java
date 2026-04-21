public class ThreadOperation extends Thread
{
    // Instance variables shared across all threads via reference
    private int[][] matrix1;
    private int[][] matrix2;
    private int[][] resultMatrix;
    private int rowStart;
    private int rowEnd;
    private int colStart;
    private int colEnd;

    /**
     * Constructs a ThreadOperation for the specified quadrant of the matrices.
     *
     * @param matrix1      the first input matrix
     * @param matrix2      the second input matrix
     * @param resultMatrix the matrix where element-wise sums are stored
     * @param rows         total number of rows in the matrices
     * @param cols         total number of columns in the matrices
     * @param quadrant     one of "upper left", "upper right", "lower left", or "lower right"
     */
    public ThreadOperation(int[][] matrix1, int[][] matrix2, int[][] resultMatrix, int rows, int cols, String quadrant)
    {
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        this.resultMatrix = resultMatrix;

        int[] indexes = getQuadrantIndexes(rows, cols, quadrant);
        this.rowStart = indexes[0];
        this.rowEnd   = indexes[1];
        this.colStart = indexes[2];
        this.colEnd   = indexes[3];
    }

    /**
     * Returns the row and column bounds for the given quadrant of a matrix.
     *
     * @param rows     total number of rows in the matrix
     * @param cols     total number of columns in the matrix
     * @param quadrant one of "upper left", "upper right", "lower left", or "lower right"
     * @return an int array of {rowStart, rowEnd, colStart, colEnd} (inclusive)
     */
    public static int[] getQuadrantIndexes(int rows, int cols, String quadrant)
    {
        int rowMid = rows / 2;
        int colMid = cols / 2;

        if (quadrant.equals("upper left"))
        {
            return new int[]{0, rowMid - 1, 0, colMid - 1};
        }
        else if (quadrant.equals("upper right"))
        {
            return new int[]{0, rowMid - 1, colMid, cols - 1};
        }
        else if (quadrant.equals("lower left"))
        {
            return new int[]{rowMid, rows - 1, 0, colMid - 1};
        }
        else
        {
            // lower right
            return new int[]{rowMid, rows - 1, colMid, cols - 1};
        }
    }

    /**
     * Adds the corresponding elements of matrix1 and matrix2 within this thread's
     * assigned quadrant, storing each sum in resultMatrix.
     */
    @Override
    public void run()
    {
        for (int i = rowStart; i <= rowEnd; i++)
        {
            for (int j = colStart; j <= colEnd; j++)
            {
                resultMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
    }

} // End of ThreadOperation class