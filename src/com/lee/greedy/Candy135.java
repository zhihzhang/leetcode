package com.lee.greedy;

public class Candy135 {

	public static void main(String[] args) {
		Candy135 obj = new Candy135();
//		int[] ratings = {1,2,2};
//		int[] ratings = {1,0,2};
		int[] ratings = {1,3,2,2,1};
		int w = obj.candy(ratings);
		System.out.println(w);
	}
	
	public int candy(int[] ratings) {
		if (ratings == null || ratings.length == 0) {
			return 0;
		} else if (ratings.length == 1) {
			return 1;
		}
		int min = 1;
		int total = 1;

		int[] value = new int[ratings.length];
		value[0]=1;
		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i] > ratings[i - 1]) {
				value[i] = value[i - 1] + 1;
			} else {
				value[i] = value[i - 1] - 1;
				min = Math.min(min, value[i]);
			}
			System.out.println("value " + value[i]);
			total = total + value[i];
		}
		if (min > 0) {
			return total;
		} else {
			return total + (1 - min) * ratings.length;
		}
	}

}
