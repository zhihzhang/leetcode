package com.lee.bitwise;

public class BitwiseAnd {

	public static void main(String[] args) {
//		System.out.println("Result A....." + rangeBitwiseAnd(9, 17));
//		System.out.println("Result B....." + rangeBitwiseAndTTT(9, 17));
//		System.out.println(Integer.MAX_VALUE);
//		System.out.println(Integer.MIN_VALUE);
		
		int a = 5;
		System.out.println(Integer.toBinaryString(a));
		
		System.out.println(Integer.toBinaryString(-a));
		a &= -a;
		System.out.println(a);
	}

	public static int rangeBitwiseAnd(int m, int n) {
		if (m == 0) {
			return 0;
		}
		int moveFactor = 1;
		while (m != n) {
			m >>= 1;
			n >>= 1;
			moveFactor <<= 1;

			System.out.println("...m:" + m + "   n:" + n + "    moveFactor:" + moveFactor);
		}
		return m * moveFactor;
	}
	
	public static int rangeBitwiseAndTTT(int m, int n) {
		if (m == 0) {
			return 0;
		}
		int result = m;
		for (int i = m+1; i <= n; i++) {
			result = result & i;
			System.out.println(result);
		}
		return result;
	}


}
