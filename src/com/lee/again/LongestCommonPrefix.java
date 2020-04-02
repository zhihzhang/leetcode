package com.lee.again;

public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		StringBuilder sb = new StringBuilder();
		String pre = strs[0];
		for (int i = 1; i < strs.length; i++) {
			String s = strs[i];
			if(s.startsWith(pre)){
				continue;
			}
		}
		
		return null;
	}
}
