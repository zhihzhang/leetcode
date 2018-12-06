package com.lee.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NextClosestTime {

	public static void main(String[] args) {
		NextClosestTime obj = new NextClosestTime();
		System.out.println(Integer.valueOf("01"));
		
		
		System.out.println(obj.nextClosestTime("11:11"));
	}
	
	int mh = 0;
	int mm = 0;
	
	int min = Integer.MAX_VALUE;
	
    public String nextClosestTime(String time) {
        // write your code here
    	List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < time.length(); i++) {
			char c = time.charAt(i);
			if (c == ':') {
				continue;
			}
			list.add(c - '0');
		}
		
		Set<Integer> set = new HashSet<Integer>();
		for(int i : list){
			set.add(i);
		}
		if (set.size() == 1) {
			int t = list.get(0);
			return t + "" + t + ":" + t + t;
		}
    	
    	
    	String[] arr = time.split(":");
    	int h = Integer.valueOf(arr[0]);
    	int m = Integer.valueOf(arr[1]);
    
		List<Integer> next = new ArrayList<Integer>();
		int num = h * 60 + m;
		bt(list, h, m, next, num);
		
		StringBuilder sb = new StringBuilder();
		if(mh<10){
			sb.append("0" + mh + ":");
		}else{
			sb.append(mh + ":");
		}
		
		if(mm<10){
			sb.append("0" + mm);
		}else{
			sb.append("" + mm);
		}
    	
    	return sb.toString();
    }
    
    public void bt(List<Integer> list, int h, int m, List<Integer> next, int num){
		if (next.size() == 4) {
			int a = next.get(0) * 10 + next.get(1);
			int b = next.get(2) * 10 + next.get(3);
			
			if (a == h && b == m) {
				return;
			}

			if (a > 23 || b > 59) {
				return;
			}

			int n = a * 60 + b;
			if (num > n) {
				n = n + 24 * 60;
			}
			if (min > n - num) {
				min = n - num;
				mh = a;
				mm = b;
			}
			return;
		}
    	for(int v : list){
    		next.add(v);
    		bt(list, h, m, next, num);
    		next.remove(next.size()-1);
    	}
    }

}
