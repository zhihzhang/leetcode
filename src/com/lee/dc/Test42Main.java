package com.lee.dc;

import java.util.Arrays;

public class Test42Main {
	public static void main(String[] args) {
		double x = 0;
		int[] nums1 = { 1, 3 };
		int[] nums2 = { 2, 4 };
		x = findMedianSortedArrays(nums1, nums2);
		if (x != 2.5) {
			System.out.println(Arrays.toString(nums1) + "..." + Arrays.toString(nums2));
			System.out.println(x);
		}
		int[] nums3 = { 1, 3 };
		int[] nums4 = { 2 };
		x = findMedianSortedArrays(nums3, nums4);
		if (x != 2) {
			System.out.println(Arrays.toString(nums3) + "..." + Arrays.toString(nums4));
			System.out.println(x);
		}
		int[] nums5 = { 4, 5, 6 };
		int[] nums6 = { 1, 2, 3 };
		x = findMedianSortedArrays(nums5, nums6);
		if (x != 3.5) {
			System.out.println(Arrays.toString(nums5) + "..." + Arrays.toString(nums6));
			System.out.println(x);
		}
		int[] nums7 = { 3 };
		int[] nums8 = { -1, -2 };
		x = findMedianSortedArrays(nums7, nums8);
		if (x != -2) {
			System.out.println(Arrays.toString(nums7) + "..." + Arrays.toString(nums8));
			System.out.println(x);
		}
		int[] nums9 = {};
		int[] nums10 = { 1, 2, 3, 4, 5 };
		x = findMedianSortedArrays(nums9, nums10);
		if (x != 3) {
			System.out.println(Arrays.toString(nums9) + "..." + Arrays.toString(nums10));
			System.out.println(x);
		}
		int[] nums11 = { 2, 3 };
		int[] nums12 = { 1, 5 };
		x = findMedianSortedArrays(nums11, nums12);
		if (x != 2.5) {
			System.out.println(Arrays.toString(nums11) + "..." + Arrays.toString(nums12));
			System.out.println(x);
		}
	}

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m = nums1.length;
		int n = nums2.length;

		if (m == 0 && n == 0) {
			return 0;
		}
		if (m == 1 && n == 1) {
			return (nums1[0] + nums2[0]) / 2;
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

		int mh = 0;
		int nh = n - 1;
		mh = (m + n) / 2 - n;
//		if ((m + n) % 2 == 0) {
//			mh = (m + n) / 2 - n;
//		} else {
//			mh = (m + n) / 2 - n;
//		}

		System.out.println("...mh " + mh + "  nh " + nh);

		while (true) {
			if (nh == 0) {
				return getM(nums1, nums2, mh, nh);
			}
			if (nh == n - 1 && nums2[nh] <= nums1[mh + 1]) {
				return getM(nums1, nums2, mh, nh);
			}

			if ((nh == nums2.length - 1 || nums1[mh] <= nums2[nh + 1])
					&& (mh == nums1.length - 1 || nums2[nh] <= nums1[mh + 1])) {
				getM(nums1, nums2, mh, nh);
			} else {
				mh++;
				nh--;
			}

		}
	}

	public static double getM(int[] nums1, int[] nums2, int mh, int nh) {
		int m = nums1.length;
		int n = nums2.length;
		if ((m + n) % 2 == 0) {
			return ((double) nums1[mh] + (double) nums2[nh]) / 2;
		} else {
			return Math.max(nums1[mh], nums2[nh]);
		}
	}
}
