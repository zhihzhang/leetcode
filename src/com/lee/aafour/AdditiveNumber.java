package com.lee.aafour;

import java.util.HashMap;
import java.util.Map;

public class AdditiveNumber {

	public static void main(String[] args) {
		AdditiveNumber obj = new AdditiveNumber();
		System.out.println(obj.isAdditiveNumber("1023"));
//		System.out.println(obj.isAdditiveNumber("112358"));
//		System.out.println(obj.isAdditiveNumber("199100199"));

	}

	public boolean isAdditiveNumber(String num) {
		for (int i = 1; i < num.length() - 1 ; i++) {
			String t0 = num.substring(0, i);
			if (i > 1 && t0.startsWith("0")) {
				break;
			}
			for (int j = i + 1; j < num.length(); j++) {
				String t1 = num.substring(i, j);
				if(t1.length()>1 && t1.startsWith("0")){
					break;
				}
				long x = Long.valueOf(t0);
				long y = Long.valueOf(t1);
				boolean f = isTrue(num.substring(j), x, y);
				if (f) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean isTrue(String num, long a, long b) {
		long l = a + b;
		String ls = l + "";
		if(num.equals(ls)){
			return true;
		} else if (num.startsWith(ls)){
			return isTrue(num.substring(ls.length()), b, l);
		}
		return false;
	}

}
