/**
 * 
 * https://leetcode.com/problems/russian-doll-envelopes/
 * 
 */
package com.practice.ds.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class RussianDollEnvelopes {
	
	public static void main(String[] args) {
		RussianDollEnvelopes o = new RussianDollEnvelopes();
		long start = System.currentTimeMillis();
		int max = o.maxEnvelopes(new int[][] {
			{5, 4},
			{6, 4},
			{6, 7},
			{2, 3}
		});
		long end = System.currentTimeMillis();
		System.out.println(max);
		System.out.println((end-start) + " mills");
	}

	private int maxEnvelopes(int[][] envelopes) {
		Arrays.sort(envelopes, (a, b)-> a[0]==b[0]? b[1]-a[1]: a[0]-b[0]);
		TreeSet<Integer> sortedSet = new TreeSet<>();
		for (int[] env : envelopes) {
            Integer ceiling = sortedSet.ceiling(env[1]);            
            if (ceiling != null && ceiling.intValue() != env[1]) sortedSet.remove(ceiling);
            sortedSet.add(env[1]);
        }        
        return sortedSet.size();
	}

	public int maxEnvelopes1(int[][] envelopes) {
		Map<Integer, List<Envelope>> heightMap = new HashMap<Integer, List<Envelope>>();
		Map<Integer, List<Envelope>> widthMap = new HashMap<Integer, List<Envelope>>();

		int minWidth = Integer.MAX_VALUE;
		int minHeight = Integer.MAX_VALUE;
		int maxWidth = Integer.MIN_VALUE;
		int maxHeight = Integer.MIN_VALUE;

		Set<Envelope> allEnvelopes = new HashSet<Envelope>();

		for (int[] env : envelopes) {
			int w = env[0];
			int h = env[1];

			minWidth = Math.min(minWidth, w);
			maxWidth = Math.max(maxWidth, w);

			minHeight = Math.min(minHeight, h);
			maxHeight = Math.max(maxHeight, h);

			Envelope obj = new Envelope(w, h);

			allEnvelopes.add(obj);

			List<Envelope> list = widthMap.getOrDefault(w, new ArrayList<Envelope>());
			list.add(obj);
			widthMap.put(w, list);

			list = heightMap.getOrDefault(h, new ArrayList<Envelope>());
			list.add(obj);
			heightMap.put(h, list);
		}

		int max = Integer.MIN_VALUE;
		for (Envelope e : allEnvelopes) {
			max = Math.max(max,
					maxEnvelopes(e, allEnvelopes, widthMap, heightMap, minWidth, maxWidth, minHeight, maxHeight, new HashSet<Envelope>()));
			break;
		}

		return max == Integer.MIN_VALUE ? 0 : max;
	}

	private int maxEnvelopes(Envelope envelope, Set<Envelope> allEnvelopes, Map<Integer, List<Envelope>> widthMap,
			Map<Integer, List<Envelope>> heightMap, int minWidth, int maxWidth, int minHeight, int maxHeight, Set<Envelope> usedEnvelopes) {
		System.out.println("called " + envelope);
		if (envelope.width < minWidth || envelope.width > maxWidth || envelope.height < minHeight
				|| envelope.height > maxHeight) {
			System.out.println("bound hit");
			return 0;
		}
		if (usedEnvelopes.contains(envelope)) {
			System.out.println("already used");
			return 0;
		}
		System.out.println("processing");
		usedEnvelopes.add(envelope);
		int val = 0;
		if (allEnvelopes.contains(envelope)) {
			System.out.println("matched " + envelope);
			val = 1;
		}

		// looking for smaller envelopes
		Envelope smaller = new Envelope(envelope.width - 1, envelope.height - 1);
		int smallVal = maxEnvelopes(smaller, allEnvelopes, widthMap, heightMap, minWidth, maxWidth, minHeight,
				maxHeight, usedEnvelopes);

		// looking for bigger envelopes
		Envelope bigger = new Envelope(envelope.width + 1, envelope.height + 1);
		int bigVal = maxEnvelopes(bigger, allEnvelopes, widthMap, heightMap, minWidth, maxWidth, minHeight, maxHeight, usedEnvelopes);

		usedEnvelopes.remove(envelope);
		
		System.out.println("returning: " + (smallVal + bigVal + val));
		
		return val + smallVal + bigVal;
	}
}

class Envelope {
	int height;
	int width;

	public Envelope(int w, int h) {
		this.width = w;
		this.height = h;
	}

	public boolean equals(Object o) {
		if (o instanceof Envelope) {
			Envelope that = (Envelope) o;
			return this.width == that.width && this.height == that.height;
		}
		return false;
	}

	public int hashCode() {
		return this.width * this.height;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[width " + this.width + " height "  + this.height + "]";
	}
}
