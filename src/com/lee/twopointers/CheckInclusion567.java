package com.lee.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckInclusion567 {

	public static void main(String[] args) {
		CheckInclusion567 obj = new CheckInclusion567();
		boolean r = obj.checkInclusion("adc", "dcda");
		System.out.println(r);
	}
	
    public boolean checkInclusion(String s1, String s2) {
		char[] arr = s1.toCharArray();
		List<Character> aList = new ArrayList<Character>();
		for (char c : arr) {
			aList.add(c);
		}
	

		for (int i = 0; i < s2.length() - s1.length() + 1; i++) {
			List<Character> tList = new ArrayList<Character>();
			tList.addAll(aList);
			int j = i;
			while (tList.remove((Character) s2.charAt(j))) {
				if (tList.isEmpty()) {
					return true;
				}
				j++;
			}
		}
		return false;
    }

}
