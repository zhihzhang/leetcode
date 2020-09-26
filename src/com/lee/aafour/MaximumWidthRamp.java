package com.lee.aafour;

import java.util.HashSet;
import java.util.Set;

public class MaximumWidthRamp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
//	Input: [6,0,8,2,1,5] Output: 4
//	Input: [9,8,1,0,1,9,4,0,4,1] Output: 7
	public int maxWidthRamp(int[] A) {
		int max = 0;
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < A.length; i++) {
			if(set.contains(A[i])){
				continue;
			}
			set.add(A[i]);
			for (int j = A.length - 1; j > i; j--) {
				if (A[j] >= A[i]) {
					max = Math.max(max, j - i);
					break;
				}
				if (j - i < max) {
					break;
				}
			}
		}
		return max;
	}

}
