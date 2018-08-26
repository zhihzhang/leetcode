package com.lee.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DifferentWays241 {

	public static void main(String[] args) {
		DifferentWays241 obj = new DifferentWays241();

		String s = "";
		List<Integer> list = null;
		
		s="2*3-4*5";
		list = obj.diffWaysToCompute(s);
		System.out.println(list.toString());
		
		s = "2-1-1";
		list = obj.diffWaysToCompute(s);
		System.out.println(list.toString());
	}

	private Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();

	public List<Integer> diffWaysToCompute(String input) {
		if (map.containsKey(input)) {
			return map.get(input);
		}
		List<Integer> list = new ArrayList<Integer>();
		if (!input.contains("+") && !input.contains("-") && !input.contains("*")) {
			list.add(Integer.valueOf(input));
			return list;
		}
		for (int i = 0; i < input.length(); i++) {
			char a = input.charAt(i);
			if (a == '+') {
				List<Integer> head = this.diffWaysToCompute(input.substring(0, i));
				List<Integer> tail = this.diffWaysToCompute(input.substring(i + 1, input.length()));
				for (int hv : head) {
					for (int tv : tail) {
						int t = hv + tv;
						list.add(t);
					}
				}
			} else if (a == '-') {
				List<Integer> head = this.diffWaysToCompute(input.substring(0, i));
				List<Integer> tail = this.diffWaysToCompute(input.substring(i + 1, input.length()));
				for (int hv : head) {
					for (int tv : tail) {
						int t = hv - tv;
						list.add(t);
					}
				}
			} else if (a == '*') {
				List<Integer> head = this.diffWaysToCompute(input.substring(0, i));
				List<Integer> tail = this.diffWaysToCompute(input.substring(i + 1, input.length()));
				for (int hv : head) {
					for (int tv : tail) {
						int t = hv * tv;
						list.add(t);
					}
				}
			}
		}
		return list;
	}

}
