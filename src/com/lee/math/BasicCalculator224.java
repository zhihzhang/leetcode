package com.lee.math;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class BasicCalculator224 {

	public static void main(String[] args) {
		BasicCalculator224 obj = new BasicCalculator224();
		Map a = new HashMap();
		String x = (String)a.get("123");
		System.out.println(x);
	}

	public int calculate(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		LinkedList<Character> list = new LinkedList<>();
		for (int i = s.length() - 1; i >= 0; i--) {
			list.add(s.charAt(i));
		}
		
		while(!list.isEmpty()){
			
		}
		return 0;
	}

}
