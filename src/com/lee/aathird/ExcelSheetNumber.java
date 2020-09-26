package com.lee.aathird;

public class ExcelSheetNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int titleToNumber(String s) {
		int sum = 0;
		for (int i = 0; i < s.length(); i++) {
			sum = sum * 26;
			int n = s.charAt(i) - 'A';
			sum += n;
		}
		return sum;
	}

}
