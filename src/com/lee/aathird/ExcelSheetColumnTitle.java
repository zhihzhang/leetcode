package com.lee.aathird;

import java.util.HashMap;
import java.util.Map;

public class ExcelSheetColumnTitle {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		map.put("123", "456");
		System.out.println(map.get("123"));
		System.out.println(map.get("1234"));
		System.out.println(map.get(null));

	}

	public String convertToTitle(int n) {
		StringBuilder sb = new StringBuilder();
		while (n > 0) {
			int t = n % 26;
			char c = (char) ('A' + t - 1);
			sb.append(c);
			n = n / 26;
		}
		return sb.reverse().toString();
	}

}
