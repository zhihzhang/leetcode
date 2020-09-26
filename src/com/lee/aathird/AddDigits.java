package com.lee.aathird;

public class AddDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int addDigits(int num) {
		while (num / 10 > 0) {
			num = getSum(num);
		}
		return num;
	}

	public int getSum(int num) {
		int sum = 0;
		while (num > 0) {
			sum += num % 10;
			num = num / 10;
		}
		return sum;
	}

}
