/**
 * 
 * https://leetcode.com/problems/lfu-cache/
 * 
 */
package com.practice.ds;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LFUCache {
	
private PriorityQueue<CacheData> cacheFrequency;
    
    private Map<Integer, CacheData> cache;
    
    private Integer capacity;
    
    private Integer currentSize;

    public LFUCache(int capacity) {
        cacheFrequency = new PriorityQueue<CacheData>((a,b) -> a.accessCount - b.accessCount);
        cache = new HashMap<Integer, CacheData>();
        this.capacity = capacity;
        this.currentSize = 0;
    }
    
    public int get(int key) {
    	if (capacity == 0) {
    		return -1;
    	}
        if (cache.containsKey(key)) {
            CacheData data = cache.get(key);
            cacheFrequency.remove(data);
            data.accessCount++;
            cacheFrequency.add(data);
            return data.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
    	
    	if (capacity == 0) {
    		return;
    	}
    	
    	if (cache.containsKey(key)) {
    		System.out.println("Updating cache for the key " + key);
    		CacheData data = cache.get(key);
    		cacheFrequency.remove(data);
    		data.val = value;
    		cacheFrequency.add(data);
    		cache.put(key, data);
    		return;
    	}
    	
    	System.out.println("Putting into cache [key: " + key + ", value: " + value + "]");
    	
        currentSize++;
        if (currentSize > capacity) {
            if (!cacheFrequency.isEmpty()) {
                CacheData rem = cacheFrequency.poll();
                System.out.println("Evicting from cache " + rem.key + " accesed: " +  rem.accessCount + " times");
                System.out.println("Next element " + cacheFrequency.peek().key + " accessed: " + cacheFrequency.peek().accessCount + " times");
                cache.remove(rem.key);
            }
            currentSize = capacity;
        }
        CacheData data = new CacheData(key, value);
        cacheFrequency.add(data);
        cache.put(key, data);
    }
    
    public static void main(String[] args) {
    	LFUCache cache = new LFUCache(3);
//		cache.put(1, 1);
//		cache.put(2, 2);
//		System.out.println(cache.get(1));
//		cache.put(3, 3);
//		System.out.println(cache.get(2));
//		System.out.println(cache.get(3));
//		cache.put(4, 4);
//		System.out.println(cache.get(1));
//		System.out.println(cache.get(3));
//		System.out.println(cache.get(4));
    	
//    	cache.put(3, 1);
//    	cache.put(2, 1);
//    	cache.put(2, 2);
//    	cache.put(4, 4);
//    	System.out.println(cache.get(2));
    	
    	cache.put(1, 1);
    	cache.put(2, 2);
    	cache.put(3, 3);
    	cache.put(4, 4);
    	System.out.println("from cache: (4) " + cache.get(4));
    	System.out.println("from cache: (3) " + cache.get(3));
    	System.out.println("from cache: (2) " + cache.get(2));
    	System.out.println("from cache: (1) " + cache.get(1));
    	cache.put(5, 5);
    	System.out.println("from cache: (1) " + cache.get(1));
    	System.out.println("from cache: (2) " + cache.get(2));
    	System.out.println("from cache: (3) " + cache.get(3));
    	System.out.println("from cache: (4) " + cache.get(4));
    	System.out.println("from cache: (5) " + cache.get(5));
    	
    	
	}
}

class CacheData {
    int key;
    int val;
    int accessCount;
    public CacheData(int key, int val) {
        this.key = key;
        this.val = val;
        this.accessCount = 0;
    }
}
