package com.lee.bitwise;

//https://leetcode.com/problems/single-number-ii/discuss/43295/Detailed-explanation-and-generalization-of-the-bitwise-operation-method-for-single-numbers
public class SingleNumber137 {

	public static void main(String[] args) {
		int a = 1;
		int b = 0;
		int w = ~a;
		System.out.println(w);

		int[] nums = { 7, 2, 7, 2, 7, 2, 1 };
		singleNumber(nums);
	}

	public static int singleNumber(int[] nums) {

		// we need to implement a tree-time counter(base 3) that if a bit
		// appears three time ,it will be zero.
		// #curent income ouput
		// # ab c/c ab/ab
		// # 00 1/0 01/00
		// # 01 1/0 10/01
		// # 10 1/0 00/10
		// a=~abc+a~b~c;
		// b=~a~bc+~ab~c;
		int a = 0;
		int b = 0;
		for (int c : nums) {
			int ta = (~a & b & c) | (a & ~b & ~c);
			b = (~a & ~b & c) | (~a & b & ~c);
			a = ta;
			System.out.println("....c:" + c + "   a:" + a + "  b:" + b);
		}
		// we need find the number that is 01,10 => 1, 00 => 0.
		int result = a | b;
		System.out.println(result);
		return a | b;

	}

}
