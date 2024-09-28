package AtCoder;

import java.util.Arrays;

public class GridI {
	private static int MOD = 1000000007;
	public static void solve(char[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int[][] dp = new int[m][n];

		// Initialize the first row and first column
		for (int i = 0; i < m; i++) {
			if (grid[i][0] == '#')
				break; // If there's an obstacle, no more cells in this column
						// are reachable
			dp[i][0] = 1;
		}

		for (int j = 0; j < n; j++) {
			if (grid[0][j] == '#')
				break; // If there's an obstacle, no more cells in this row are
						// reachable
			dp[0][j] = 1;
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (grid[i][j] != '#')
					dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD;
			}
		}
		System.out.println(dp[m - 1][n - 1]);
	}

	public static void main(String[] args) {
		char[][] grid = {{'.', '.', '.', '#'}, {'.', '#', '.', '.'},
				{'.', '.', '.', '.'}};
		solve(grid);
	}
}
