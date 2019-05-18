package com.lee.array;

public class ShortestSubarray581 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShortestSubarray581 obj = new ShortestSubarray581();
//		System.out.println(obj.findUnsortedSubarray(new int[] { 2, 6, 4, 8, 10, 9, 15 }));
//		 System.out.println(obj.findUnsortedSubarray(new int[]{2, 1}));
//		 System.out.println(obj.findUnsortedSubarray(new int[]{1,2,3,4}));
//		 System.out.println(obj.findUnsortedSubarray(new int[]{5,4,3,2,1}));
//		 System.out.println(obj.findUnsortedSubarray(new int[]{1,3,2,2,2}));
//		 System.out.println(obj.findUnsortedSubarray(new int[]{1,3,2,3,3}));
		 System.out.println(obj.findUnsortedSubarray(new int[]{2,3,3,2,4}));
	}

	public int findUnsortedSubarray(int[] nums) {
		int i, j;
		for (i = 1; i < nums.length; i++) {
			if (nums[i] < nums[i - 1]) {
				break;
			}
		}
		if (i == nums.length) {
			return 0;
		}
		i--;

		for (j = nums.length - 2; j >= 0; j--) {
			if (nums[j] > nums[j + 1]) {
				break;
			}
		}
		j++;
		System.out.println("pre....i=" + i + "    j=" + j);
		if (i > j) {
			int t = i;
			i = j;
			j = t;
		}
		System.out.println("post...i=" + i + "    j=" + j);
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int k = i; k <= j; k++) {
			if (nums[k] < min) {
				min = nums[k];
			}
			if (nums[k] > max) {
				max = nums[k];
			}
		}
		System.out.println("...min=" + min + "  max=" + max);
		int l = -1;
		int r = nums.length - 1;
		for (int k = 0; k <= i; k++) {
			if (nums[k] > min) {
				l = k;
				break;
			}
		}
		for (int k = j; k < nums.length; k++) {
			if (nums[k] >= max) {
				r = k - 1;
				break;
			}
		}

		System.out.println("...l=" + l + "  r=" + r);
		return r - l + 1;
	}

}
