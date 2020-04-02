package com.lee.againt;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CompareVersion {

	public static void main(String[] args) {
//		String x = "12.23.23.23";
//		String[] array = x.split("123");
		CompareVersion obj = new CompareVersion();
		int x = obj.compareVersion("1", "0");
		System.out.println(x);
	}
	
	public int compareVersion(String version1, String version2) {
		String[] a = version1.split("\\.");
		String[] b = version2.split("\\.");
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
		Queue<String> aq = new LinkedList<String>();
		Queue<String> bq = new LinkedList<String>();
		for(String s:a){
			aq.offer(s);
		}
		for(String s:b){
			bq.offer(s);
		}
		while(!aq.isEmpty() && !bq.isEmpty()){
			String s1 = aq.poll();
			String s2 = bq.poll();
			Long l1 = Long.valueOf(s1);
			Long l2 = Long.valueOf(s2);
			System.out.println("..." + l1 + "..." + l2);
			if (l1 < l2) {
				return -1;
			} else if (l1 > l2) {
				return 1;
			}
		}
		while(!aq.isEmpty()){
			String s = aq.poll();
			Long l = Long.valueOf(s);
			if(l>0){
				return 1;
			}
		}
		while(!bq.isEmpty()){
			String s = bq.poll();
			Long l = Long.valueOf(s);
			if(l>0){
				return -1;
			}
		}
		return 0;
	}

}
