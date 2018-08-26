package com.lee.quickselect;

public class KthElement {

	public static void main(String[] args) {
		KthElement obj = new KthElement();
		int[] a = { 9, 6, 3, 5, 4, 7, 1, 8, 2 };
		int x = obj.findKthLargest(a, 7);
		System.out.println(x);
	}

	public static void print(int x) {
		System.out.println(x);
	}

	public int findKthLargest(int[] a, int k) {
		return quickSelect(a, 0, a.length - 1, k - 1);
//		return quickSelect(a, 0, a.length - 1, a.length - k);
	}

	int partition(int[] a, int left, int right) {
		int pivotValue = a[right];
		int storeIndex = left;
		for (int i = left; i < right; i++) {
			if (a[i] < pivotValue) {
				swap(a, storeIndex, i);
				storeIndex++;
			}
		}
		swap(a, storeIndex, right);
		return storeIndex;

	}

	int quickSelect(int[] a, int left, int right, int k) {
		int index = partition(a, left, right);
		
		if (index == k) {
			return a[index];
		} else if (index > k) {
			return quickSelect(a, left, index - 1, k);
		} else {
			return quickSelect(a, index + 1, right, k);
		}
	}

	void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

}
