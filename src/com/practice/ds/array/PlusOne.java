/**
 * 
 * https://leetcode.com/problems/plus-one/
 * 
 */
package com.practice.ds.array;

public class PlusOne {

	public static void main(String[] args) {
		PlusOne obj = new PlusOne();
		int[] result = obj.plusOne(new int[] { 9 });
		System.out.println();
		for (int r :result) {
			System.out.print(r + ", ");
		}
	}

	public int[] plusOne(int[] digits) {
		if (digits.length == 0) return digits;
		int size = digits.length + 1;
		for (int d : digits) {
			if (d != 9) {
				size--;
				break;
			}
		}
		
		int[] results = new int[size];
		if (size > digits.length) {
			results[0] = 1;
		}
		
		int i = digits.length - 1;
		boolean carry = digits[i] + 1 > 9;
		results[size - 1] = (digits[i] + 1) % 10;
		int index = size - 2;
		i = digits.length - 2;
		while ( i >= 0) {
			int num = (carry ? 1 : 0) + digits[i];
			carry = num > 9;
			if (num > 9) {
				num = num%10;
			}
			results[index--] = num;
			i--;
		}
		
		return results;
	}
}
