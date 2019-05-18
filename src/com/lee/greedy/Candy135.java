package com.lee.greedy;

public class Candy135 {

	public static void main(String[] args) {
		Candy135 obj = new Candy135();
		 int[] ratings = {1,2,2};
//		int[] ratings = { 1, 0, 2 };
//		 int[] ratings = {1,2,87,87,87,2,1};
		int w = obj.candy(ratings);
		 System.out.println(w);
	}

	public int candy(int[] ratings) {
		if (ratings == null || ratings.length == 0) {
			return 0;
		} else if (ratings.length == 1) {
			return 1;
		}
		int total = 0;

		int[] left = new int[ratings.length];
		left[0] = 1;
		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i] > ratings[i - 1]) {
				left[i] = left[i - 1] + 1;
			} else {
				left[i] = left[i - 1] - 1;
				if (left[i] < 1) {
					left[i] = 1;
				}
				if(left[i] > 1){
					left[i]=1;
				}
			}
		}

		int[] right = new int[ratings.length];
		right[ratings.length - 1] = 1;
		for (int i = ratings.length - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1]) {
				right[i] = right[i + 1] + 1;
			} else {
				right[i] = right[i + 1] - 1;
				if (right[i] < 1) {
					right[i] = 1;
				}
				if(right[i] > 1){
					right[i]=1;
				}
			}
		}

		for (int i = 0; i < ratings.length; i++) {
			int t = Math.max(left[i], right[i]);
			total = total + t;
		}
		return total;
	}

	public int candy123(int[] ratings) {
		if (ratings == null || ratings.length == 0) {
			return 0;
		} else if (ratings.length == 1) {
			return 1;
		}
		int min = 1;
		int total = 1;

		int[] value = new int[ratings.length];
		value[0] = 1;
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
