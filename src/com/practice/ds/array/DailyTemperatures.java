/**
 * 
 * https://leetcode.com/problems/daily-temperatures/
 * 
 */
package com.practice.ds.array;

import java.util.Arrays;

import com.practice.ds.miscell.Utils;

public class DailyTemperatures {
	
	public static void main(String[] args) {
		DailyTemperatures obj = new DailyTemperatures();
		int[] reuslts = obj.dailyTemperatures(new  int[] {89,62,70,58,47,47,46,76,100,70});
		Utils.print(reuslts);
	}

	public int[] dailyTemperatures(int[] T) {
        int[] days_to_warm_temp = new int[T.length];
        int[] last_seen = new int[101];
        Arrays.fill(last_seen, Integer.MAX_VALUE);
        
        for (int i =  T.length - 1; i >= 0; i--) {
            days_to_warm_temp[i] = 0;
            for (int j = T[i] + 1; j <= 100; j++) {
                if (last_seen[j] != Integer.MAX_VALUE) {
                	if (days_to_warm_temp[i] != 0) {
                		days_to_warm_temp[i] = Math.min(days_to_warm_temp[i], last_seen[j] - i);
                	} else {
                		days_to_warm_temp[i] = last_seen[j] - i;
                	}
                }
            }
            
            last_seen[T[i]] = i;
        }
        
        return days_to_warm_temp;
    }
}
