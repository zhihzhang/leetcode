package com.lee.againt;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BullsandCows {

	public static void main(String[] args) {
		BullsandCows obj = new BullsandCows();
		String s = obj.getHint("1123", "0111");
		System.out.println(s);
	}

	public String getHint(String secret, String guess) {
		char[] array = secret.toCharArray();
		Map<Character, Integer> map = new HashMap<>();
		for (char c : array) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		char[] t = guess.toCharArray();
		int a = 0;
		int b = 0;
		for (int i = 0; i < t.length; i++) {
			if (array[i] == t[i]) {
				a++;
				map.put(t[i], map.get(t[i]) - 1);
			}
		}

		for (int i = 0; i < t.length; i++) {
			if (array[i] != t[i] && map.getOrDefault(t[i], 0) > 0) {
				b++;
				map.put(t[i], map.get(t[i]) - 1);
			}
		}
		return a + "A" + b + "B";
	}

}
