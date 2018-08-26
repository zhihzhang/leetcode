package com.lee.dc;

import java.util.Arrays;

public class Test4 {
	public static void main(String[] args) {
		Test4 obj = new Test4();
		double x = 0;
		int[] nums1 = { 1, 3 };
		int[] nums2 = { 2, 4 };
		x = obj.findMedianSortedArrays(nums1, nums2);
		if (x != 2.5) {
			System.out.println(Arrays.toString(nums1) + "..." + Arrays.toString(nums2));
			System.out.println(x);
		}
		int[] nums3 = { 1, 3 };
		int[] nums4 = { 2 };
		x = obj.findMedianSortedArrays(nums3, nums4);
		if (x != 2) {
			System.out.println(Arrays.toString(nums3) + "..." + Arrays.toString(nums4));
			System.out.println(x);
		}
		int[] nums5 = { 4, 5, 6 };
		int[] nums6 = { 1, 2, 3 };
		x = obj.findMedianSortedArrays(nums5, nums6);
		if (x != 3.5) {
			System.out.println(Arrays.toString(nums5) + "..." + Arrays.toString(nums6));
			System.out.println(x);
		}
		int[] nums7 = { 3 };
		int[] nums8 = { -2, -1 };
		x = obj.findMedianSortedArrays(nums7, nums8);
		if (x != -1) {
			System.out.println(Arrays.toString(nums7) + "..." + Arrays.toString(nums8));
			System.out.println(x);
		}
		int[] nums9 = {};
		int[] nums10 = { 1, 2, 3, 4, 5 };
		x = obj.findMedianSortedArrays(nums9, nums10);
		if (x != 3) {
			System.out.println(Arrays.toString(nums9) + "..." + Arrays.toString(nums10));
			System.out.println(x);
		}
		int[] nums11 = { 2, 3 };
		int[] nums12 = { 1, 5 };
		x = obj.findMedianSortedArrays(nums11, nums12);
		if (x != 2.5) {
			System.out.println(Arrays.toString(nums11) + "..." + Arrays.toString(nums12));
			System.out.println(x);
		}

		int[] nums13 = { 1 };
		int[] nums14 = { 2, 3, 4 };
		x = obj.findMedianSortedArrays(nums13, nums14);
		if (x != 2.5) {
			System.out.println(Arrays.toString(nums13) + "..." + Arrays.toString(nums14));
			System.out.println(x);
		}

		int[] nums15 = { 100000 };
		int[] nums16 = { 100001 };
		x = obj.findMedianSortedArrays(nums15, nums16);
		if (x != 100000.5) {
			System.out.println(Arrays.toString(nums15) + "..." + Arrays.toString(nums16));
			System.out.println(x);
		}

		int[] nums17 = { 1 };
		int[] nums18 = { 2, 3 };
		x = obj.findMedianSortedArrays(nums17, nums18);
		if (x != 2) {
			System.out.println(Arrays.toString(nums17) + "..." + Arrays.toString(nums18));
			System.out.println(x);
		}

		int[] nums19 = { 2 };
		int[] nums20 = { 1, 3, 4 };
		x = obj.findMedianSortedArrays(nums19, nums20);
		if (x != 2.5) {
			System.out.println(Arrays.toString(nums19) + "..." + Arrays.toString(nums20));
			System.out.println(x);
		}

		int[] nums21 = { 1, 4 };
		int[] nums22 = { 2, 3 };
		x = obj.findMedianSortedArrays(nums21, nums22);
		if (x != 2.5) {
			System.out.println(Arrays.toString(nums21) + "..." + Arrays.toString(nums22));
			System.out.println(x);
		}

		int[] nums23 = { 4, 5 };
		int[] nums24 = { 1, 2, 3 };
		x = obj.findMedianSortedArrays(nums23, nums24);
		if (x != 3) {
			System.out.println(Arrays.toString(nums23) + "..." + Arrays.toString(nums24));
			System.out.println(x);
		}
	}

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m = nums1.length;
		int n = nums2.length;

		if (m == 0 && n == 0) {
			return 0;
		}
		if (m == 1 && n == 1) {
			return ((double) nums1[0] + (double) nums2[0]) / 2;
		}

		// m is always the larger one
		if (m < n) {
			int[] tmp = nums1;
			nums1 = nums2;
			nums2 = tmp;
			m = nums1.length;
			n = nums2.length;
		}

		if (n == 0) {
			if (m % 2 == 0) {
				int me = m / 2;
				return ((double) nums1[me - 1] + (double) nums1[me]) / 2;
			} else {
				return nums1[(m - 1) / 2];
			}
		}

		int nh = 0;
		int mh = 0;
		int half = (m + n) / 2 - 1;

		while (mh + nh < half) {
			if (nums1[mh] < nums2[nh]) {
				mh++;
			} else {
				if (nh < n - 1) {
					nh++;
				} else {
					mh++;
				}
			}
		}

		return getM(nums1, nums2, mh, nh);

	}

	public double getM(int[] nums1, int[] nums2, int mh, int nh) {
		System.out.println(
				"...mh " + mh + "...nh " + nh + "...." + Arrays.toString(nums1) + "..." + Arrays.toString(nums2));
		int m = nums1.length;
		int n = nums2.length;

		double a = nums1[mh];
		double b = nums2[nh];

		if (nh == n - 1) {
			if (nums2[nh] > nums1[mh + 1]) {
				b = nums1[mh + 1];
			} else if (mh > 0 && nums2[nh] < nums1[mh - 1]) {
				b = nums1[mh - 1];
			}
		} else {
			if (nums1[mh] > nums2[nh + 1]) {
				a = nums2[nh + 1];
			} else if (mh != m - 1 && nums2[nh] > nums1[mh + 1]) {
				b = nums1[mh + 1];
			}
		}

		if ((m + n) % 2 == 0) {
			return (a + b) / 2;
		} else {
			return Math.max(a, b);
		}
	}
}
