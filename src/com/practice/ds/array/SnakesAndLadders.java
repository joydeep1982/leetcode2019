/**
 * 
 * https://leetcode.com/problems/snakes-and-ladders/
 * 
 */
package com.practice.ds.array;

import com.practice.ds.miscell.Utils;

public class SnakesAndLadders {
	
	public static void main(String[] args) {
		SnakesAndLadders o = new SnakesAndLadders();
//		int moves = o.snakesAndLadders(new int[][] {
//			{36,35,34,33,32,31},
//			{25,26,27,28,29,30},
//			{24,23,22,21,20,19},
//			{13,14,15,16,17,18},
//			{12,11,10,9,8,7},
//			{1,2,3,4,5,6}
//		});
		
		int moves = o.snakesAndLadders(new int[][] {
			{-1,-1,-1,-1,-1,-1},
			{-1,-1,-1,-1,-1,-1},
			{-1,-1,-1,-1,-1,-1},
			{-1,35,-1,-1,13,-1},
			{-1,-1,-1,-1,-1,-1},
			{-1,15,-1,-1,-1,-1}
		});
	}
	
	public int snakesAndLadders(int[][] board) {
        boolean[][] pathMap = new boolean[board.length * board.length][board.length * board.length];
        
        int direction = 1;
        int j = 0;
        int counter = 0;
        for (int i = board.length - 1; i >= 0; i--) {
        	while (j < board.length && j >= 0) {
        		for (int x = 1; x < 7; x++) {
        			if (counter + x >= board.length * board.length)
        				break;
        			if (board[i][j + counter] != -1) {
        				pathMap[counter][board[i][j]] = true;
        				continue;
        			}
        			pathMap[counter][counter + x] = true;
        		}
        		j += direction;
        		counter++;
        	}
        	
        	direction = direction * -1;
        	j += direction;
        }
        
        Utils.print(pathMap, "T", ".");
        
        return 0;
    }

}
