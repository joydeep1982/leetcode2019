package com.practice.ds.heap;

import java.util.NoSuchElementException;

public class BinaryHeap {

	private int[] heap;

	private int maxsize;

	private int size;

	private int counter;

	public BinaryHeap(int size) {
		this.maxsize = size;
		this.heap = new int[size];
		this.size = 0;
		counter = 0;
	}

	public BinaryHeap(int[] data) {
		this(data.length);
		this.heap = data;
		this.size = data.length;
		this.heapify();
	}

	private void heapify() {
		int[] data = this.heap;
		for (int i = this.size / 2; i >= 0; i--) {
			this.checkAndRectifyPos(data, i);
		}
	}

	private void checkAndRectifyPos(int[] data, int pos) {
		System.out.println("Fixing pos: " + pos);
		int leftChild = 2 * pos + 1;
		int rightChild = leftChild + 1;
		int val = data[pos];
		int maxPos = pos;

		counter++;

		if (leftChild < size && data[leftChild] > val) {
			maxPos = leftChild;
			val = data[leftChild];
		}
		if (rightChild < size && data[rightChild] > val) {
			maxPos = rightChild;
		}

		if (pos != maxPos) {
			int temp = data[pos];
			data[pos] = data[maxPos];
			data[maxPos] = temp;
			checkAndRectifyPos(data, maxPos);
		}
	}

	private void insert(int data) {
		int pos = size;
		if (size == maxsize - 1) {
			int min = 0;
			for (int i = size / 2; i < size - 1; i++) {
				if (heap[i] < heap[min]) {
					min = i;
				}
			}
			pos = min;
		} else {
			this.size++;
		}
		heap[pos] = data;
		for (int i = pos; i >= 0; i--) {
			checkAndRectifyPos(this.heap, i);
		}
	}

	private int remove() {
		if (this.size == 0)
			throw new NoSuchElementException("There is no item in the heap");
		int val = this.heap[0];
		this.heap[0] = this.heap[size - 1];
		this.size--;
		checkAndRectifyPos(this.heap, 0);
		return val;
	}

	public void print() {
		System.out.println();
		for (int i = 0; i < size; i++) {
			System.out.print(heap[i] + ", ");
		}
		System.out.println();
		System.out.println("counter: " + counter);
	}

	public static void main(String[] args) {
		int[] data = { 10, 6, 7, 5, 15, 17, 12 };
		BinaryHeap heap = new BinaryHeap(data);
		heap.print();
		int val = heap.remove();
		System.out.println("value from the heap: " + val);
		heap.print();

		heap.insert(200);
		heap.print();

		heap.insert(300);
		heap.print();

		heap.insert(400);
		heap.print();
	}
}
