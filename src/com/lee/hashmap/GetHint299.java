package com.lee.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetHint299 {

	public static void main(String[] args) {
		GetHint299 obj = new GetHint299();
		System.out.println(obj.getHint("1123", "0111"));
	}

	public String getHint(String secret, String guess) {
		StringBuffer sb = new StringBuffer();

		int a = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();

		List<Character> list = new ArrayList<Character>();
		for (int i = 0; i < secret.length(); i++) {
			if (secret.charAt(i) == guess.charAt(i)) {
				a++;
			} else {
				map.put(secret.charAt(i), map.getOrDefault(secret.charAt(i), 0) + 1);
				list.add(guess.charAt(i));
			}
		}

		int b = 0;
		for (char c : list) {
			if (map.get(c) != null && map.get(c) > 0) {
				map.put(c, map.get(c) - 1);
				b++;
			}
		}
		
		sb.append(a).append("A").append(b).append("B");

		return sb.toString();

	}

}
