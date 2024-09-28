package AtCoder;

public class Coins {
	public static void solve(double[] p) {
		int n = p.length;
		double[] dp = new double[n + 1];
		dp[0] = 1.0;
		for (int i = 1; i <= n; i++) {
			for (int h = i; h >= 0; h--) {
				if (h > 0)
					dp[h] = dp[h - 1] * p[i - 1] + dp[h] * (1 - p[i - 1]);
				else
					dp[h] = dp[h] * (1 - p[i - 1]);
			}
		}
		double tp = 0.0;
		for (int h = n / 2 + 1; h <= n; h++)
			tp += dp[h];

		System.out.println(tp);
	}

	public static void main(String[] args) {
		double[] p = {0.3, 0.6, 0.8};
		solve(p);
	}
}
