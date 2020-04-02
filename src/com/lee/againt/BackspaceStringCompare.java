package com.lee.againt;

import java.util.LinkedList;

import javafx.beans.binding.ListBinding;

public class BackspaceStringCompare {

	public static void main(String[] args) {
//		StringBuilder sb = new StringBuilder();
//		sb.append("abc");
//		System.out.println(sb.toString());
		BackspaceStringCompare obj = new BackspaceStringCompare();
		System.out.println(obj.backspaceCompare("a##c", "#a#c"));

	}

	public boolean backspaceCompare(String S, String T) {
		if (S == null && T == null) {
			return true;
		}
		if (S == null || T == null) {
			return false;
		}
		if (S.length() == 0 && T.length() == 0) {
			return true;
		}
		char[] a = S.toCharArray();
		char[] b = T.toCharArray();
		LinkedList<Character> listA = new LinkedList<>();
		for (int i = 0; i < a.length; i++) {
			if (a[i] == '#' && listA.size() > 0) {
				listA.removeLast();
			} else if (a[i] == '#') {
				continue;
			} else {
				listA.addLast(a[i]);
			}
		}

		LinkedList<Character> listB = new LinkedList<>();
		for (int i = 0; i < b.length; i++) {
			if (b[i] == '#' && listB.size() > 0) {
				listB.removeLast();
			} else if (b[i] == '#') {
				continue;
			} else {
				listB.addLast(b[i]);
			}
		}
		if (listA.size() != listB.size()) {
			return false;
		}
		while (!listA.isEmpty()) {
			if (listA.removeFirst() != listB.removeFirst()) {
				return false;
			}
		}

		return true;

	}

}
