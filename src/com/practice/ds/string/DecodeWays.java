/**
 * 
 * https://leetcode.com/problems/decode-ways/
 * 
 */
package com.practice.ds.string;

import java.util.HashMap;
import java.util.Map;

public class DecodeWays {
	
	public static void main(String[] args) {
		DecodeWays obj = new DecodeWays();
		int ways = obj.numDecodings("2219", new HashMap<String, Integer>());
		System.out.println("Ways: " + ways);
	}

	public int numDecodings(String s, Map<String, Integer> memory) {
		if (s.length() == 0) {
			memory.put(s,1);
			return 1;
		}
        else if (s.length() == 1) {
            char c = s.charAt(0);
            Integer i = Integer.parseInt(String.valueOf(c));
            int ret = i == 0 ? 0 : 1;
            memory.put(s, ret);
            return ret;
        }
		char c = s.charAt(0);
		int count = 0;
		Integer i = Integer.parseInt(String.valueOf(c));
		if (i == 0) {
			memory.put(s, 0);
			return 0;
		}
		if (i >= 1 && i <= 2) {
			c = s.charAt(1);
			Integer j = Integer.parseInt(String.valueOf(c));
			Integer num = i * 10 + j;
			if (num <= 26) {
				String str = s.substring(2);
				count = numDecodings(str, memory);
				memory.put(s, count);
			}
		}
		int ret = count + numDecodings(s.substring(1), memory);
		memory.put(s, ret);
		return ret;
	}
}
