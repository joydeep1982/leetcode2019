/**
 * 
 * https://leetcode.com/problems/word-search-ii/
 * 
 */
package com.practice.ds.array;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {
	
	//["abcdefg","befa","eaabcdgfa","gfedcbaaa"]
	
	public static void main(String[] args) {
		WordSearchII obj = new WordSearchII();
		char[][] board = new char[][] {{'a','b', 'c'}, {'a', 'e', 'd'}, {'a', 'f', 'g'}};
		String[] words = new String[] {"eaabcdgfa"};
		List<String> found = obj.findWords(board, words);
		for (String string : found) {
			System.out.println("Found: " + string);
		}
	}
	
	public List<String> findWords(char[][] board, String[] words) {
        List<String> found = new ArrayList<String>();
        for (String word : words) {
            boolean flag = false;
            char ch = word.charAt(0);
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == ch) {
                        boolean[][] visited = new boolean[board.length][board[0].length];
                        if (isPresent(board, word, 0, i, j, visited)) {
                            found.add(word);
                            flag = true;
                            break;
                        }
                    }
                    if (flag) {
                        break;
                    }
                }
                if (flag) {
                    break;   
                }
             }
        }
        return found;
    }
    
    private boolean isPresent(char[][] board, String word, int pos, int i, int j, boolean[][] visited) {
        if (pos == word.length()) return true;
        if (i < 0 || i > board.length - 1) return false;
        if (j < 0 || j > board[i].length - 1) return false;
        if (visited[i][j]) return false;
//        System.out.println("visiting [" + i + ", " + j + "] ->" + board[i][j]);
        if (word.charAt(pos) == board[i][j]) {
        	System.out.println("visiting [" + i + ", " + j + "] ->" + board[i][j] + " looking for " + word.charAt(pos) + " pos: " + pos);
        	visited[i][j] = true;
            boolean ret = isPresent(board, word, pos + 1, i + 1, j, visited) || 
                isPresent(board, word, pos + 1, i - 1, j, visited) || 
                    isPresent(board, word, pos + 1, i, j + 1, visited) || 
                        isPresent(board, word, pos + 1, i, j - 1, visited);
            if (!ret) {
            	visited[i][j] = false;
            }
            
            return ret;
        }
        return false;
    }

}
