package com.lee.array;

import java.util.Arrays;

public class PlusOne66 {

	public static void main(String[] args) {
		PlusOne66 obj = new PlusOne66();
		int[] r = obj.plusOne(new int[]{8,9,9,9});
		System.out.println(Arrays.toString(r));
	}
	
	public int[] plusOne(int[] digits) {
		if (digits == null || digits.length == 0) {
			return new int[] { 1 };
		}
		int preV = 1;
		for (int i = 1; i <= digits.length; i++) {
			int index = digits.length - i;
			if (digits[index] + preV < 10) {
				digits[index] = digits[index] + 1;
				return digits;
			} else {
				preV = 1;
				digits[index] = 0;
			}
		}
		int[] temp = new int[digits.length+1];
		for (int i = 0; i < digits.length; i++) {
			temp[digits.length - i] = digits[digits.length-1-i];
		}
		temp[0]=1;
		return temp;
	}

}
