package com.lee.again;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class FindtheCelebrity {

	public static void main(String[] args) {
		FindtheCelebrity obj = new FindtheCelebrity();

	}

	public int findCelebrity(int n) {
		LinkedList<Integer> list = new LinkedList<>();
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i != j && knows(i, j)) {
					list.add(i);
				}
			}
		}
		return -1;
	}

	boolean knows(int a, int b) {
		return false;
	}

}
