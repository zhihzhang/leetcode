package com.lee.againt;

import java.util.HashMap;
import java.util.Map;

public class FractiontoRecurringDecimal {

	public static void main(String[] args) {
		System.out.println((10) / (-20));
		StringBuilder sb = new StringBuilder("123456");
		sb.insert(3, '(');
		sb.append(')');
		System.out.println(sb.toString());

		FractiontoRecurringDecimal obj = new FractiontoRecurringDecimal();
		System.out.println(obj.fractionToDecimal(5, 3));
		System.out.println(obj.fractionToDecimal(5, 2));
		System.out.println(obj.fractionToDecimal(5, 5));
		System.out.println(obj.fractionToDecimal(-50, 8));
		System.out.println(obj.fractionToDecimal(8, -50));
	}

	// Input: numerator = 5, denominator = 3
	// Output: "1.(6)"

	public String fractionToDecimal(int numerator, int denominator) {
		StringBuilder sb = new StringBuilder();
		long a = numerator;
		long b = denominator;
		if (a * b < 0) {
			sb.append("-");
		}
		a = Math.abs(a);
		b = Math.abs(b);

		long num = a / b;

		sb.append(num);
		num = a % b;
		if (num == 0) {
			return sb.toString();
		}
		sb.append(".");
		Map<Long, Integer> indexMap = new HashMap<>();

		while (num != 0) {
			num = num * 10;
			if (indexMap.containsKey(num)) {
				int t = indexMap.get(num);
				sb.insert(t, '(');
				sb.append(')');
				break;
			}
			indexMap.put(num, sb.length());
			long t = num / b;
			sb.append(t);
			num = num % denominator;
			if (num == 0) {
				break;
			}
		}

		return sb.toString();
	}

}
