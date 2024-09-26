package data_dtructures;

import java.util.*;

public class MinStack {
	
	public static int solve(int[] arr) {
		Stack<int[]> st = new Stack<>();
		for(int i : arr) {
			int new_min = st.isEmpty() ? i : Math.min(i,st.peek()[1]);
			int[] temp = new int[]{i,new_min};
			st.push(temp);
		}
		return st.peek()[1];
	}

	public static void main(String[] args) {
		System.out.println(solve(new int[] {3,6,1,9,2,5}));
	}

}

//We are getting the min in O(1) time