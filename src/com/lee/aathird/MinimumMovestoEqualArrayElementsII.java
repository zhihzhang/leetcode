package com.lee.aathird;

import java.util.Arrays;

public class MinimumMovestoEqualArrayElementsII {

	public static void main(String[] args) {
		MinimumMovestoEqualArrayElementsII obj = new MinimumMovestoEqualArrayElementsII();
		System.out.println(obj.minMoves2(new int[]{1,0,0,8,6}));
		System.out.println(obj.minMoves3(new int[]{1,0,0,8,6}));

	}

	public int minMoves2(int[] nums) {
		int sum = 0;
		for (int n : nums) {
			sum += n;
		}
		int l = nums.length;
		int v = sum / l;
		if (v * l != sum) {
			if ((v + 1) * l - sum < sum - v * l) {
				v = v + 1;
			}
		}
		int r = 0;
		for (int n : nums) {
			r += Math.abs(v - n);
		}
		return r;
	}
	
	   public int minMoves3(int[] nums) {
	        Arrays.sort(nums);
	        int i = 0, j = nums.length-1;
	        int count = 0;
	        while(i < j){
	            count += nums[j]-nums[i];
	            i++;
	            j--;
	        }
	        return count;
	    }

}
