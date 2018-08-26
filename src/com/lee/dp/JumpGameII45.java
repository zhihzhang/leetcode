package com.lee.dp;

public class JumpGameII45 {

	public static void main(String[] args) {
		JumpGameII45 obj = new JumpGameII45();
		int[] nums = { 2, 3, 1, 1, 4 };
		// int[] nums = {3,2,1,0,4};
		int value = obj.jump(nums);
		System.out.println(value);
	}
	
	
	//Greedy
	//The main idea is based on greedy. Let's say the range of the current jump is [curBegin, curEnd], 
	//curFarthest is the farthest point that all points in [curBegin, curEnd] can reach. 
	//Once the current point reaches curEnd, then trigger another jump, and set the new curEnd with curFarthest, 
	//then keep the above steps, as the following:
	public int jump(int[] nums) {
		int jumps = 0, curEnd = 0, curFarthest = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			curFarthest = Math.max(curFarthest, i + nums[i]);
            if(curFarthest >= nums.length-1) {
				return jumps + 1;
			}
			if(curFarthest >= nums.length) {
				return jumps;
			}
			if (i == curEnd) {
				jumps++;
				curEnd = curFarthest;
			}
		}
		return jumps;
	}

	//DP
	public int jumpWithDP(int[] nums) {
        if (nums.length == 1) {
			return 0;
		}
		int[] value = new int[nums.length];
		value[0] = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i == 0 || value[i] > 0) {
				int w = nums[i];
				int k = i + w;
				if (k >= nums.length - 1) {
					if (value[nums.length - 1] == 0) {
						value[nums.length - 1] = value[i] + 1;
					} else {
						value[nums.length - 1] = Math.min(value[nums.length - 1], value[i] + 1);
					}
				} else {
					for (int j = i + 1; j <= i + w; j++) {
						if (value[j] == 0) {
							value[j] = value[i] + 1;
						} else {
							value[j] = Math.min(value[j], value[i] + 1);
						}
					}
				}
			}
		}
		return value[nums.length - 1];
	}
}
