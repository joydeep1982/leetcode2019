/**
 * 
 * https://leetcode.com/problems/video-stitching/
 * 
 */
package com.practice.ds.array;

import com.practice.ds.miscell.Utils;

public class VideoStitching {

	public static void main(String[] args) {
		VideoStitching vs = new VideoStitching();
//		int count = vs.videoStitching(new int[][] { { 0, 2 }, { 4, 6 }, { 8, 10 }, { 1, 9 }, { 1, 5 }, { 5, 9 } }, 10);
		int count = vs.videoStitching(new int[][] { { 0, 4 }, { 2, 8 } }, 5);
		System.out.println(count);
	}

	public int videoStitching(int[][] clips, int T) {
		//Arrays.parallelSort(clips, (a, b) -> a[0] - b[0]);
		boolean[][] matrix = new boolean[clips.length][T + 1];

		for (int i = 0; i < clips.length; i++) {
			for (int j = clips[i][0]; j <= Math.min(T, clips[i][1]); j++) {
				matrix[i][j] = true;
			}
		}

		Utils.print(matrix, "T", ".");

		int left = T;
		int prevleft = Integer.MIN_VALUE;
		int count = 0;
		
		while (left > 0) {
			count++;
			prevleft = left;
			for (int i = clips.length - 1; i >= 0; i--) {
				if (matrix[i][prevleft]) {
					left = Math.min(left, greedy(matrix, i, prevleft));
				}
			}
			if (left == prevleft) {
				return -1;
			}
		}

		return count;
	}

	private int greedy(boolean[][] matrix, int row, int col) {
		boolean flag = false;
		for (int i = col; i >= 0; i--) {
			flag = true;
			if (!matrix[row][i]) {
				return i + 1;
			}
		}
		return flag ? 0 : -1;
	}
}
