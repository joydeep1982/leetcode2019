package com.practice.ds.array;

import java.util.Arrays;

public class MinCoins {

	public static void main(String[] args) {
		MinCoins obj = new MinCoins();
//		int minCoinsRequired = obj.coinChange(new int[] { 186, 419, 83, 408}, 6249);
		int minCoinsRequired = obj.coinChange(new int[] { 2, 7, 10}, 16);
		System.out.println(minCoinsRequired);
	}

	public int minCoins(int[] coins, int value) {
		int[][] solutions = new int[coins.length][value + 1];
		Arrays.sort(coins);
		
		for (int i = 0; i < coins.length; i++) {
			int coin = coins[i];
			for (int j = 0; j < value  + 1; j++) {
				if (j == 0) {
					solutions[i][j] = 0;
				}
				if (i == 0) {
					solutions[i][j] = (j % coin == 0) ? j / coin : 0;
					continue;
				}
				
				if (j < coin) {
					solutions[i][j] = solutions[i-1][j];
					continue;
				}
				
				int coinsRequired = j / coin;
				int balanceRemaining = j % coin;
				
				int previousSolution = solutions[i - 1][j];
				
				if (balanceRemaining > 0 && solutions[i][balanceRemaining] == 0) {
					solutions[i][j] = previousSolution;
					continue;
				}
				
				coinsRequired += solutions[i][balanceRemaining];
				
				solutions[i][j] = previousSolution > 0 ? Math.min(coinsRequired, previousSolution) : coinsRequired;
			}
		}
		print(solutions);
		return solutions[coins.length - 1][value] == 0 ? -1 : solutions[coins.length - 1][value];
	}
	
	public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for(int i = 1; i <= amount; i++){
            dp[i] = amount+1;
            for(int c : coins){
                if(i >= c){
                    dp[i] = Math.min(dp[i-c]+1, dp[i]);
                }
            }
        }
        // System.out.println(Arrays.toString(dp));
        return (dp[amount] == amount+1)? -1 : dp[amount];
    }
	
	private void print(int[][] solutions) {
		for (int j = 0; j < solutions[0].length; j++) {
			System.out.print(String.format("%4d,", j));
		}
		System.out.println();
		System.out.println("-----------------------------------------------------------------------------------------------");
		
		for (int i = 0; i <  solutions.length; i++) {
			for (int j = 0; j < solutions[0].length; j++) {
				System.out.print(String.format("%4d,", solutions[i][j]));
			}
			System.out.println("");
		}
	}
}
