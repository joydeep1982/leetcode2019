/**
 * 
 * https://leetcode.com/problems/subsets/
 * 
 */
package com.practice.ds.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Subsets {

	public static void main(String[] args) {
		Subsets obj = new Subsets();
		List<List<Integer>> results = obj.subsets(new int[] { 1, 2, 3, 4, 5, 6 });
		for (List<Integer> list : results) {
			System.out.println(list);
		}
	}

	public List<List<Integer>> subsets(int[] nums) {
		Set<List<Integer>> results = new HashSet<List<Integer>>();
		allsubsets(nums, 0, nums.length, results);
		results.add(getAsList(nums, 0, 0, -1));
		return new ArrayList<>(results);
	}

	public void allsubsets(int[] nums, int left, int right, Set<List<Integer>> results) {
		if (nums == null || nums.length == 0)
			return;
		if (left >= right)
			return;
		results.add(getAsList(nums, left, right, -1));
		for (int i = left; i < right; i++) {
			results.add(getAsList(nums, left, right, i));
		}
		allsubsets(nums, left + 1, right, results);
		allsubsets(nums, left, right - 1, results);
	}

	public List<Integer> getAsList(int[] nums, int left, int right, int skip) {
		List<Integer> results = new ArrayList<Integer>();
		for (int i = left; i < right; i++) {
			if (i == skip)
				continue;
			results.add(nums[i]);
		}

		return results;
	}
}
