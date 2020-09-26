package com.lee.aathird;

public class ReplaceElements {

	public static void main(String[] args) {
		ReplaceElements obj = new ReplaceElements();
		System.out.println(obj.replaceElements(new int[]{17,18,5,4,6,1}));

	}

	public int[] replaceElements(int[] arr) {
		int l = arr.length - 1;
		int max = -1;
		for (int i = l - 1; i >= 0; i--) {
			int n = arr[i];
			arr[i] = max;
			max = Math.max(n, max);
		}
		return arr;
	}

}
