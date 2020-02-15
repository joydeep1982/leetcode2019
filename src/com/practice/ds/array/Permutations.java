/**
 * 
 * https://leetcode.com/problems/permutations/
 * 
 */
package com.practice.ds.array;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

	public static void main(String[] args) {
		Permutations p = new Permutations();
		List<List<Integer>> results = p.permute(new int[] { 1, 2, 3 });
		for (List<Integer> list : results) {
			System.out.println(list);
		}
	}

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		process(nums, new int[nums.length], new boolean[nums.length], 0, results);
		return results;
	}

	public void process(int[] nums, int[] collect, boolean[] used, int pos, List<List<Integer>> results) {
		if (pos == nums.length) {
			List<Integer> r = new ArrayList<Integer>();
			for (int c : collect) {
				r.add(c);
			}

			results.add(r);
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (!used[i]) {
				collect[pos] = nums[i];
				used[i] = true;
				process(nums, collect, used, pos + 1, results);
				used[i] = false;
			}
		}
	}
}
