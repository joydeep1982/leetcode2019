/**
 * 
 * https://leetcode.com/problems/unique-paths/
 * 
 */
package com.practice.ds.array;

public class UniquePaths {

	public static void main(String[] args) {
		UniquePaths obj = new UniquePaths();
		int max = obj.uniquePaths(3, 7);
		System.out.println(max);
	}

	public int uniquePaths(int m, int n) {
		int[][] paths = new int[m][n];
		paths[0][0] = 0;

//		for (int i = 0; i < m; i++) {
//			paths[i][0] = 1;
//		}
//
//		for (int i = 0; i < n; i++) {
//			paths[0][i] = 1;
//		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if(i == 0 || j == 0) paths[i][j] = 1;
				else paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
			}
		}

		System.out.println();
		for (int i = 0; i < m; i++) {
			System.out.println();
			for (int j = 0; j < n; j++) {
				System.out.print(paths[i][j] + " ");
			}
		}
		System.out.println();

		return paths[m - 1][n - 1];
	}

}
