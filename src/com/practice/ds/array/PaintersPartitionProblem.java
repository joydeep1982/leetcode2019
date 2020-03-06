package com.practice.ds.array;

public class PaintersPartitionProblem {

	public static void main(String[] args) {
		PaintersPartitionProblem ppp = new PaintersPartitionProblem();
		int val = ppp.partition(new int[] {10, 20, 30, 40}, 2);
//		int val = ppp.partition(new int[] {10, 20, 60, 50, 30, 40}, 3);
		System.out.println(val);
	}
	
	public int partition(int[] arr, int k) {
		return partition(arr, 0, k);
	}
	
	public int sum(int[] arr, int from, int to) {
		int sum = 0;
		for (int i = from; i < to; i++) {
			sum += arr[i];
		}
		return sum;
	}
	
	public int partition(int[] arr, int start, int painter) {
	
		if (painter == 1) {
			return sum(arr, start, arr.length);
		}
		if (start == arr.length - 1) {
			return arr[start];
		}
		
		int sum = 0;
		int diff = Integer.MAX_VALUE;
		int best = Integer.MIN_VALUE;
		for (int i = start; i < arr.length; i++) {
			sum += arr[i];
			int part = partition(arr, i + 1, painter - 1);
			System.out.println("sum: " + sum + " part: " + part);
			int newDiff = Math.abs(sum - part);
			System.out.println("diff: " + diff + " newDiff " + newDiff);
			if (newDiff < diff) {
				diff = newDiff;
				best = Math.max(sum, part);
				System.out.println("diff: " + diff);
				System.out.println("best: " + best);
				System.out.println();
			}
		}
	
		
		return best;
	}
	   
	    
}
