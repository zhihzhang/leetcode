package com.lee.string;

import java.util.HashSet;
import java.util.Set;

public class NextClosestTime681 {

	public static void main(String[] args) {
		NextClosestTime681 obj = new NextClosestTime681();
		System.out.println(obj.nextClosestTime("22:37"));
	}
	
    public String nextClosestTime(String time) {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<time.length();i++){
        	char c = time.charAt(i);
        	if(c!=':'){
        		set.add(c-'0');
        	}
        }
        
        String[] array = time.split(":");
        int h = Integer.valueOf(array[0]);
		int m = Integer.valueOf(array[1]);
		int v = h * 60 + m;
		
		int max = 24 * 60;
		int a = h;
		int b = m;
		Set<Integer> hours = pop(set);
		Set<Integer> mins = pop(set);
		
		for (Integer i : hours) {
			if (i >= 24) {
				continue;
			}
			for (Integer j : mins) {
				if (j >= 60) {
					continue;
				}
				int w = i * 60 + j;
				int d = w - v;
				if (d == 0) {
					continue;
				}
				if (d < 0) {
					d = d + 24 * 60;
				}
				if (max > d) {
					max = d;
					a = i;
					b = j;
				}
			}
		}
		
		String x = a + "";
		if(x.length()==1){
			x = "0" + x;
		}
		
		String y = b + "";
		if(y.length()==1){
			y = "0" + y;
		}
       
        return x + ":" + y;
    }
    
	public Set<Integer> pop(Set<Integer> set) {
		Set<Integer> res = new HashSet<>();
		for (Integer i : set) {
			for (Integer j : set) {
				int t = i * 10 + j;
				if (t < 60) {
					res.add(t);
				}
			}
		}
		return res;
	}

}
