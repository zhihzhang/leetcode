package com.lee.againt;

public class LongestTurbulentSubarray {

	public static void main(String[] args) {
		LongestTurbulentSubarray obj = new LongestTurbulentSubarray();
		System.out.println(obj.maxTurbulenceSize(new int[]{9,4,2,10,7,8,8,1,9}));

	}

	//9,4,2,10,7,8,8,1,9
	public int maxTurbulenceSize(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		int max = 1;
		int dpLarge[] = new int[A.length];
		int dpLess[] = new int[A.length];
		dpLarge[0] = 1;
		dpLess[0] = 1;
		for (int i = 1; i < A.length; i++) {
			if (A[i-1] < A[i]) {
				dpLarge[i] = 1;
				dpLess[i] = dpLarge[i - 1] + 1;
				max = Math.max(max, dpLess[i]);
			} else if (A[i-1] > A[i]) {
				dpLess[i] = 1;
				dpLarge[i] = dpLess[i - 1] + 1;
				max = Math.max(max, dpLarge[i]);
			} else {
				dpLarge[i] = 1;
				dpLess[i] = 1;
			}
		}
		return max;
	}

}
