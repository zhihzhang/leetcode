package com.lee.math;

public class Factorial172 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(trailingZeroes(4));
	}
	
    public static int trailingZeroes(int n) {
    	return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }

}
