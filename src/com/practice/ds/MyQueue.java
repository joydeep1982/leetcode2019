package com.practice.ds;

import java.util.LinkedList;
import java.util.Queue;

public class MyQueue {

	private Queue<Integer> q;

    /** Initialize your data structure here. */
    public MyQueue() {
        q = new LinkedList<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        int size = q.size();
        this.q.add(x);
        for (int i = 0; i < size; i++) {
            int val = this.q.poll();
            this.q.add(val);
        }
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return q.poll();
    }
    
    /** Get the front element. */
    public int peek() {
        return this.q.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return this.q.isEmpty();
    }
}
