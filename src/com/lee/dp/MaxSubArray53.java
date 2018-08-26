package com.lee.dp;

public class MaxSubArray53 {

	public static void main(String[] args) {
		for(int i=1 ; i<10; ++i){
			System.out.println(i);
		}
		
		int[] array = {-2,1,-3,4,-1,2,1,-5,4};
		int w = maxSubArray(array);
		System.out.println(w);
	}
	
	public static int maxSubArray(int[] nums) {
	    int maxSoFar=nums[0], maxEndingHere=nums[0];
	    for (int i=1;i<nums.length;i++){
	    	maxEndingHere= Math.max(maxEndingHere+nums[i],nums[i]);
	    	maxSoFar=Math.max(maxSoFar, maxEndingHere);	
	    }
	    return maxSoFar;
	}

}
