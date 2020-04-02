package com.lee.again;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MinimumAreaRectangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int minAreaRect(int[][] points) {
        Map<Integer, List<Integer>> rowMap = new TreeMap<>();
        for(int[] p : points){
        	if(!rowMap.containsKey(p[0])){
        		rowMap.put(p[0], new ArrayList<Integer>());
        	}
        	rowMap.get(p[0]).add(p[1]);
        }
        
        for(int k : rowMap.keySet()){
        	List<Integer> a = rowMap.get(k);
        	Collections.sort(a);
        }
        
        Map<Integer, List<Integer>> clMap = new TreeMap<>();
        for(int[] p : points){
        	if(!clMap.containsKey(p[1])){
        		clMap.put(p[1], new ArrayList<Integer>());
        	}
        	clMap.get(p[1]).add(p[0]);
        }
        
        for(int k : clMap.keySet()){
        	List<Integer> a = clMap.get(k);
        	Collections.sort(a);
        }
        
        int min = Integer.MAX_VALUE;
        for(int k : rowMap.keySet()){
        	List<Integer> a = rowMap.get(k);
        }
        
        return 0;
    }

}
