/**
 * 
 * https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
 * 
 */
package com.practice.ds.array;

import com.practice.ds.miscell.Utils;

public class LongestIncreasingPathInAMatrix {
	
	public static void main(String[] args) {
		LongestIncreasingPathInAMatrix o = new LongestIncreasingPathInAMatrix();
		int[][] matrix = new int[][] {
			{9,9,4},
			{6,6,8},
			{2,1,1}
		};
		matrix = new int[][] {
			{7,7,5},
			{2,4,6},
			{8,2,0}
		};
		matrix = new int[][] {
			{13, 5,  13, 9},
			{5,  0,  2,  9},
			{10, 13, 11, 10},
			{0,  0,  13, 13}
		};
		matrix = new int[][] {
			{1, 2,  3, 4},
			{8,  7,  6,  5},
			{9, 10, 11, 12},
			{16,  15,  14, 13}
		};
		int longest = o.longestIncreasingPath(matrix);
		System.out.println(longest);
	}
	
	public int longestIncreasingPath(int[][] matrix) {
        int max = 0;
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[i].length; j++) {
//                boolean[][] visited = new boolean[matrix.length][matrix[0].length];
//                int now = maxPath(matrix, visited, Integer.MIN_VALUE, i, j, 0);
//                if (now > max) {
//                	max = now;
//                	Utils.print(visited, "T", "-");
//                }
//            }
//        }
        
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        max = maxPath(matrix, visited, Integer.MIN_VALUE, 1, 1, 0);
        return max;
    }
    
    public int maxPath(int[][] matrix, boolean[][] visited, int max, int i, int j, int level) {
    	
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[i].length) {
            return 0;
        }
        if (visited[i][j]) {
        	System.out.println("visited  " + i + ", " +  j);
            return 0;
        }
        System.out.println(i + ", " +  j);
        visited[i][j] = true;
        if (matrix[i][j] > max) {
        	int bottom = maxPath(matrix, visited, matrix[i][j], i + 1, j, level + 1);
            int right = maxPath(matrix, visited, matrix[i][j], i, j + 1, level + 1);
        	int left = maxPath(matrix, visited, matrix[i][j], i, j - 1, level + 1);
            int top = maxPath(matrix, visited, matrix[i][j], i - 1, j, level + 1);
            
            int ret= 1 + Math.max(Math.max(top, bottom), Math.max(left,right));
            
//            System.out.println();
//        	for(int x = 0; x < level; x++) {
//        		System.out.print("-");
//        	}
//        	System.out.print("(" + i + ", " + j + ") -> " + matrix[i][j] +  " returning ");
//            System.out.print(ret);
//            System.out.println();
            
            return ret;
        }
        visited[i][j] = false;
        return 0;
    }

}
