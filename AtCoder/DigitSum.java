package AtCoder;

import java.util.Arrays;

public class DigitSum {
	static final int MOD = 1000000007;
	static int[][][] dp;
	static int D;

	// Helper function to apply the digit DP
	public static int solveDigitDP(String K, int D) {
		int n = K.length();
		dp = new int[n + 1][D][2]; // dp[pos][sum][tight]
		for (int[][] layer : dp) {
			for (int[] row : layer) {
				Arrays.fill(row, -1);
			}
		}
		DigitSum.D = D;
		return digitDP(0, 0, 1, K) - 1; // -1 because we don't want to count 0
	}

	// Recursive DP function
	public static int digitDP(int pos, int sum, int tight, String K) {
		if (pos == K.length()) {
			return sum % D == 0 ? 1 : 0;
		}

		if (dp[pos][sum][tight] != -1) {
			return dp[pos][sum][tight];
		}

		int limit = tight == 1 ? K.charAt(pos) - '0' : 9;
		int res = 0;

		for (int digit = 0; digit <= limit; digit++) {
			int newTight = (tight == 1 && digit == limit) ? 1 : 0;
			res = (res + digitDP(pos + 1, (sum + digit) % D, newTight, K))
					% MOD;
		}

		return dp[pos][sum][tight] = res;
	}

	public static void main(String[] args) {
		String K = "12345678901234567890"; // Example of a large K, modify for
											// your input
		int D = 5;
		System.out.println(solveDigitDP(K, D));
	}
}
