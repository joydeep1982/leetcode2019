/**
 * 
 * https://leetcode.com/problems/find-median-from-data-stream/
 * 
 */
package com.practice.ds.heap;

import java.util.PriorityQueue;

public class FindMedianFromDataStream {

	PriorityQueue<Integer> maxHeap;

	PriorityQueue<Integer> minHeap;

	int count;

	/** initialize your data structure here. */
	public FindMedianFromDataStream() {
		maxHeap = new PriorityQueue<Integer>((a, b) -> b - a);
		minHeap = new PriorityQueue<Integer>();
		count = 0;
	}

	public void addNum(int num) {
		//num = Math.abs(num);
		count++;
		if (maxHeap.isEmpty()) {
			maxHeap.add(num);
		}
		else if (minHeap.isEmpty()) {
			minHeap.add(num);
		}
		else if (num > minHeap.peek()) {
			minHeap.add(num);
		}
		else {
			maxHeap.add(num);
		}
		
		if (Math.abs(maxHeap.size() - minHeap.size()) > 1) {
			if (minHeap.size() > maxHeap.size()) {
				maxHeap.add(minHeap.poll());
			}
			else {
				minHeap.add(maxHeap.poll());
			}
		}
		
		System.out.println("max heap: " + maxHeap);
		System.out.println("min heap " + minHeap);
	}

	public double findMedian() {
		if (count % 2 == 0) {
			return ((double) (maxHeap.peek() + minHeap.peek()) / 2);
		} else {
			if (maxHeap.size() > minHeap.size()) {
				return maxHeap.peek();
			}
			return minHeap.peek();
		}
	}

	public static void main(String[] args) {
		FindMedianFromDataStream o = new FindMedianFromDataStream();
//		for (int i = 1; i < 10; i++) {
//			System.out.println("adding " + i + " to heap");
//			o.addNum(i);
//			System.out.println("mean: " + o.findMedian());
//			System.out.println();
//		}
		o.addNum(-1);
		System.out.println("mean: " + o.findMedian());
		System.out.println();
		o.addNum(-2);
		System.out.println("mean: " + o.findMedian());
		System.out.println();
		o.addNum(-3);
		System.out.println("mean: " + o.findMedian());
		System.out.println();
		o.addNum(-4);
		System.out.println("mean: " + o.findMedian());
		System.out.println();
		o.addNum(-5);
		System.out.println("mean: " + o.findMedian());
		System.out.println();
	}

}
