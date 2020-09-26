package com.lee.aathird;

public class KthLargestElementArray {

	public static void main(String[] args) {
		KthLargestElementArray obj = new KthLargestElementArray();
		int[] a = new int[] { 7, 6, 5, 4, 3, 2, 1 };
		int k = 2;
		System.out.println(obj.findKthLargest(a, k));

	}

	public int findKthLargest(int[] a, int k) {
		return quickSelect(a, 0, a.length - 1, a.length - k);
	}

	public int quickSelect(int[] a, int l, int r, int k) {
		int index = pivot(a, l, r);
		if (index == k) {
			return a[index];
		} else if (index > k) {
			return quickSelect(a, l, index - 1, k);
		} else {
			return quickSelect(a, index + 1, r, k);
		}
	}

	public int pivot(int[] a, int l, int r) {
		int v = a[r];
		int t = l;
		for (int i = l; i < r; i++) {
			if (a[i] <= v) {
				swap(a, i, t++);
			}
		}
		swap(a, t, r);
		return t;
	}

	public void swap(int[] a, int l, int r) {
		if (l == r) {
			return;
		}
		int t = a[l];
		a[l] = a[r];
		a[r] = t;
	}

	// int partition(int[] a, int left, int right) {
	// int pivotValue = a[right];
	// int storeIndex = left;
	// for (int i = left; i < right; i++) {
	// if (a[i] < pivotValue) {
	// swap(a, storeIndex, i);
	// storeIndex++;
	// }
	// }
	// swap(a, storeIndex, right);
	// return storeIndex;
	// }

}
