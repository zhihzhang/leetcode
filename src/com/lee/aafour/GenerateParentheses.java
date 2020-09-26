package com.lee.aafour;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	List<String> result = new ArrayList<>();

	public List<String> generateParenthesis(int n) {
		int l = 0;
		int r = 0;
		List<Character> list = new ArrayList<>();
		backtrace(list, l, r, n);
		return result;
	}

	public void backtrace(List<Character> list, int l, int r, int n) {
		if (l == n && r == n) {
			StringBuilder sb = new StringBuilder();
			sb.append(list);
			for(char c:list){
				sb.append(c);
			}
			return;
		}
		if (l == r) {
			list.add('(');
			backtrace(list, l + 1, r, n);
			list.remove(list.size() - 1);
		} else {
			if (l < n) {
				list.add('(');
				backtrace(list, l + 1, r, n);
				list.remove(list.size() - 1);
			}
			list.add(')');
			backtrace(list, l, r + 1, n);
			list.remove(list.size() - 1);
		}
	}

}
