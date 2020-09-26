package com.lee.aathird;

import java.util.HashSet;
import java.util.Set;

public class SingleNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int singleNumber(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int n : nums) {
			if (set.contains(n)) {
				set.remove(n);
			} else {
				set.add(n);
			}
		}
		return set.iterator().next();
	}

}
