package AtCoder;

import java.util.*;

public class FrogI {

	public static void solve(int[] arr) {
		int n = arr.length;
		int[] dp = new int[n];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for (int i = 0; i < n; i++) {
			for (int j : new int[]{i + 1, i + 2}) {
				if (j < n)
					dp[j] = Math.min(dp[j], dp[i] + Math.abs(arr[i] - arr[j]));
			}
		}

		System.out.println(dp[n - 1]);
	}

	public static void main(String[] args) {
		solve(new int[]{10, 20, 30, 40});
	}
}
