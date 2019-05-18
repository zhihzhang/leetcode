package com.lee.again;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {
	public static void main(String[] args) {

	}

	public int numUniqueEmails(String[] emails) {
		Set<String> mailSet = new HashSet<>();

		for (String mail : emails) {
			String[] m = mail.split("@");
			StringBuilder sb = new StringBuilder();
			for (char c : m[0].toCharArray()) {
				if (c == '.') {
					continue;
				} else if (c == '+') {
					break;
				} else {
					sb.append(c);
				}
			}
			sb.append("@");
			sb.append(m[1]);
			mailSet.add(sb.toString());
		}
		return mailSet.size();

	}
}
