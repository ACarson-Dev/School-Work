/*
Title: Matrix Addition
Author: Alexander Carson in collaboration with Neal Holtschulte
Date: 03-22-2026
Purpose: Perform concurrent matrix addition using four threads, one per quadrant
Sources: Oracle Java Tutorials - Defining and Starting a Thread:
			 https://docs.oracle.com/javase/tutorial/essential/concurrency/runthread.html
			 - Reference for extending Thread and using start()
		 Oracle Java Tutorials - Joins (Thread.join):
			 https://docs.oracle.com/javase/tutorial/essential/concurrency/join.html
			 - Reference for using join() to wait for threads to finish
		 GeeksForGeeks - How to Perform Java Parallel Matrix Multiplication:
			 https://www.geeksforgeeks.org/java/how-to-perform-java-parallel-matrix-multiplication/
			 - Reference for the quadrant-based approach to dividing matrices for concurrent processing
			 - Also sought advice from relative on understanding the quadrant-based approach better
		 Queried Junie AI for the following:
			 - Refining understanding of bufferedReader
		 Queried Claude AI for the following:
			 - Javadoc correctness and clarity on any areas that need improvement

*/

/*
This code is provided to give you a
starting place. It should be modified.
No further imports are needed.
To earn full credit, you must also
answer the following question:

Q1: One of the goals of multi-threading
is to minimize the resource usage, such
as memory and processor cycles. In three
sentences, explain how multi-threaded
code accomplishes this goal. Consider
writing about blocking on I/O, multicore
machines, how sluggish humans are,
threads compared to processes, et cetera,
and connect these issues to
multi-threading.
Answer: Threads share resources within the same program, so spinning up a new one to
handle a task uses less memory than launching an entirely separate process to do the
same job. When threads are stuck waiting for things like a slow network request, a
file load, or user input, the processor is free to keep other threads moving instead
of sitting idle. Machines with multiple cores can run threads side by side, squeezing
the most out of the hardware without the memory overhead of duplicating an entire process.
*/

import java.io.BufferedReader;
import java.io.FileReader;

public class MatrixAdditionMain
{
	/**
	 * Entry point. Reads two matrices from a file, adds them concurrently using
	 * four threads (one per quadrant), and prints the result.
	 *
	 * @param args args[0] must be the path to the input file containing matrix
	 *             dimensions followed by two matrices of equal size
	 */
	public static void main(String[] args)
	{
		if (args.length < 1)
		{
			System.out.println("Usage: java MatrixAdditionMain <filename>");
			return;
		}

		String filename = args[0];

		// Read matrices from file, add with four threads, then print result
		try (BufferedReader br = new BufferedReader(new FileReader(filename)))
		{
			String firstLine = br.readLine();
			String[] dims = firstLine.split(" ");
			int rows = Integer.parseInt(dims[0]);
			int cols  = Integer.parseInt(dims[1]);

			int[][] matrix1      = matrixFromFile(rows, cols, br);
			int[][] matrix2      = matrixFromFile(rows, cols, br);
			int[][] resultMatrix = new int[rows][cols];

			// Instantiate four ThreadOperation objects, one per quadrant
			ThreadOperation upperLeft  = new ThreadOperation(matrix1, matrix2, resultMatrix, rows, cols, "upper left");
			ThreadOperation upperRight = new ThreadOperation(matrix1, matrix2, resultMatrix, rows, cols, "upper right");
			ThreadOperation lowerLeft  = new ThreadOperation(matrix1, matrix2, resultMatrix, rows, cols, "lower left");
			ThreadOperation lowerRight = new ThreadOperation(matrix1, matrix2, resultMatrix, rows, cols, "lower right");

			// Start all four threads
			upperLeft.start();
			upperRight.start();
			lowerLeft.start();
			lowerRight.start();

			// Join all threads before printing to ensure they have all finished
			upperLeft.join();
			upperRight.join();
			lowerLeft.join();
			lowerRight.join();

			// Print the summed matrix
			print2dArray(resultMatrix);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Reads one matrix of the given dimensions from a BufferedReader, one row per line.
	 *
	 * @param rows number of rows to read
	 * @param cols number of columns per row
	 * @param br   the reader positioned at the first row of the matrix
	 * @return the parsed matrix as a 2D int array
	 * @throws Exception if reading or parsing fails
	 */
	public static int[][] matrixFromFile(int rows, int cols, BufferedReader br) throws Exception
	{
		int[][] matrix = new int[rows][cols];
		for (int i = 0; i < rows; i++)
		{
			String[] values = br.readLine().split(" ");
			for (int j = 0; j < cols; j++)
			{
				matrix[i][j] = Integer.parseInt(values[j]);
			}
		}
		return matrix;
	}

	/**
	 * Prints a 2D int array to standard output with each value right-aligned in a
	 * five-character column.
	 *
	 * @param array the 2D array to print
	 */
	public static void print2dArray(int[][] array)
	{
		for (int i = 0; i < array.length; i++)
		{
			for (int j = 0; j < array[i].length; j++)
			{
				System.out.printf("%5d", array[i][j]);
			}
			System.out.println();
		}
	}

}