/**
 * 
 * https://leetcode.com/problems/water-and-jug-problem/
 * 
 */
package com.practice.ds.recursive;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WaterAndJugProblem {

	public static void main(String[] args) {
		WaterAndJugProblem wj = new WaterAndJugProblem();
		boolean ret = wj.canMeasureWater(3, 5, 4);
		System.out.println(ret);
	}

	public boolean canMeasureWater(int x, int y, int z) {

		Set<Pair> processed = new HashSet<Pair>();
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(0, 0));

		while (!q.isEmpty()) {

			Pair jugs = q.poll();
			if (processed.contains(jugs)) {
				continue;
			}
			processed.add(jugs);

			if (jugs.jug1 == z || jugs.jug2 == z || jugs.jug1 + jugs.jug2 == z) {
				return true;
			}

			// option1: empty jug1
			q.add(new Pair(0, jugs.jug2));

			// option2: empty jug2
			q.add(new Pair(jugs.jug1, 0));

			// option3: fill jug1
			q.add(new Pair(x, jugs.jug2));

			// option4: fill jug2
			q.add(new Pair(jugs.jug1, y));

			// option5: fill jug1 from jug2
			int maxForJug1 = Math.min(x - jugs.jug1, jugs.jug2);
			q.add(new Pair(jugs.jug1 + maxForJug1, jugs.jug2 - maxForJug1));
			
			// option 6: fill jug2 from jug1
			int maxForJug2 = Math.min(y - jugs.jug2, jugs.jug1);
			q.add(new Pair(jugs.jug1 - maxForJug2, jugs.jug2 + maxForJug2));
		}

		return false;
	}
}

class Pair {

	int jug1;

	int jug2;

	public Pair(int jug1, int jug2) {
		this.jug1 = jug1;
		this.jug2 = jug2;
	}

	@Override
	public String toString() {
		return "jug1: " + jug1 + " jug2: " + jug2;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Pair)) {
			return false;
		}
		Pair that = (Pair) obj;
		return this.jug1 == that.jug1 && this.jug2 == that.jug2;
	}
	
	@Override
	public int hashCode() {
		return this.jug1 * this.jug2;
	}
}
