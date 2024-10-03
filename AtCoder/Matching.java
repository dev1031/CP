package AtCoder;

import java.util.*;

public class Matching {

	static final int MOD = 1000000007;

	public static int countWays(int[][] compatibility) {
		int N = compatibility.length;

		// DP array to store the number of ways to pair the men given a mask of
		// paired women
		int[] dp = new int[1 << N]; // There are 2^N possible masks
		dp[0] = 1; // Base case: no men and no women paired, there's 1 way
					// (doing nothing)

		// Iterate over all masks
		for (int mask = 0; mask < (1 << N); mask++) {
			int manCount = Integer.bitCount(mask); // Count how many men have
													// been paired
			if (manCount >= N)
				continue; // No more men to pair

			// Try to pair the next man (manCount + 1) with any available woman
			for (int woman = 0; woman < N; woman++) {
				// If Woman 'woman' is not paired in this mask and is compatible
				if ((mask & (1 << woman)) == 0
						&& compatibility[manCount][woman] == 1) {
					int newMask = mask | (1 << woman); // Pair this woman by
														// setting her bit in
														// mask
					dp[newMask] = (dp[newMask] + dp[mask]) % MOD;
				}
			}
		}

		// The final result is when all men and all women are paired
		return dp[(1 << N) - 1]; // Mask with all N women paired
	}

	public static void main(String[] args) {
		// Example case
		int[][] compatibility = {{1, 1, 0}, {1, 0, 1}, {1, 1, 1}};

		int result = countWays(compatibility);
		System.out.println(result); // Output: the number of valid pairings
	}
}
