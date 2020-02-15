/**
 * 
 * https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/
 * 
 */
package com.practice.ds;

import com.practice.ds.miscell.Utils;

public class NumberOfDiceRollsWithTargetSum {

	public static void main(String[] args) {
		NumberOfDiceRollsWithTargetSum obj = new NumberOfDiceRollsWithTargetSum();
		obj.numRollsToTarget(3, 6, 11);
//		obj.numRollsToTarget(2, 5, 10);
//		obj.numRollsToTarget(30, 30, 500);
	}

	public int numRollsToTarget(int d, int f, int target) {
		int[][] dp = new int[d][target + 1];

		for (int i = 1; i <= Math.min(f, target); i++) {
			dp[0][i] = 1;
		}

		for (int dice = 1; dice < d; dice++) {
			int max = (dice + 1) * f;
			for (int i = 1; i <= Math.min(target, max); i++) {
				int sum = 0;
				for (int j = 1; j <= Math.min(i, f); j++) {
					sum += dp[dice - 1][i - j];
				}
				dp[dice][i] = sum;
			}
		}

		Utils.print(dp);
		return dp[d-1][target];
	}

}
