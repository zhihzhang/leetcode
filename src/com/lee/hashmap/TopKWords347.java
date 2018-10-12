package com.lee.hashmap;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TopKWords347 {

	public static void main(String[] args) {
		TopKWords347 obj = new TopKWords347();

	}

	  public List<Integer> topKFrequent(int[] nums, int k) {
	        Map<Integer, Integer> map = new HashMap<>();
	        for(int n: nums){
	            map.put(n, map.getOrDefault(n,0)+1);
	        }
	        
	        // corner case: if there is only one number in nums, we need the bucket has index 1.
	        List<Integer>[] bucket = new List[nums.length+1];
	        for(int n:map.keySet()){
	            int freq = map.get(n);
	            if(bucket[freq]==null)
	                bucket[freq] = new LinkedList<>();
	            bucket[freq].add(n);
	        }
	        
	        List<Integer> res = new LinkedList<>();
	        for(int i=bucket.length-1; i>0 && k>0; --i){
	            if(bucket[i]!=null){
	                List<Integer> list = bucket[i]; 
	                res.addAll(list);
	                k-= list.size();
	            }
	        }
	        
	        return res;
	    }

}
