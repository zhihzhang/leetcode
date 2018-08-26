package com.lee.test;

public class TestMain {
	public static void main(String[] args) {
		String s = "1234567890";
		int j = 5;
		String k = s.substring(0, j) + s.substring(j + 1, s.length());
		System.out.println(k);
		

	}

}
