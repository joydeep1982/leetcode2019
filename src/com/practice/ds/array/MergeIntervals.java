/**
 * 
 * https://leetcode.com/problems/merge-intervals/
 * 
 */
package com.practice.ds.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.practice.ds.miscell.Utils;

public class MergeIntervals {

	public static void main(String[] args) {
		MergeIntervals mi = new MergeIntervals();
		int[][] intervals = new int[][] { { 22, 29 }, { 1, 3 }, { 2, 4 }, { 5, 6 }, { 2, 3 }, { 21, 25 }, { 4, 11 } };
		int[][] data = mi.merge(intervals);
		
		Utils.print(data);
	}

	public int[][] merge(int[][] intervals) {

		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

		int start = intervals[0][0];
		int stop = intervals[0][1];
		
		List<Integer[]> result = new ArrayList<Integer[]>();

		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i][0] <= stop) {
				stop = Math.max(intervals[i][1], stop);
			} else {
				System.out.println("Start: " + start + " Stop: " + stop);
				result.add(new Integer[] {start, stop});
				start = intervals[i][0];
				stop = intervals[i][1];
			}
		}

		System.out.println("Start: " + start + " Stop: " + stop);
		result.add(new Integer[] {start, stop});

		int[][] arr = new int[result.size()][2];
		for (int i = 0; i < result.size(); i++) {
			arr[i][0] = result.get(i)[0];
			arr[i][1] = result.get(i)[1];
		}
		
		return arr;
	}

}
