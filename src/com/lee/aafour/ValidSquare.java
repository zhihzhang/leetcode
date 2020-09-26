package com.lee.aafour;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ValidSquare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
		int t1 = getLength(p1, p2);
		int t2 = getLength(p1, p3);
		int t3 = getLength(p1, p4);
		int t4 = getLength(p2, p3);
		int t5 = getLength(p2, p4);
		int t6 = getLength(p3, p4);
		if(t1==0 || t2==0 || t3==0 || t4==0 || t5==0||t6==0){
			return false;
		}
		
		Set<Integer> set = new HashSet<>();
		set.add(t1);
		set.add(t2);
		set.add(t3);
		set.add(t4);
		set.add(t5);
		set.add(t6);
		
		if(set.size()==2){
			return true;
		}
		
		return false;
	}
	
	public int getLength(int[] a, int[] b){
		int t1 = (int)Math.pow(a[0]-b[0], 2);
		int t2 = (int)Math.pow(a[1]-b[1], 2);
		return t1+t2;
	}

}