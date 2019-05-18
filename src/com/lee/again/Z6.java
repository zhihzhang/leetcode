package com.lee.again;

import java.util.HashMap;
import java.util.Map;

public class Z6 {

	public static void main(String[] args) {
		Z6 obj = new Z6();
		String s = obj.convert("PAYPALISHIRING", 4);
		System.out.println(s);
	}

	public String convert(String s, int numRows) {
		if (numRows == 1) {
			return s;
		}
		StringBuilder sb = new StringBuilder();
		Map<Integer, StringBuilder> map = new HashMap<>();
		for (int i = 0; i < numRows; i++) {
			map.put(i, new StringBuilder());
		}
		int t = 0;
		int v = 1;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			map.get(t).append(c);
			t = t + v;
			if (t == numRows) {
				v = -1;
				t = numRows - 2;
			} else if (t == -1) {
				v = 1;
				t = 1;
			}
		}
		for (int i = 0; i < numRows; i++) {
			StringBuilder tb = map.get(i);
			sb.append(tb);
		}
		return sb.toString();

	}

}
