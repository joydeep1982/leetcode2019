/**
 * 
 * https://leetcode.com/problems/cheapest-flights-within-k-stops/
 * 
 */
package com.practice.ds.graph;

public class CheapestFlightsWithinKStops {

	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
		return 0;
	}

	public int dfs(int[][] flights, int src, int dst, int k, boolean[] visited, int depth) {
		if (depth > k)
			return Integer.MAX_VALUE;
		if (visited[src])
			return Integer.MAX_VALUE;
		if (dst == src)
			return 0;

		visited[src] = true;
		return flights[src][2] + dfs(flights, flights[src][1], dst, k, visited, depth++);
	}
}
