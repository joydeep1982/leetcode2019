/**
 * 
 * https://leetcode.com/problems/combination-sum/
 * 
 */
package com.practice.ds.array;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

	public static void main(String[] args) {
		CombinationSum o = new CombinationSum();
		List<List<Integer>> results = o.combinationSum(new int[] { 2, 3, 6, 7 }, 7);

		for (List<Integer> list : results) {
			System.out.println(list);
		}
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		combination(candidates, new boolean[candidates.length], new int[candidates.length], 0, target, results);
		return results;
	}

	public void combination(int[] candidates, boolean[] used, int[] collect, int pos, int target,
			List<List<Integer>> results) {
		int sum = 0;
		List<Integer> r = new ArrayList<Integer>();
		for (int i : collect) {
			if (i > 0) {
				r.add(i);
			}
			System.out.print(i + " + ");
			sum += i;
		}
		System.out.println(sum);
		if (sum == target) {
			System.out.println("adding");
			results.add(r);
			return;
		}
		if (sum > target) {
			return;
		}
		if (pos >= candidates.length - 1) {
			return;
		}

		for (int i = 0; i < candidates.length; i++) {
			if (!used[i]) {
				collect[pos] = candidates[i];
				used[i] = true;
				combination(candidates, used, collect, pos + 1, target, results);
				used[i] = false;
				collect[pos] = 0;
			}
		}
	}
}
