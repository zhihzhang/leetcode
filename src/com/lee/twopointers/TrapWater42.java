package com.lee.twopointers;

public class TrapWater42 {

	public static void main(String[] args) {
		TrapWater42 obj = new TrapWater42();
		int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
		int h = obj.trap(nums);
		System.out.println(h);
	}

	public int trap(int[] height) {
		if (height == null || height.length < 3) {
			return 0;
		}

		int left = 0;
		int right = height.length - 1;
		int leftH = height[left];
		int rightH = height[right];

		int leftSum = 0;
		int rightSum = 0;
		
		while (left < right) {
			if (height[left] <= height[right]) {
				left++;
				if (height[left] <= leftH) {
					leftSum = leftSum + (leftH - height[left]);
				} else {
					leftH = height[left];
				}
			} else {
				right--;
				if (height[right] <= rightH) {
					rightSum = rightSum + (rightH - height[right]);
				} else {
					rightH = height[right];
				}
			}
		}

		return leftSum + rightSum;
	}

}
