package com.lee.againt;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		LongestIncreasingSubsequence obj = new LongestIncreasingSubsequence();
		obj.lengthOfLIS(new int[]{10,9,2,4,5,1,3,7,101,18});

	}

	// [10,9,2,5,3,7,101,18]
	public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;

        for(int x : nums) {
            int i = Arrays.binarySearch(dp, 0, len, x);
            if(i < 0) i = -(i + 1);
            dp[i] = x;
            if(i == len) len++;
            System.out.println(len + " " + x + " " + Arrays.toString(dp));
        }

        return len;
	}

}
