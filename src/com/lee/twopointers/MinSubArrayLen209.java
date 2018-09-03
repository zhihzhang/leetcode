package com.lee.twopointers;

public class MinSubArrayLen209 {

	public static void main(String[] args) {
		MinSubArrayLen209 obj = new MinSubArrayLen209();
//		int[] nums = { 1, 2, 3, 4, 5 };
//		 int[] nums = { 2, 3, 1, 2, 4, 3 };
		 int[] nums = { 5,1,3,5,10,7,4,9,2,8 };
		int count = obj.minSubArrayLen(15, nums);
		System.out.println(count);
	}
	
	public int minSubArrayLen(int s, int[] a) {
		if (a == null || a.length == 0){
			return 0;
		}

		int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;

		while (j < a.length) {
			sum += a[j++];

			while (sum >= s) {
				min = Math.min(min, j - i);
				sum -= a[i++];
			}
		}

		return min == Integer.MAX_VALUE ? 0 : min;
	}

//	public int minSubArrayLen(int s, int[] nums) {
//		if (nums == null || nums.length == 0) {
//			return 0;
//		}
//		if (nums.length == 1) {
//			return nums[0] >= s ? 1 : 0;
//		}
//
//		int minSum = Integer.MAX_VALUE;
//		int sum = nums[0];
//		if (nums[0] >= s) {
//			return 1;
//		}
//		int flag = 0;
//		// int length = 1;
//
//		int slow = 0;
//		int i = 1;
//
//		while (i < nums.length) {
//			if (nums[i] >= s) {
//				return 1;
//			}
//			if ((Math.abs(nums[i] - nums[i - 1]) == 1 && flag == 0) || (flag == nums[i] - nums[i - 1])) {
//				sum = sum + nums[i];
//				if (sum >= s) {
//					int length = i - slow + 1;
//					if (length < minSum) {
//						minSum = length;
//						slow++;
//						i = slow + 1;
//						sum = nums[slow];
//						flag = 0;
//						continue;
//					}
//				} else {
//					flag = nums[i] - nums[i - 1];
//					i++;
//				}
//			} else {
//				sum = nums[i];
//				flag = 0;
//				i++;
//				slow++;
//			}
//
//		}
//
//		if (minSum == Integer.MAX_VALUE) {
//			return 0;
//		}
//		return minSum;
//	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}
