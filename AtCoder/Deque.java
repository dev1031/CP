package AtCoder;

public class Deque {
	public static void solve(int[] arr) {
		final int MAX = 300;
		int n = arr.length;
		int[][] dp = new int[MAX][MAX];
		for (int L = n - 1; L >= 0; L--) {
			for (int R = L; R < n; R++) {
				if (L == R)
					dp[L][R] = arr[L];
				else
					dp[L][R] = Math.max(arr[L] - dp[L + 1][R],
							arr[R] - dp[L][R - 1]);
			}
		}

		System.out.println(dp[0][n - 1]);
	}

	public static void main(String[] args) {
		// solve(new int[]{1000000000, 1, 1000000000, 1, 1000000000, 1,
		// 1000000000,
		// 1, 1000000000, 1});
		solve(new int[]{10, 80, 90, 30});
	}
}
// not working for big intput data arr[i] ~ 10^9