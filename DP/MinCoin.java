package DP;

import java.util.*;

public class MinCoin {
	public static int min_coin(int[] w, int S) {
		int[] dp = new int[S + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		int n = w.length;
		for (int P = 1; P <= S; P++) {
			for (int i = 0; i < n; i++) {
				if (w[i] <= P)
					dp[P] = Math.min(dp[P], dp[P - w[i]] + 1);
			}
		}
		System.out.println(dp[S]);
		return dp[S] >= 1000000 ? -1 : dp[S];
	}

	public static void main(String[] args) {
		min_coin(new int[]{1, 3, 5}, 11);
	}
}
