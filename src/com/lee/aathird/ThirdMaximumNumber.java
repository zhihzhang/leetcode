package com.lee.aathird;

public class ThirdMaximumNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int thirdMax(int[] nums) {
		long f = Long.MIN_VALUE;
		long s = Long.MIN_VALUE;
		long t = Long.MIN_VALUE;
		for (int n : nums) {
			if (n > f) {
                t = s;
                s = f;
				f = n;
			} else if (n > s && n!=f) {
				t = s;
				s = n;
			} else if (n > t && n!=f && n!=s) {
				t = n;
			}
		}
		if (t > Long.MIN_VALUE) {
			return (int)t;
		}
		return (int)f;
	}

}
