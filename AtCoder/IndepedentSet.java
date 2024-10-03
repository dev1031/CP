package AtCoder;
import java.util.*;

public class IndepedentSet {
	static final int MOD = 1000000007;
	static List<Integer>[] tree;

	public static long[] dfs(int u, int parent) {
		long[] dp = new long[2]; // dp[0] = white, dp[1] = black
		dp[0] = dp[1] = 1; // Initial: each node can be painted either black or
							// white alone

		for (int v : tree[u]) {
			if (v == parent)
				continue; // Skip the parent node to avoid cycles
			long[] childDP = dfs(v, u); // Get the dp for the child

			// If u is white, v can be either black or white
			dp[0] = dp[0] * (childDP[0] + childDP[1]) % MOD;

			// If u is black, v must be white
			dp[1] = dp[1] * childDP[0] % MOD;
		}

		return dp;
	}

	public static long countWays(int N, List<int[]> edges) {
		// Initialize tree
		tree = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			tree[i] = new ArrayList<>();
		}

		for (int[] edge : edges) {
			int u = edge[0], v = edge[1];
			tree[u].add(v);
			tree[v].add(u);
		}

		// Start DFS from node 1 (assuming node 1 exists)
		long[] result = dfs(1, -1);

		// The result is the sum of both possibilities (root painted white or
		// black)
		return (result[0] + result[1]) % MOD;
	}

	public static void main(String[] args) {
		// Example test case
		int N = 4;
		List<int[]> edges = Arrays.asList(new int[]{1, 2}, new int[]{2, 3},
				new int[]{3, 4});

		System.out.println(countWays(N, edges)); // Output: 8
	}
}
