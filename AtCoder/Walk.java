package AtCoder;

import java.util.Scanner;

public class Walk {
	static final int MOD = 1000000007;

	// Function to multiply two matrices
	public static int[][] multiply(int[][] A, int[][] B, int N) {
		int[][] result = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				long sum = 0;
				for (int k = 0; k < N; k++) {
					sum += (long) A[i][k] * B[k][j];
					sum %= MOD; // Take modulo at each step
				}
				result[i][j] = (int) sum;
			}
		}
		return result;
	}

	// Function to perform matrix exponentiation
	public static int[][] matrixPower(int[][] A, int K, int N) {
		// Initialize result as the identity matrix
		int[][] result = new int[N][N];
		for (int i = 0; i < N; i++) {
			result[i][i] = 1; // Identity matrix
		}

		// Perform exponentiation by squaring
		while (K > 0) {
			if ((K & 1) == 1) {
				result = multiply(result, A, N); // Multiply when K is odd
			}
			A = multiply(A, A, N); // Square the matrix
			K >>= 1; // Divide K by 2
		}

		return result;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Read input
		int N = sc.nextInt(); // Number of vertices
		int K = sc.nextInt(); // Length of paths
		int[][] A = new int[N][N]; // Adjacency matrix

		// Input adjacency matrix
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				A[i][j] = sc.nextInt();
			}
		}

		// Perform matrix exponentiation to find A^K
		int[][] result = matrixPower(A, K, N);

		// Sum all elements of the resulting matrix to get the number of paths
		long totalPaths = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				totalPaths += result[i][j];
				totalPaths %= MOD; // Take modulo
			}
		}

		// Output the result
		System.out.println(totalPaths);
	}
}
