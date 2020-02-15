/**
 * 
 * https://leetcode.com/problems/spiral-matrix/
 * 
 */
package com.practice.ds.array;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	public static void main(String[] args) {
		SpiralMatrix obj = new SpiralMatrix();

//		int[][] matrix = new int[][] { { 3 }, { 4 } };
		int[][] matrix = new int[][] { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 },
				{ 16, 17, 18, 19, 20 }, { 21, 22, 23, 24, 25 } };
		obj.spiralOrder(matrix);
	}

	public List<Integer> spiralOrder(int[][] matrix) {
		if (matrix.length == 0) return new ArrayList<Integer>();
		int i = 0;
		int j = 0;
		int incrI = 0;
		int incrJ = 1;

		int iMaxBound = matrix.length - 1;
		int jMaxBound = matrix[0].length - 1;

		int iMinBound = 0;
		int jMinBound = 0;

		int row = matrix.length;
		int col = matrix[0].length;

		int maxCount = row * col;
		int count = 0;
		List<Integer> result = new ArrayList<Integer>();

		while (count < maxCount) {
			System.out.println("i: " + i + " bound: (" + iMinBound + ", " + iMaxBound + "), j: " + j + " bound: ("
					+ jMinBound + ", " + jMaxBound + ")");
//			System.out.println(" value: " + matrix[i][j]);
			result.add(matrix[i][j]);

			if (j >= jMaxBound && incrJ == 1) {
				jMaxBound--;
				iMinBound++;
				incrJ = 0;
				incrI = 1;
			} else if (i == iMaxBound && incrI == 1) {
				iMaxBound--;
				incrJ = -1;
				incrI = 0;
			} else if (j == jMinBound && incrJ == -1) {
				jMinBound++;
				incrJ = 0;
				incrI = -1;
			} else if (i == iMinBound && incrI == -1) {
				incrI = 0;
				incrJ = 1;
			}

			i = i + incrI;
			j = j + incrJ;

			count++;
		}

		return result;
	}

}
