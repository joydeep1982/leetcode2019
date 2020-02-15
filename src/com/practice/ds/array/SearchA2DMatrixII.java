/**
 * 
 * https://leetcode.com/problems/search-a-2d-matrix-ii/
 * 
 */
package com.practice.ds.array;

public class SearchA2DMatrixII {

	public static void main(String[] args) {
		SearchA2DMatrixII obj = new SearchA2DMatrixII();
		int[][] data = new int[][] {
			{1,   4,  7, 11, 15}, 
			{2,   5,  8, 12, 19},
			{3,   6,  9, 16, 22}, 
			{10, 13, 14, 17, 24}, 
			{18, 21, 23, 26, 30}};
			
			data = new int[][] {{1,2,3,4,5}};
			
			boolean isPresent = obj.searchMatrix(data, 1);
			System.out.println(isPresent);
	}
	
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix.length == 0) return false;
        if (matrix[0].length == 0) return false;
        
		int[] jBounds = new int[2];
		jBounds[0] = Integer.MAX_VALUE;
		jBounds[1] = Integer.MIN_VALUE;

		findBoundsJ(matrix, target, 0, matrix[0].length - 1, jBounds);

		if (jBounds[0] == Integer.MAX_VALUE) {
			return false;
		}

		System.out.println(jBounds[0] + ", " + jBounds[1]);

		int[] iBounds = new int[2];
		iBounds[0] = Integer.MAX_VALUE;
		iBounds[1] = Integer.MIN_VALUE;

		findBoundsI(matrix, target, 0, matrix.length - 1, iBounds);

		if (iBounds[0] == Integer.MAX_VALUE) {
			return false;
		}

		System.out.println(iBounds[0] + ", " + iBounds[1]);

		for (int i = iBounds[0]; i <= iBounds[1]; i++) {
			for (int j = jBounds[0]; j <= jBounds[1]; j++) {
				System.out.println("searching [" + i + ", " + j + "]");
				if (target == matrix[i][j]) {
					return true;
				}
			}
		}

		return false;
	}

	public void findBoundsI(int[][] matrix, int target, int top, int bottom, int bounds[]) {
		if (top <= bottom) {
			int row = matrix[0].length;

			int mid = top + (bottom - top) / 2;

			if (target >= matrix[mid][0] && target <= matrix[mid][row - 1]) {
				bounds[0] = Math.min(bounds[0], mid);
				bounds[1] = Math.max(bounds[1], mid);
				
				if (mid - 1 >= top && target >= matrix[mid - 1][0] && target <= matrix[mid - 1][row - 1]) {
					findBoundsI(matrix, target, top, mid - 1, bounds);
				}
				if (mid + 1 <= bottom && target >= matrix[mid + 1][0] && target <= matrix[mid + 1][row - 1]) {
					findBoundsI(matrix, target, mid + 1, bottom, bounds);
				}
			}
			else if (target >= matrix[mid][0]) {
				findBoundsI(matrix, target, mid + 1, bottom, bounds);
			}
			else {
				findBoundsI(matrix, target, top, mid - 1, bounds);
			}
		}
	}
	
	public void findBoundsJ(int[][] matrix, int target, int left, int right, int bounds[]) {
		if (left <= right) {
			int col = matrix.length;

			int mid = left + (right - left) / 2;

			if (target >= matrix[0][mid] && target <= matrix[col - 1][mid]) {
				bounds[0] = Math.min(bounds[0], mid);
				bounds[1] = Math.max(bounds[1], mid);
				
				if (mid - 1 >= left && target >= matrix[0][mid - 1] && target <= matrix[col - 1][mid - 1]) {
					findBoundsJ(matrix, target, left, mid - 1, bounds);
				}
				
				if (mid + 1 <= right && target >= matrix[0][mid + 1] && target <= matrix[col - 1][mid + 1]) {
					findBoundsJ(matrix, target, mid + 1, right, bounds);
				}
			}
			else if (target > matrix[0][mid]) {
				findBoundsJ(matrix, target, mid + 1, right, bounds);
			}
			else {
				findBoundsJ(matrix, target, left, mid - 1, bounds);
			}
		}
	}
}
