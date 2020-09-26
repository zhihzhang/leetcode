package com.lee.aathird;

public class MinimumMoves {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for(int n:nums){
        	sum += n;
        	min = Math.min(min, n);
        }
        int x = sum - nums.length * min;
        return x;
    }

}
