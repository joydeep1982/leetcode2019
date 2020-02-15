/**
 * 
 * https://leetcode.com/problems/subarray-sums-divisible-by-k/
 * 
 */
package com.practice.ds.array;

public class SubarraySumsDivisibleByK {

	public static void main(String[] args) {
		SubarraySumsDivisibleByK obj = new SubarraySumsDivisibleByK();
		int ans = obj.subarraysDivByK(new int[] { 4, 5, 0, -2, -3, 1 }, 5);
		System.out.println("Ans: " + ans);
	}

	public int subarraysDivByK(int[] A, int K) {
		int[][] dp = new int[A.length][A.length];
		int count = 0;

		for (int i = 0; i < A.length; i++) {
			int sum = 0;
			for (int j = i; j < A.length; j++) {
				if (i == j)
					sum = sum + A[i];
				else
					sum = sum + A[j];
				if (sum % K == 0)
					count++;
			}
		}

		// Utils.print(dp);

		return count;
	}
}
