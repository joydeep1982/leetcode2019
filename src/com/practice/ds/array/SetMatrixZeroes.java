/**
 * 
 * https://leetcode.com/problems/set-matrix-zeroes/
 * 
 */
package com.practice.ds.array;

import com.practice.ds.miscell.Utils;

public class SetMatrixZeroes {

	public static void main(String[] args) {
		SetMatrixZeroes obj = new SetMatrixZeroes();
		int[][] data = new int[][] { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
		data = new int[][] { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
		data = new int[][] { { 1, 1, 1 }, { 0, 1, 2 } };
//		data = new int[][] {{0,0,0,5},{4,3,1,4},{0,1,1,4},{1,2,1,3},{0,0,1,1}};

		Utils.print(data);

		obj.setZeroes(data);

		Utils.print(data);
	}

	public void setZeroes(int[][] matrix) {

		int rows = matrix.length;
		int cols = matrix[0].length;

		boolean isDelFirstRow = false;
		boolean isDelFirstCol = false;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (matrix[i][j] == 0) {
					isDelFirstRow = isDelFirstRow || i == 0;
					isDelFirstCol = isDelFirstCol || j == 0;
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}

		for (int i = 1; i < rows; i++) {
			if (matrix[i][0] == 0) {
				for (int j = 0; j < cols; j++) {
					matrix[i][j] = 0;
				}
			}
		}

		for (int j = 1; j < cols; j++) {
			if (matrix[0][j] == 0) {
				for (int i = 0; i < rows; i++) {
					matrix[i][j] = 0;
				}
			}
		}

		if (isDelFirstRow) {
			for (int i = 0; i < cols; i++) {
				matrix[0][i] = 0;
			}
		}

		if (isDelFirstCol) {
			for (int i = 0; i < rows; i++) {
				matrix[i][0] = 0;
			}
		}
	}

}
