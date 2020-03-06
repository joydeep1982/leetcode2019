/**
 * 
 * https://leetcode.com/problems/coin-change-2/
 * 
 */
package com.practice.ds.array;

import com.practice.ds.miscell.Utils;

public class CoinChange2 {
	
	public static void main(String[] args) {
		CoinChange2 o = new CoinChange2();
		int count = o.change(5, new int[] {1,2,5});
		System.out.println(count);
	}
	
	public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount + 1];
        
        for (int i = 0; i < coins.length; i++) {
        	int coin = coins[i];
        	System.out.println("coin: " + coin);
        	for (int j = coin; j <= amount; j++) {
    			System.out.println(i + ", " + j);
    			System.out.println("coin - j: " + (j - coin));
    			int usingCoin = dp[i][j - coin];
    			int withoutUsingCoin = (i > 0) ? dp[i-1][j] : 0;
    			dp[i][j] = withoutUsingCoin + usingCoin;
        	}
        }
        
        Utils.print(dp);
        
        return dp[dp.length - 1][dp[0].length - 1];
    }

}
