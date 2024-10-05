package DP;
import java.util.*;

public class MinCoin {
	public static int min_coin(int[] w, int S) {
		int[] dp = new int[S + 1];
		int[] ways = new int[S + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);

		// Base case: 0 weight can be achieved with 0 coins
		dp[0] = 0;
		int n = w.length;
		for (int P = 1; P <= S; P++) {
			for (int i = 0; i < n; i++) {
				if (w[i] <= P) {
					dp[P] = Math.min(dp[P], dp[P - w[i]] + 1);
					ways[P] = ways[P] + 1;
				}
			}
		}
		System.out.println(ways[S]);
		return dp[S] >= 1000000 ? -1 : dp[S];
	}

	public static void number_of_ways(int[] w, int S) {
		int[] dp = new int[S + 1];

		// Base case: 1 way to make 0 weight (by choosing no coins)
		dp[0] = 1;
		int n = w.length;
		// Loop through each coin type
		for (int i = 0; i < n; i++) {
			// For each coin, update the number of ways to make all weights from
			// that coin's weight up to S
			for (int P = w[i]; P <= S; P++) {
				dp[P] += dp[P - w[i]];
			}
		}

		// The answer is the number of ways to achieve weight S
		int answer = dp[S];
		System.out
				.println("Number of ways to make weight " + S + ": " + answer);
	}

	public static void main(String[] args) {
		min_coin(new int[]{1, 3, 5}, 11);
		number_of_ways(new int[]{1, 3, 5}, 11);
	}
}
