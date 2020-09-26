package com.lee.aafour;

import java.util.HashMap;
import java.util.Map;

public class TreeAncestor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int[] arr;
	Map<Integer,Integer> map = new HashMap<>();

	public TreeAncestor(int n, int[] parent) {
        arr = parent;
    }

	public int getKthAncestor(int node, int k) {
		int v = node;
		while (k > 0) {
			k--;
			v = arr[v];
			if (v == -1) {
				return v;
			}
		}
		return v;
	}

}
