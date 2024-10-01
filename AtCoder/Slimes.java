package AtCoder;

public class Slimes {
	public static void solve(long[] arr) {
		int n = arr.length;
		final int MAX = 405;
		final long INF = 1000000000000000005L;
		long[][] dp = new long[MAX][MAX];

		for (int L = n - 1; L >= 0; L--) {
			for (int R = L; R < n; R++) {
				if (L == R)
					dp[L][R] = 0;
				else {
					dp[L][R] = INF;
					long s = sum(L, R, arr);
					for (int i = L; i <= R - 1; i++)
						dp[L][R] = Math.min(dp[L][R],
								dp[L][i] + dp[i + 1][R] + s);
				}
			}
		}
		System.out.println(dp[0][n - 1]);
	}

	public static long sum(int L, int R, long[] arr) {
		long sum = 0;
		for (int i = L; i <= R; i++)
			sum += arr[i];
		return sum;
	}

	public static void main(String[] args) {
		solve(new long[]{1000000000, 1000000000, 1000000000});
	}
}
