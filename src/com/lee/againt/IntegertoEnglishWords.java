package com.lee.againt;

import java.util.ArrayList;
import java.util.List;

public class IntegertoEnglishWords {

	public static void main(String[] args) {
		IntegertoEnglishWords obj = new IntegertoEnglishWords();
		System.out.println(obj.numberToWords(2147483647));
		System.out.println(obj.numberToWords(34));
		System.out.println(obj.numberToWords(7604700));
		System.out.println(obj.numberToWords(1000000));
	}

	// 2,147,483,647
	private final String[] LESS_THAN_20 = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
			"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
			"Nineteen" };
	private final String[] TENS = { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty",
			"Ninety" };
	private final String[] THOUSANDS = { "", "Thousand", "Million", "Billion" };

	public String numberToWords(int num) {
		if (num == 0) {
			return "Zero";
		}
		List<String> list = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		int t = num;
		while (t > 0) {
			sb.append(t % 10);
			t = t / 10;
			if (sb.length() == 3) {
				list.add(sb.reverse().toString());
				sb = new StringBuilder();
			}
		}
		if (sb.length() > 0) {
			while (sb.length() < 3) {
				sb.append("0");
			}
			list.add(sb.reverse().toString());
		}
		for (int i = list.size() - 1; i < 4; i++) {
			list.add(null);
		}
		sb = new StringBuilder();
		for (int i = 3; i >= 0; i--) {
			sb.append(getStr(list.get(i), i));
		}
		String s = sb.toString().trim();
		
		return s;
	}

	public String getStr(String s, int type) {
		if (s == null || s.equals("000")) {
			return "";
		}
		return getNum(s) + " " + THOUSANDS[type] + " ";
	}

	public String getNum(String s) {
		StringBuilder sb = new StringBuilder();
		int a = s.charAt(0) - '0';
		int b = s.charAt(1) - '0';
		int c = s.charAt(2) - '0';
		if (a > 0) {
			sb.append(LESS_THAN_20[a]).append(" Hundred");
		}
		if (b == 0) {
			sb.append(" ").append(LESS_THAN_20[c]);
		} else if (b == 1) {
			int t = b * 10 + c;
			sb.append(" ").append(LESS_THAN_20[t]);
		} else {
			sb.append(" ").append(TENS[b]);
			sb.append(" ").append(LESS_THAN_20[c]);
		}
		return sb.toString().trim();
	}

}
