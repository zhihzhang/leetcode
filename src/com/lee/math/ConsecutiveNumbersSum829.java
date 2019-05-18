package com.lee.math;

public class ConsecutiveNumbersSum829 {

	public static void main(String[] args) {
		ConsecutiveNumbersSum829 obj = new ConsecutiveNumbersSum829();
		System.out.println(obj.consecutiveNumbersSum(3));
	}

	public int consecutiveNumbersSum(int N) {
		int h = N / 2;
		int count = 1;
		for (int i = 2; i <= h + 1; i++) {
			int w = ((0 + i - 1) * i) / 2;
			int t = N - w;
			int l = t / i;
			if (l == 0 || l * i != t) {
				continue;
			}
			if (l + i <= N) {
				count++;
			}
		}
		return count;
	}

}
