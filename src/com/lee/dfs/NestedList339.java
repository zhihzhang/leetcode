package com.lee.dfs;

import java.util.List;

public class NestedList339 {

	public static void main(String[] args) {
		NestedList339 obj = new NestedList339();

	}

	public int depthSum(List<NestedInteger> nestedList) {
		int sum = 0;
		for (NestedInteger ni : nestedList) {
			if (ni.isInteger()) {
				sum = sum + ni.getInteger();
			} else {
				for (NestedInteger n : ni.getList()) {
					sum = sum + calc(n, 2);
				}
			}
		}
		return sum;
	}

	public int calc(NestedInteger ni, int d) {
		int sum = 0;
		if (ni.isInteger()) {
			return ni.getInteger() * d;
		} else {
			for (NestedInteger n : ni.getList()) {
				sum = sum + calc(n, d + 1);
			}
			return sum;
		}
	}

}
