package com.lee.again;

public class Atoi8 {

	public static void main(String[] args) {
		Atoi8 obj = new Atoi8();
		System.out.println(obj.myAtoi("9223372036854775808"));
	}

	public int myAtoi(String str) {
		str = str.trim();
		long num = 0;
		boolean isNegative = false;
		boolean isNum = false;
		for (Character c : str.toCharArray()) {
			if (!isNum) {
				if (c == '-') {
					isNum = true;
					isNegative = true;
				} else if (c == '+') {
					isNum = true;
					continue;
				} else if (c >= '0' && c <= '9') {
					num = (c - '0');
					isNum = true;
				} else {
					break;
				}
			} else {
				if (c >= '0' && c <= '9') {
					num = num * 10 + (c - '0');
				} else {
					break;
				}
			}
			if (isNegative) {
				num = -num;
			}
			if (num > Integer.MAX_VALUE) {
				num = Integer.MAX_VALUE;
				break;
			} else if (num < Integer.MIN_VALUE) {
				num = Integer.MIN_VALUE;
				break;
			}
			if (isNegative) {
				num = -num;
			}
		}
		if (isNegative) {
			num = -num;
		}

		return (int) num;

	}

}
