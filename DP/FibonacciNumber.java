package DP;

public class FibonacciNumber {

	// Method 1 ~ TC - O(n), SC - O(n)

	public static int firstMehtod(int n) {
		final int MAXN = 100;
		int[] fib = new int[MAXN];
		fib[0] = 0;
		fib[1] = 1;

		for (int i = 2; i <= n; i++)
			fib[i] = fib[i - 1] + fib[i - 2];
		return fib[n];
	}

	// Method 1 ~ TC - O(n), SC - O(1)

	public static int secondMethod(int n) {
		final int MAXN = 3;
		int[] fib = new int[MAXN];
		fib[0] = 0;
		fib[1] = 1;

		for (int i = 2; i <= n; i++)
			fib[i % MAXN] = fib[(i - 1) % MAXN] + fib[(i - 2) % MAXN];
		return fib[n % MAXN];
	}

	public static void main(String[] args) {
		System.out.println(firstMehtod(5));
		System.out.println(secondMethod(5));
	}

}
