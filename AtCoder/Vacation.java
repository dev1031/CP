package AtCoder;

public class Vacation {

	public static void solve(int n, int[][] arr) {
		int[] dp = new int[3];
		for (int[] r : arr) {
			int[] new_dp = new int[3];
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (i != j)
						new_dp[j] = Math.max(new_dp[j], dp[i] + r[j]);
				}
			}
			dp = new_dp;
		}

		System.out.println(Math.max(dp[0], Math.max(dp[1], dp[2])));
	}

	public static void main(String[] args) {
		int n = 3;
		int[][] arr = {{10, 40, 70}, {20, 50, 80}, {30, 60, 90}};
		solve(n, arr);
	}
}
