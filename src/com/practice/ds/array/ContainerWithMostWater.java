/**
 * 
 * https://leetcode.com/problems/container-with-most-water/
 * 
 */
package com.practice.ds.array;

public class ContainerWithMostWater {

	public static void main(String[] args) {
		ContainerWithMostWater o = new ContainerWithMostWater();
		int max = o.maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 });
		System.out.println(max);
	}

	public int maxArea(int[] height) {
		int max = 0;
		int left = 0;
		int right = height.length - 1;

		while (left < right) {
			int area = Math.min(height[left], height[right]) * (right - left);
			System.out.println("left: " + left + " right: " + right + " area: " + area);
			max = Math.max(max, area);
			if (height[left] > height[right]) {
				right--;
			}
			else {
				left++;
			}
		}

		return max;
	}

}
