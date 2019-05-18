package com.lee.dp;

public class HouseRobberII213 {

	public static void main(String[] args) {
		HouseRobberII213 obj = new HouseRobberII213();
		System.out.println(obj.rob(new int[]{4,1,2,7,5,3,1}));
	}
	
    public int rob(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}
		if (nums.length == 2) {
			return Math.max(nums[0], nums[1]);
		}
		System.out.println(robOne(nums));
		System.out.println(robTwo(nums));
		return 0;
//		return Math.max(robOne(nums), robTwo(nums));
    }
    
	public int robOne(int[] nums) {
		long[] total = new long[nums.length];
		total[0] = nums[0];
		total[1] = total[0];
		if(nums.length==3){
			total[2] = total[0];
		}else{
			total[2] = nums[2] + nums[0];
		}
		System.out.println("2..." + total[2]);
		for (int i = 3; i < nums.length; i++) {
			if (i < nums.length - 1) {
				total[i] = Math.max(total[i - 1], nums[i] + total[i - 2]);
			} else {
				total[i] = Math.max(total[i - 1], total[i - 2]);
			}
			System.out.println(i + "..." + total[i]);
		}
		return (int) total[nums.length - 1];
	}
	
	public int robTwo(int[] nums) {
		long[] total = new long[nums.length];
		total[0] = 0;
		total[1] = nums[1];
		for (int i = 2; i < nums.length; i++) {
			total[i] = Math.max(total[i - 1], nums[i] + total[i - 2]);
		}
		return (int) total[nums.length - 1];
	}

}
