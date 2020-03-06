package com.practice.ds.array;

import java.util.HashMap;
import java.util.Map;

public class LargestRange {

	public static void main(String[] args) {
		int[] result = new LargestRange()
				.largestRange(new int[] { -7, -1, 3, -9, -4, 7, -3, 2, 4, 9, 4, -9, 8, -7, 5, -1, -7 });
		System.out.println(result[0] + ", " + result[1]);
	}

	public int[] largestRange(int[] nums) {
		int[] result = new int[] { -1, -1 };
		if (nums.length == 0) {
			return result;
		}
		Map<Boundary, Integer> boundaries = new HashMap<Boundary, Integer>();
		int max = -1;
		for (int n : nums) {
			
			if (boundaries.containsKey(new Boundary(n, true)) || boundaries.containsKey(new Boundary(n, false))) {
				continue;
			}

			Boundary prev = new Boundary(n - 1, true);
			Boundary next = new Boundary(n + 1, false);

			int start = n;
			int end = n;
			
			System.out.println("processing " + n);
			if (n == 4) {
				System.out.println("debug");
			}

			if (boundaries.containsKey(prev)) {
				start = boundaries.get(prev);
				System.out.println("removing " + prev);
				boundaries.remove(prev);
				Boundary temp = new Boundary(start, false);
				System.out.println("removing " + temp);
				boundaries.remove(temp);
			}

			if (boundaries.containsKey(next)) {
				end = boundaries.get(next);
				System.out.println("removing " + next);
				boundaries.remove(next);
				Boundary temp = new Boundary(end, true);
				System.out.println("removing " + temp);
				boundaries.remove(temp);
			}

			System.out.println(n);
			System.out.println("setting boundary " + start + ", " + end);
			boundaries.put(new Boundary(start, false), end);
			boundaries.put(new Boundary(end, true), start);

			if (end - start > max) {
				max = end - start;
				result[0] = start;
				result[1] = end;
				System.out.println("max: " + (end - start));
			}
		}

		return result;
	}
}

class Boundary {
	int val;
	boolean end;

	public Boundary(int val, boolean end) {
		this.val = val;
		this.end = end;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Boundary) {
			Boundary b = (Boundary) obj;
			return b.val == this.val && this.end == b.end;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return this.val;
	}
	
	@Override
	public String toString() {
		return this.val + ", " + this.end;
	}
}