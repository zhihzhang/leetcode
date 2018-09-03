package com.lee.hashmap;

import java.util.Arrays;

public class HIndex {

	public static void main(String[] args) {
		HIndex obj = new HIndex();
		int n;
		n = obj.hIndex(new int[]{3,0,6,1,5});
		System.out.println(n);
		
		n = obj.hIndex(new int[]{0, 1});
		System.out.println(n);
	}

	public int hIndex(int[] citations) {
		if (citations == null || citations.length == 0) {
			return 0;
		}
		Arrays.sort(citations);
		int n = 0;
		for (int i = 0; i < citations.length; i++) {
			if (citations.length - i <= citations[i]) {
				n = citations.length - i;
				break;
			}
		}
		return n;
	}

}
