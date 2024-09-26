package data_dtructures;

import java.util.Stack;

public class MinQueueII {
	
	public Stack<int[]> s1 = new Stack<>();
	
	public Stack<int[]> s2 = new Stack<>();
	
	public void add(int num) {
		//adding the elements in stack 1;
		int min = s1.isEmpty() ? num : Math.min(s1.peek()[1],num);
		int new_elemment = num;
		s1.push(new int[] {new_elemment,min});
	}
	
	public void remove() {
		if(s2.isEmpty()) {
			while(!s1.isEmpty()) {
				int new_element = s1.peek()[0];
				int new_min = s2.isEmpty() ? new_element  : Math.min(new_element,s2.peek()[1]);
				s2.push(new int[] {new_element, new_min});
				s1.pop();
			}
		}
		int remove_elem = s2.peek()[0];
		s2.pop();
	}
	
	public int find_min() {
		if(s1.isEmpty() || s2.isEmpty())
			return s1.isEmpty() ? s2.peek()[1] : s1.peek()[1];
		else
			return Math.min(s1.peek()[1],s2.peek()[1]);
	}

	public static void main(String[] args) {
		MinQueueII minQueueII = new MinQueueII();
		
		int[] arr = new int[]{3,6,1,9,2,5};
		for(int i : arr) {
			minQueueII.add(i);
		}
		
		System.out.println(minQueueII.find_min());
	}
}

//Here we have implemted the queue using two stacks
// this gives us min/max element in O(1) time
// it also saves all the elemetsg
