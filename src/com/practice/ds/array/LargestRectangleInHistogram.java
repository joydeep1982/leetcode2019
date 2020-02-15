package com.practice.ds.array;

import java.util.Stack;

public class LargestRectangleInHistogram {

	public static void main(String[] args) {
		LargestRectangleInHistogram o = new LargestRectangleInHistogram();
		int area = o.largestRectangleArea(new int[] { 4, 2, 0, 3, 2, 5 });
		System.out.println(area);
	}

	public int largestRectangleArea(int[] heights) {
		if (heights.length == 0)
			return 0;

		Stack<Integer> stack = new Stack<Integer>();
		int maxArea = 0;
		int i = 0;

		while (i < heights.length) {
			if (stack.isEmpty() || heights[i] >= heights[stack.peek()]) {
				stack.add(i++);
			} else {

				while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
					int index = stack.pop();
					if (stack.isEmpty()) {
						maxArea = Math.max(maxArea, heights[index] * i);
					} else {
						maxArea = Math.max(maxArea, heights[index] * (i - stack.peek() - 1));
					}
				}
			}
		}
		
		while (!stack.isEmpty()) {
			int index = stack.pop();
			if (stack.isEmpty()) {
				maxArea = Math.max(maxArea, heights[index] * i);
			} else {
				maxArea = Math.max(maxArea, heights[index] * (i - stack.peek() - 1));
			}
		}

		return maxArea;
	}
}
