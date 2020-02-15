/**
 * 
 * https://leetcode.com/problems/jump-game/
 * 
 */
package com.practice.ds.array;

public class JumpGame {

	public static void main(String[] args) {
		JumpGame jg = new JumpGame();
//		boolean possible = jg.canJump(new int[] { 3, 2, 1, 0, 4 });
		boolean possible = jg.canJump(new int[] { 2, 3, 1, 1, 4 });
		System.out.println(possible);
	}

	public boolean canJump(int[] nums) {
		int lastPossiblePosition = nums.length - 1;
		for (int i = nums.length - 1; i >= 0; i--) {
			if (nums[i] >= lastPossiblePosition - i) {
				System.out.println("at index: " + i + " lastpos: " + lastPossiblePosition);
				lastPossiblePosition = i;
			}
		}
		return (lastPossiblePosition == 0) ? true : false;
	}

}
