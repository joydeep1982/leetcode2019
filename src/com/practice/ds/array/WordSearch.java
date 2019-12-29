/**
 * 
 * https://leetcode.com/problems/word-search/
 * 
 */

package com.practice.ds.array;

import java.util.HashSet;
import java.util.Set;

public class WordSearch {

	public static void main(String[] args) {
		char[][] board = { 
				{ 'A', 'B', 'C', 'E' }, 
				{ 'S', 'F', 'E', 'S' }, 
				{ 'A', 'D', 'E', 'E' } 
		};
//		char[][] board = { 
//				{ 'A', 'B'},
//				{ 'C', 'D' } 
//		};
		WordSearch obj = new WordSearch();
//		System.out.println(obj.exist(board, "ABCCED"));
//		System.out.println(obj.exist(board, "SEE"));
//		System.out.println(obj.exist(board, "ABCB"));
		System.out.println(obj.exist(board, "ABCESEEEFS"));
	}

	public boolean exist(char[][] board, String word) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == word.charAt(0)) {
					if (recursiveSearch(board, i, j, word, 0, new HashSet<Pair>())) {
						return true;
					}
				}
			}
		}
		// recursiveSearch(board, board.length, board[0].length, word);
		return false;
	}

	private boolean recursiveSearch(char[][] board, int i, int j, String word, int pos, Set<Pair> bag) {
		int row = board.length;
		int col = board[0].length;
		Pair pair = new Pair(i, j);
		if (i < 0 || i >= row || j < 0 || j >= col) {
			return false;
		}
		if (bag.contains(pair)) {
			return false;
		}
		if (board[i][j] == word.charAt(pos)) {
			bag.add(pair);
			if (pos == word.length() - 1) {
				return true;
			}

			boolean ret = recursiveSearch(board, i + 1, j, word, pos + 1, bag)
					|| recursiveSearch(board, i, j + 1, word, pos + 1, bag)
					|| recursiveSearch(board, i - 1, j, word, pos + 1, bag)
					|| recursiveSearch(board, i, j - 1, word, pos + 1, bag);
			if (!ret) {
				bag.remove(pair);
			}
			return ret;
		}
		return false;

	}
}

class Pair {
	int i;
	int j;

	Pair(int i, int j) {
		this.i = i;
		this.j = j;
	}
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Pair) {
			Pair p = (Pair) obj;
			return this.i == p.i && this.j == p.j;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return this.i * this.j;
	}
}