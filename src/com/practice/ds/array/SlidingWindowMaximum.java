package com.practice.ds.array;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {

	public static void main(String[] args) {
		SlidingWindowMaximum obj = new SlidingWindowMaximum();

		int[] increasing = new int[] { 1, 2, 3, 4, 5, 6 };
		int[] decreasing = new int[] { 6, 5, 4, 3, 2, 1 };
		int[] flat = new int[] { 3, 3, 3, 3, 3, 3 };
		int[] input = new int[] { 1, 3, -1, -3, 5, 3, 6, 7 };
		int[] input1 = new int[] {1, -1};
		int[] input2 = new int[] {1,3,1,2,0,5};

		int[] result = obj.maxSlidingWindow(input2, 3);
		for (int r : result) {
			System.out.print(r + ", ");
		}
	}

	public int[] maxSlidingWindow(int[] nums, int k) {
		int[] results = new int[nums.length - k + 1];

		Deque<Integer> dq = new ArrayDeque<Integer>();

		for (int i = 0; i < k; i++) {
			int curr = nums[i];

			while (!dq.isEmpty()) {
				int index = dq.peekLast();
				if (curr > nums[index]) {
					dq.removeLast();
					continue;
				}
				break;
			}

			dq.offerLast(i);
		}

		int counter = 0;
		for (int i = k; i < nums.length; i++) {
			results[counter] = nums[dq.peekFirst()];
			counter++;
			int curr = nums[i];

			while (!dq.isEmpty()) {
				int index = dq.peekLast();
				System.out.println("index: " + index + " for i: " + i + " and k:" + k);
				if  (index <= i - k) {
					System.out.println("removed");
					dq.remove();
					continue;
				}
				if (curr > nums[index]) {
					dq.removeLast();
					continue;
				}
				break;
			}

			dq.offerLast(i);
		}

		results[results.length - 1] = nums[dq.pollFirst()];

		return results;
	}

}
