package AtCoder;

import java.util.*;

public class KnapsackII {
	public static void main(String[] args) {
		int n = 3; // Number of items
		int W = 100000000; // Knapsack capacity
		int[] weights = {10000000, 20000000, 30000000};
		int[] values = {100, 200, 300};

		System.out.println(knapsack(n, W, weights, values));
	}

	public static int knapsack(int n, int W, int[] weights, int[] values) {
		// Maximum possible value sum
		int maxValueSum = Arrays.stream(values).sum();

		// Initialize dp array with a large value (infinity)
		long[] dp = new long[maxValueSum + 1];
		Arrays.fill(dp, Long.MAX_VALUE);
		dp[0] = 0; // Base case: 0 value requires 0 weight

		// Process each item
		for (int i = 0; i < n; i++) {
			int weight = weights[i];
			int value = values[i];

			// Update dp array backwards to avoid overwriting
			for (int v = maxValueSum; v >= value; v--) {
				if (dp[v - value] != Long.MAX_VALUE) {
					dp[v] = Math.min(dp[v], dp[v - value] + weight);
				}
			}
		}

		// Find the maximum value that can be achieved within the knapsack
		// capacity
		int maxValue = 0;
		for (int v = 0; v <= maxValueSum; v++) {
			if (dp[v] <= W) {
				maxValue = v;
			}
		}

		return maxValue;
	}
}

// this question is same as the first part
// only difference is that the weight value is very large ~ 10^9