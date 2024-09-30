package AtCoder;

import java.util.*;

public class LongestPath {
	public static int solve(Map<Integer, List<Integer>> graph, int e, int v) {
		boolean[] visited = new boolean[v + 1];
		int[] dp = new int[v + 1];
		for (int i = 1; i <= v; i++) {
			if (!visited[i])
				dfs(i, visited, dp, graph);
		}

		int max = 0;
		for (int i : dp)
			max = Math.max(max, i);

		return max;
	}

	public static void dfs(int source, boolean[] visited, int[] dp,
			Map<Integer, List<Integer>> graph) {
		if (visited[source])
			return;

		visited[source] = true;

		for (int i : graph.get(source)) {
			if (!visited[i]) {
				dfs(i, visited, dp, graph);
			}
			dp[source] = Math.max(dp[source], dp[i] + 1);
		}
	}

	public static void main(String[] args) {
		int e = 5;
		int v = 4;
		Map<Integer, List<Integer>> graph = new HashMap<>();
		graph.put(1, Arrays.asList(2, 3, 4));
		graph.put(2, Arrays.asList(4));
		graph.put(3, Arrays.asList(2, 4));
		graph.put(4, new ArrayList<>());
		System.out.println(solve(graph, e, v));
	}
}
