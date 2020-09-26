package com.lee.aathird;

public class MinimumValuePositiveSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int minStartValue(int[] nums) {
    	int min = 1;
    	int sum = 0;
        for(int n:nums){
        	sum += n;
        	min = Math.max(min, 1-sum);
        }
        return min;
    }

}
