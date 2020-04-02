package com.lee.again;

public class StringCompression {

	public static void main(String[] args) {
		StringCompression obj = new StringCompression();
		String s = "abc";
		System.out.println(obj.compress(s.toCharArray()));
	}

	public int compress(char[] chars) {
		int i = 0;
		StringBuilder sb = new StringBuilder();
		while (i < chars.length) {
			if (i == chars.length - 1) {
				sb.append(chars[i]);
				break;
			}
			int j = i + 1;
			while (j < chars.length && chars[i] == chars[j]) {
				j++;
			}
			int t = j - i;
			sb.append(chars[i]);
			if(t>1){
				sb.append(t + "");
			}
			i = j;
		}

		return sb.length();
	}

}
