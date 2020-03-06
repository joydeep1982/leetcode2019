/**
 * 
 * https://leetcode.com/problems/insert-interval/
 * 
 */
package com.practice.ds.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class InsertInterval {
	
	public static void main(String[] args) {
		InsertInterval o = new InsertInterval();
		o.insert(new int[][] {
			{1, 2},
			{3, 5},
			{6, 7},
			{8, 10},
			{12, 16}
		}, new int[] {-1, 80});
	}
	
	public int[][] insert(int[][] intervals, int[] newInterval) {
		
		Integer[][] _intervals = new Integer[intervals.length][2];
		for (int i = 0; i < intervals.length; i++) {
			_intervals[i][0] = intervals[i][0];
			_intervals[i][1] = intervals[i][1];
		}
		
		Integer[] _newInterval = new Integer[2];
		_newInterval[0] = newInterval[0];
		_newInterval[1] = newInterval[1];
		
		return insertBoxed(_intervals, _newInterval);
	}
	
	public int[][] insertBoxed(Integer[][] intervals, Integer[] newInterval) {
        Map<Integer, Integer[]> lookup = new HashMap<Integer, Integer[]>();
        for (int i = 0; i < intervals.length; i++) {
            for (int j = intervals[i][0]; j <= intervals[i][1]; j++) {
                lookup.put(j, intervals[i]);
            }
        }
        
        Integer skipStart = newInterval[0]; 
        if (lookup.containsKey(skipStart)) {
            skipStart = Math.min(skipStart, lookup.get(skipStart)[0]);
        }
        
        Integer skipEnd = newInterval[1];
        if (lookup.containsKey(skipEnd)) {
            skipEnd = Math.max(skipEnd, lookup.get(skipEnd)[1]);
        } 
        
        
        Integer[] newVal = new Integer[] {skipStart, skipEnd};
        for (Integer i = skipStart; i <= skipEnd; i++) {
            lookup.remove(i);
            lookup.put(i, newVal);
        }
        
        Set<Integer[]> unique = new HashSet<Integer[]>();
        for (Integer key : lookup.keySet()) {
            unique.add(lookup.get(key));
        }
        
        PriorityQueue<Integer[]> pq = new PriorityQueue<Integer[]>((a,b) -> a[0] - b[0]);
        for (Integer[] e : unique) {
        	pq.add(e);
        }
        
        int[][] result = new int[pq.size()][2];
        int counter = 0;
        while(!pq.isEmpty()) {
        	Integer[] ele = pq.poll();
        	System.out.println(ele[0] + ", " + ele[1]);
        	result[counter][0] = ele[0];
        	result[counter][1] = ele[1];
        	counter++;
        }
        
        return result;
    }

}
