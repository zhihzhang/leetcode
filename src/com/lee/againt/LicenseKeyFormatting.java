package com.lee.againt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LicenseKeyFormatting {

	public static void main(String[] args) {
		LicenseKeyFormatting obj = new LicenseKeyFormatting();
		System.out.println(obj.licenseKeyFormatting("5F3Z-2e-9-w", 4));
	}

	public String licenseKeyFormatting(String S, int K) {
		List<Character> list = new ArrayList<>();
		for (char c : S.toCharArray()) {
			if (c == '-') {
				continue;
			}
			if (c >= 'a' && c <= 'z') {
				list.add(Character.toUpperCase(c));
			} else {
				list.add(c);
			}
		}
		Collections.reverse(list);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i));
			if ((i + 1) % K == 0 && i != list.size() - 1) {
				sb.append("-");
			}
		}
		return sb.reverse().toString();
	}

}
