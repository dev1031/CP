package data_dtructures;

import java.util.*;

public class MinQueue {

	public static int solve(int[]arr) {
		Queue<Integer> q = new LinkedList<>();
		for(int i : arr) {
			while(!q.isEmpty() && i < q.peek())
				q.poll();
			q.offer(i);
		}
		return q.peek();
	}
	public static void main(String[] args) {
		System.out.println(solve(new int[] {3,6,1,9,2,5}));
	}

}

//here in this method in order to get the min/max we re not storing all the elements and that is the downside of this mehtod