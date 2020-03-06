/**
 * 
 * https://leetcode.com/problems/n-queens/submissions/
 * 
 */
package com.practice.ds.array;

import java.util.ArrayList;
import java.util.List;

public class NQueen {
	
	public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<List<String>>();
        boolean[][] board = new boolean[n][n];
        solve(board, 0, results);
        return results;
    }
    
    public void solve(boolean[][] board, int row, List<List<String>> results) {
        if(row == board.length) {
            // result found
            results.add(getStringRepresentationofBoard(board));
            return;
        }
        for (int i = 0; i < board.length; i++) {
            if (!board[row][i] && isQueenSafe(board, row, i)) {
                board[row][i] = true;
                solve(board, row + 1, results);
                board[row][i] = false;
            }
        }
    }
    
    public boolean isQueenSafe(boolean[][] board, int row, int col) {
        // ensure up, down, left, right
        for (int i = 0; i < board.length; i++) {
            if (board[row][i]) {
                return false;
            }
            if (board[i][col]) {
                return false;
            }
        }
        
        int i = row - 1;
        int j = col - 1;
        // ensure diagonals
        while (i >= 0 && j>= 0) {
            if (board[i][j]) {
                return false;
            }
            i--;
            j--;
        }
        
        i = row - 1;
        j = col + 1;
        while (i >= 0 && j < board.length)  {
            if (board[i][j]) {
                return false;
            }
            i--;
            j++;
        }
        
        return true;
    }
    
    public List<String> getStringRepresentationofBoard(boolean[][] board) {
        List<String> boardResult = new ArrayList<String>();
        StringBuilder sb;
        for (int i = 0; i < board.length; i++) {
            sb = new StringBuilder();
            for (int j = 0; j < board.length; j++) {
                sb.append(board[i][j] ? "Q" : ".");
            }
            boardResult.add(sb.toString());
        }
        
        return boardResult;
    }

}
