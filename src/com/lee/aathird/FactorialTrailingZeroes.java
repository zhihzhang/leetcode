package com.lee.aathird;

import java.math.BigDecimal;

public class FactorialTrailingZeroes {

	public static void main(String[] args) {
		FactorialTrailingZeroes obj = new FactorialTrailingZeroes();
		System.out.println(obj.check(30));
		System.out.println(obj.check(25));
		System.out.println(obj.check(20));
		System.out.println(obj.check(15));
		System.out.println(obj.check(10));
		System.out.println(obj.check(5));
	}

	public int trailingZeroes(int n) {
		int result = 0;
		while (n > 0) {
			result += n / 5;
			n /= 5;
		}
		return result;
	}

	public BigDecimal check(int n) {
		BigDecimal x = new BigDecimal(1);
		for (int i = 2; i <= n; i++) {
			x = x.multiply(new BigDecimal(i));
		}
		return x;
	}

}
