package com.lee.dp;

public class LongestIncreasingSubsequence300 {

	public static void main(String[] args) {
		LongestIncreasingSubsequence300 obj = new LongestIncreasingSubsequence300();
		int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
		// int[] nums = {3,2,1,0,4};
		int value = obj.lengthOfLIS(nums);
		System.out.println(value);
	}

    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        if (nums.length == 1) {
			return 1;
		}
		int max = 0;
		int[] value = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					value[i] = Math.max(value[i], value[j] + 1);
				}
			}
			max = Math.max(max, value[i]);
		}
		return max + 1;
    }

}
