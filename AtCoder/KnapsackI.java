package AtCoder;
import java.util.*;

public class KnapsackI {

	public static int knapsack(int[] weight, int[] value, int capacity) {
		int n = weight.length;
		int[] dp = new int[capacity + 1];

		for (int i = 0; i < n; i++) {
			for (int w = capacity; w >= weight[i]; w--) {
				dp[w] = Math.max(dp[w], dp[w - weight[i]] + value[i]);
			}
		}

		return dp[capacity];
	}

	public static void main(String[] args) {
		int[] weight = {3, 4, 5};
		int[] value = {30, 50, 60};
		int capacity = 8;
		System.out.println(knapsack(weight, value, capacity));

	}
}
