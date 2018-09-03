package com.lee.twopointers;

import java.util.Arrays;

public class NumRescueBoats881 {

	public static void main(String[] args) {
		NumRescueBoats881 obj = new NumRescueBoats881();
		int r = obj.numRescueBoats(new int[]{1,1,1,1,1}, 10);
		System.out.println(r);
	}

	// greedy
	public int numRescueBoats(int[] people, int limit) {
		Arrays.sort(people);
		int i = 0;
		int j = people.length - 1;

		int count = 0;
		while (i <= j) {
			count++;
			if (people[i] + people[j] <= limit) {
				i++;
			}
			j--;
		}
		return count;
	}

}
