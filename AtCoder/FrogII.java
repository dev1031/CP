package AtCoder;
import java.util.*;

public class FrogII {
	public static void solve(int[] h, int k) {
		int n = h.length;
		int[] dp = new int[n];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j <= i + k; j++) {
				if (j < n)
					dp[j] = Math.min(dp[j], dp[i] + Math.abs(h[i] - h[j]));
			}
		}
		System.out.println(dp[n - 1]);
	}

	public static void main(String[] args) {
		solve(new int[]{40, 10, 20, 70, 80, 10, 20, 70, 80, 60}, 4);
	}
}
