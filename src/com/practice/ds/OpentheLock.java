/**
 * 
 * https://leetcode.com/problems/open-the-lock/
 * 
 */
package com.practice.ds;

public class OpentheLock {
	
	public static void main(String[] args) {
		OpentheLock o = new OpentheLock();
		String[] deadends = new String[] {"0201","0101","0102","1212","2002"};
		int moves = o.openLock(deadends, "0202");
		System.out.println(moves);
	}

	public int openLock(String[] deadends, String target) {
		int moves = unlock(deadends, new int[] {0,0,0,0}, target);
		return moves == Integer.MAX_VALUE ? -1 : moves;
	}

	public int unlock(String[] deadends, int[] current, String target) {

		String result = String.valueOf(current[0]) + String.valueOf(current[1]) + String.valueOf(current[2])
				+ String.valueOf(current[3]);

		if (result == target) {
			return 1;
		}

		for (String d : deadends) {
			if (d.equals(result)) {
				return Integer.MAX_VALUE;
			}
		}

		int index = 0;
		int minMoves = Integer.MAX_VALUE;

		while (index < 4) {
			int num = current[index];
			current[index] = (num + 1) % 10;
			int r1 = unlock(deadends, current, target);
			minMoves = Math.min(minMoves, r1 + 1);

			current[index] = num == 9 ? 0 : num - 1;
			int r2 = unlock(deadends, current, target);
			minMoves = Math.min(minMoves, r2 + 1);

			current[index] = num;
			index++;
		}

		return minMoves;
	}

}
