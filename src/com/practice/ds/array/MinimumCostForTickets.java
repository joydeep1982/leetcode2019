/**
 * 
 * https://leetcode.com/problems/minimum-cost-for-tickets/
 * 
 */
package com.practice.ds.array;

import com.practice.ds.miscell.Utils;

public class MinimumCostForTickets {

	public static void main(String[] args) {
		MinimumCostForTickets o = new MinimumCostForTickets();
		int min = o.mincostTickets2(new int[] { 1, 4, 6, 7, 8, 20 }, new int[] { 2, 7, 15 });
		System.out.println(min);
		min = o.mincostTickets(new int[] { 1, 4, 6, 7, 8, 20 }, new int[] { 2, 7, 15 });
		System.out.println(min);
	}
	
	public int mincostTickets2(int[] days, int[] costs) {
        int n = days[days.length - 1];
        boolean[] travelling = new boolean[n + 1];
        int[] dp = new int[n + 1];
        
        for (int d : days) {
            travelling[d] = true;
        }
        
        for (int i = 1; i < dp.length; i++) {
            if (!travelling[i]) {
                dp[i] = dp[i-1];
                continue;
            }
            int one = dp[i-1] + costs[0];
            int seven = dp[Math.max(i-7, 0)] + costs[1];
            int thirty = dp[Math.max(i-30, 0)] + costs[2];
            dp[i] = Math.min(Math.min(one, seven), thirty);
        }
        
        return dp[dp.length - 1];
    }
	
	public int mincostTickets(int[] days, int[] costs) {
        int n = days[days.length - 1];
        boolean[] travelling = new boolean[n + 1];
        int[] dp = new int[n + 1];
        
        for (int d : days) {
            travelling[d] = true;
        }
        
        for (int i = 1; i < dp.length; i++) {
            if (!travelling[i]) {
                dp[i] = dp[i-1];
                continue;
            }
            int one = dp[i-1] + costs[0];
            int seven = dp[Math.max(i-7, 0)] + costs[1];
            int thirty = dp[Math.max(i-30, 0)] + costs[2];
            dp[i] = Math.min(Math.min(one, seven), thirty);
        }
        Utils.print(dp);
        
        return dp[dp.length - 1];
    }

	public int mincostTickets1(int[] days, int[] costs) {
		int maxdays = days[days.length - 1];
		int[][] dp = new int[costs.length][maxdays];
		
		for (int i = 0; i < costs.length; i++) {
			for (int j = 0; j < maxdays; j++) {
				//dp[i][j]
			}
		}
		
		Utils.print(dp);
		return 0;
	}

}
