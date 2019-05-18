package com.lee.again;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

public class HitCounter {

	public static void main(String[] args) {
		HitCounter counter = new HitCounter();

		// hit at timestamp 1.
		counter.hit(1);

		// hit at timestamp 2.
		counter.hit(1);

		// hit at timestamp 3.
		counter.hit(1);

		// get hits at timestamp 4, should return 3.
		System.out.println(counter.getHits(4));

		// hit at timestamp 300.
		counter.hit(300);
		counter.hit(300);
		System.out.println(counter.getHits(300));
		counter.hit(300);

		// get hits at timestamp 300, should return 4.
		System.out.println(counter.getHits(300));

		// get hits at timestamp 301, should return 3.
		System.out.println(counter.getHits(301));
		System.out.println(counter.getHits(301));
		System.out.println(counter.getHits(301));

	}
	
	Map<Integer,Integer> map = new HashMap<>();
	LinkedList<Integer> list = new LinkedList<>();
	int count = 0;
	
    /** Initialize your data structure here. */
    public HitCounter() {
        
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
	public void hit(int timestamp) {
		map.put(timestamp, map.getOrDefault(timestamp, 0) + 1);
		list.offer(timestamp);
		count++;
		calc(timestamp);
	}

    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
		calc(timestamp);
		return count;
    }
    
    public void calc(int timestamp){
		int t = timestamp - 300;
		while (!list.isEmpty()) {
			if (list.peekFirst() <= t) {
				int key = list.pollFirst();
				count = count - map.getOrDefault(key, 0);
				map.remove(key);
			} else {
				break;
			}
		}
    }

}
