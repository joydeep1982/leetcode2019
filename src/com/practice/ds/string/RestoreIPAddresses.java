/**
 * 
 * https://leetcode.com/problems/restore-ip-addresses/
 * 
 */
package com.practice.ds.string;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
	
	public static void main(String[] args) {
		RestoreIPAddresses o = new RestoreIPAddresses();
		List<String> ipAddresses = o.restoreIpAddresses("010010");
//		List<String> ipAddresses = o.restoreIpAddresses("25525511135");
		ipAddresses.forEach(System.out::println);
	}
	
	public List<String> restoreIpAddresses(String s) {
        List<String> results = new ArrayList<String>();
        restore(s, 0, "", results, 0);
        return results;
    }
    
    public void restore(String s, int pos, String result, List<String> results, int level) {
    	System.out.println("pos " + pos + " result " + result);
        if (level >  4) {
        	return;
        }
    	if (pos >= s.length()) {
    		if (level == 4) {
    			System.out.println("selected");
    			results.add(result.substring(0, result.length() - 1));
    		}
    	}
    	
    	String num = "";
    	for (int i = pos; i < Math.min(pos + 3, s.length()); i++) {
    		num = num + s.charAt(i);
    		if (!validSegment(num)) {
    			break;
    		}
    		restore(s, i + 1, result + num + ".", results, level + 1);
    		if (num.equals("0")) {
    			break;
    		}
    	}
    }
    
    public boolean validSegment(String s) {
    	return Integer.parseInt(s) <= 255;
    }
}
