package AtCoder;
import java.util.*;

public class LCS {
	public static void solve(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();
		int[][] dp = new int[m + 1][n + 1];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (s1.charAt(i) == s2.charAt(j)) {
					dp[i + 1][j + 1] = dp[i][j] + 1;
				} else
					dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
			}
		}
		System.out.println(dp[m][n]);// lcs size
		// we have to find the string that is common in both the strings
		StringBuilder lcs = new StringBuilder();
		int i = m, j = n;

		// Start from dp[m][n] and work our way backwards
		while (i > 0 && j > 0) {
			if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
				// If characters are the same, it's part of the LCS
				lcs.append(s1.charAt(i - 1));
				i--;
				j--;
			} else {
				// Otherwise, move in the direction of the larger value
				if (dp[i - 1][j] > dp[i][j - 1]) {
					i--;
				} else {
					j--;
				}
			}
		}

		// Since we append characters from the end, reverse the string
		String cs = lcs.reverse().toString();
		System.out.println(cs);
	}

	public static void main(String[] args) {
		String s1 = "abracadabra";
		String s2 = "avadakedavra";
		solve(s1, s2);
	}
}
