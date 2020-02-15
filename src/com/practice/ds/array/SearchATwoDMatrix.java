/**
 * 
 * https://leetcode.com/problems/search-a-2d-matrix/
 * 
 */
package com.practice.ds.array;

public class SearchATwoDMatrix {

	public static void main(String[] args) {
		SearchATwoDMatrix obj = new SearchATwoDMatrix();

		int[][] data = new int[][] {{1,3,5,7},{	10,11,16,20},{23,30,34,50}};
//		int[][] data = new int[][] { { 1 } };
		boolean r = obj.searchMatrix(data, 3);
		System.out.println(r);
	}

	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix.length == 0)
			return false;
		int col = matrix[0].length;
		if (col == 0)
			return false;
		int low = 0;
		int high = matrix.length;

		int scan = -1;

		while (low < high) {
			int mid = low + (high - low) / 2;
			if (matrix[mid][0] == target) {
				return true;
			} else if (target > matrix[mid][0]) {
				if (target <= matrix[mid][col - 1]) {
					scan = mid;
					break;
				}
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		if (scan == -1)
			return false;

		low = 0;
		high = matrix[scan].length;

		while (low < high) {
			int mid = low + (high - low) / 2;
			if (matrix[scan][mid] == target) {
				return true;
			} else if (target > matrix[scan][mid]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		return false;
	}

}
